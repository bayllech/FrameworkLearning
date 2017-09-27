    // 对Date的扩展，将 Date 转化为指定格式的String   
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
    // 例子：   
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
    Date.prototype.format = function(fmt)   
    { //author: meizz   
      var o = {   
        "M+" : this.getMonth()+1,                 //月份   
        "d+" : this.getDate(),                    //日   
        "h+" : this.getHours(),                   //小时   
        "m+" : this.getMinutes(),                 //分   
        "s+" : this.getSeconds(),                 //秒   
        "q+" : Math.floor((this.getMonth()+3)/3), //季度   
        "S"  : this.getMilliseconds()             //毫秒   
      };   
      if(/(y+)/.test(fmt))   
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
      for(var k in o)   
        if(new RegExp("("+ k +")").test(fmt))   
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
      return fmt;   
    }  
    

    function Date_Ex(value1) {
         var strDate = value1+"";
         if (strDate.length == 0)
          return false;

         //先判断是否为短日期格式：YYYY-MM-DD，如果是，将其后面加上00:00:00，转换为YYYY-MM-DD hh:mm:ss格式
         var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})/;   //短日期格式的正则表达式
         var r = strDate.match(reg);

         if (r != null)   //说明strDate是短日期格式，改造成长日期格式
           strDate = strDate + " 00:00:00";

         reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})/;
         r = strDate.match(reg);
         if (r == null) {
            //alert("你输入的日期格式有误，正确格式为：2004-12-01 或 2004-12-01 12:23:45");
            return false;
         }

         var d = new Date(r[1], r[3]-1,r[4],r[5],r[6],r[7]);
         if (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]&&d.getHours()==r[5]&&d.getMinutes()==r[6]&&d.getSeconds()== r[7]) {
          return d;
         } else {
          //alert("你输入的日期或时间超出有效范围，请仔细检查！");
          return false;
         }
    }

   String.prototype.trim = function() {
	    return this.replace(/(^\s*)|(\s*$)/g, "");
	};


    jQuery.prototype.serializeObject = function () {
      var obj = {};
        $.each(this.serializeArray(),function(index,param){
            if(!(param.name in obj)){
                obj[param.name]=param.value;
            }
        });
        return obj;
    };

    DateParse = function (value) {

        if (value == null || value == '') {
            return '';
        }
        var dt;
        if (value instanceof Date) {
            dt = value;
        } else {
            dt = new Date(value);
        }
        return dt.format("yyyy-MM-dd hh:mm:ss")
    }

    function ajaxError(XMLHttpRequest, textStatus, errorThrown) {
        if(XMLHttpRequest.status=='200' && XMLHttpRequest.readyState==4 && textStatus =='parsererror'){
            $.messager.alert("提示", "无权限3秒后跳转登录页面!", "error");
            setTimeout(function() {
                window.location.href="/login";
            }, 3000)
            ;
        }else {
            window.ajaxStatus = 1;
            $.messager.alert("提示", "连接服务器失败，请检查网络连接", "question");
        }
    }
