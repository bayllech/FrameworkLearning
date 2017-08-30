/**
 var template1="我是{0}，今年{1}了";
 var template2="我是{name}，今年{age}了";
 var result1=template1.format("loogn",22);
 var result2=template2.format({name:"loogn",age:22});
 **/
String.prototype.format = function (args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    var reg = new RegExp("({[" + i + "]})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
}
var pagination = {};
/**
 *
 */
var pagination_vo = function () {
    //分页的总数据
    this.total;
    //当前页
    this.page;
    //每页的内容数
    this.pagesize;
    //最后一页
    this.lastpage;
    //共计多少分页
    this.loopcount;
    //前一页
    this.previous;
    //后一页
    this.next;
    //是否显示前一页
    this.isprevious;
    //是否显示后一页
    this.isnext;
    //开始
    //例如：1 2 3 4 5 6，则指1；4 5 6 7 8 9，则指4
    this.begin;
    //结束
    this.end;
    //步长
    this.step;
    //是否可以前进，指">>"
    this.isforward;
    //是否可以后退，指"<<"
    this.isback;
    //前进到第几页
    this.forward;
    //后退到第几页
    this.back;
    //偏移量
    this.offset;
    //begin -> end 时的步长
    this.length;
}
var oldpage = -1;
/**
 *
 *  Pagination Node.js Library
 *
 *  Author    : Kenshin
 *  Emil      : kenshin@ksria.com
 *  version   : 1.0
 *  Date      : 2012-5-5
 *  Blog      : http://www.k-zone.cn/zblog
 *  Project   : https://github.com/kenshin/node-pagination
 *  Dual licensed under the MIT or GPL Version 2 licenses
 *
 *  Copyright 2012
 *
 * total      : 总数
 * page       : 当前页
 * pagesize   : 每页包含的内容
 * offset     : 偏移量（例如1 2 3 4 5 6，点击6时，产生4 5 6 7 8 9，而非 7 8 9 10 11 12）
 * length     : 步长
 *
 */
pagination.build = function (total, page, pagesize, offset, length) {
    page = page < 1 ? 1 : page;
    //最后一页
    //计算方法：最大文章数 / 每页文章数
    var lastpage = parseInt((total + pagesize - 1) / pagesize);
    //共有多少个分页
    var loopcount = Math.ceil(lastpage / pagesize);
    //重新计算
    page = page > lastpage ? 1 : page;
    //前一页、后一页
    var previous = parseInt(page) - 1;
    var next = parseInt(page) + 1;
    //是否显示前一页/后一页
    var isprevious, isnext;
    isnext = next - 1 < lastpage ? true : false;
    isprevious = parseInt(previous) > 0 ? true : false;
    //开始 结束 步长
    var begin, end, step;
    //计算步长
    step = lastpage > length ? length : lastpage;
    //计算开始
    //1 2 3 4 5 6
    //点击6时，产生4 5 6 7 8 9
    //而非 7 8 9 10 11 12
    //if ( lastpage - page < step ) {
    //	begin   = lastpage - step + 1;
    //}
    //else if ( offset > 0 ) {
    //	begin   = page    <= offset        ? 1              : page - offset;
    //}
    if (offset > 0) {
        begin = page <= offset ? 1 : page - offset;
    }
    else if (offset == 0 && page == 1) {
        begin = 1;
    }
    else if (page != 1 && oldpage < page) {
        begin = page < pagesize ? 1 : page;
    }
    else if (page != 1 && oldpage >= page) {
        begin = page < pagesize ? 1 : page - step + 1;
    }
    //计算结束
    end = parseInt(begin) + parseInt(step);
    if (end - begin + 1 != step) {
        end = begin + step;
    }
    if (begin + step - 1 > lastpage) {
        begin = lastpage - step + 1;
        end = lastpage + 1;
    }
    //如果end比lastpage大的话，赋值为lastpage
    end = end >= lastpage ? lastpage : end;
    //前滚、后滚
    //是否显示>> and <<
    var isforward, isback;
    isforward = lastpage - end >= 1 ? true : false;
    isback = begin > 1 ? true : false;
    //前进/后退到第几页
    var forward, back;
    back = begin - 1 <= 0 ? 1 : begin - 1;
    forward = end;
    //backup page
    oldpage = page;
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    var pv = new pagination_vo();
    //总数
    pv.total = total;
    //当前页
    pv.page = parseInt(page);
    //每页的内容数
    pv.pagesize = pagesize;
    //最后一页
    pv.lastpage = lastpage;
    //共计多少分页
    pv.loopcount = loopcount;
    //前一页
    pv.previous = previous;
    //后一页
    pv.next = next;
    //是否显示前一页
    pv.isprevious = isprevious;
    //是否显示后一页
    pv.isnext = isnext;
    //开始
    pv.begin = begin;
    //结束
    pv.end = end;
    //步长
    pv.step = step;
    //是否可以前进，指">>"
    pv.isforward = isforward;
    //是否可以后退，指"<<"
    pv.isback = isback;
    //前进到第几页
    pv.forward = forward;
    //后退到第几页
    pv.back = back;
    //偏移量
    pv.offset = offset;
    //begin -> end 时的步长
    pv.length = length;
    //if (window.console) {
    //    console.log("pv.page           = " + pv.page);
    //    console.log("pv.total          = " + pv.total);
    //    console.log("pv.loopcount      = " + pv.loopcount);
    //    console.log("pv.pagesize       = " + pv.pagesize);
    //    console.log("pv.lastpage       = " + pv.lastpage);
    //    console.log("pv.begin          = " + pv.begin);
    //    console.log("pv.end            = " + pv.end);
    //    console.log("pv.previous       = " + pv.previous);
    //    console.log("pv.next           = " + pv.next);
    //    console.log("pv.isprevious     = " + pv.isprevious);
    //    console.log("pv.isnext         = " + pv.isnext);
    //    console.log("pv.isforward      = " + pv.isforward);
    //    console.log("pv.isback         = " + pv.isback);
    //    console.log("pv.forward        = " + pv.forward);
    //    console.log("pv.back           = " + pv.back);
    //    console.log("pv.offset         = " + pv.offset);
    //    console.log("pv.length         = " + pv.length);
    //}
    return pv;
}
/**
 desc:获得分页数据
 total:总数
 page:当前页
 pageSize:每页显示的数据条数
 offset:偏移量（例如1 2 3 4 5 6，点击6时，产生4 5 6 7 8 9，而非 7 8 9 10 11 12）
 length:begin -> end 时的步长,例如 上一页 2 3 4 5 6 下一页，则步长为5
 url:页面地址
 **/
pagination.getPageHtml = function (total, page, pageSize, offset, length, url) {
    var isUrl = url.indexOf("http") > -1 ? true : false;
    if (isUrl) {
        url += url.indexOf("?") == -1 ? "?" : "&";
    }
    var info = pagination.build(total, page, pageSize, offset, length);
    var pageHtml = '<div class="col-md-5 col-sm-12" style="padding-left:0px;">';

    pageHtml += '<div class="dataTables_info">当前第 <strong style=\"color:red;\">{p}</strong> 页，'.format({ p: info.page });
    pageHtml += '共 <strong style=\"color:red;\">{lastpage}</strong> 页 ，'.format({ lastpage: info.lastpage });
    pageHtml += '总共 <strong style=\"color:red;\">{total}</strong> 条数据&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></div>'.format({ total: info.total });

    pageHtml += '<div class="col-md-7 col-sm-12" style="padding-right:0px;"><div class="dataTables_paginate paging_simple_numbers"><ul class="pagination">';
    if (total > pageSize)
    {

        var _url = isUrl ? "{url}p=1&total={total}" : url;
        _url = _url.format({ url: url, total: info.total });
        pageHtml += '<li title = "首页"><a href="{url}">《</a></li>'.format({ url: "javascript:PageReport({p:1})" });
        if (info.isprevious) {
            _url = isUrl ? "{url}p={p}&total={total}" : url;
            _url = _url.format({ url: url, p: info.previous, total: info.total });
            pageHtml += '<li title = "上一页"><a href="{url}"><</a></li>'.format({ url: _url });
        }
        else {
            pageHtml += '<li title = "上一页" class="disabled"><a href="javascript:;"><</a></li>';
        }
        for (var i = info.begin; i <= info.end; i++) {
            if (i == info.page) {
                pageHtml += '<li class="active"><a href="javascript:;">{p}<span class="sr-only">(current)</span></a></li>'.format({ p: info.page });
                continue;
            }
            _url = isUrl ? "{url}p={p}&total={total}" : url;
            _url = _url.format({ url: url, p: i, total: info.total });
            pageHtml += '<li><a href="{url}">{p}</a></li>'.format({ url: _url, p: i });
        }
        if (info.isnext) {
            _url = isUrl ? "{url}p={p}&total={total}" : url;
            _url = _url.format({ url: url, p: info.next, total: info.total });
            pageHtml += '<li title = "下一页"><a href="{url}">></a></li>'.format({ url: _url });
        }
        else {
            pageHtml += '<li title = "下一页" class="disabled"><a href="javascript:;">></a></li>';
        }
        _url = isUrl ? "{url}p={p}&total={total}" : url;
        _url = _url.format({ url: url, p: info.lastpage, total: info.Total });
        pageHtml += '<li title = "尾页"><a href="{url}">》</a></li>'.format({ url: _url });
    }
    pageHtml += '</ul></div></div>';
    return pageHtml;
}