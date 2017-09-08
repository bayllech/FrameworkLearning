package cn.bayllech.thread;

import cn.bayllech.pojo.WebPage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * @Author bei.qi
 * @Description 爬虫线程
 * @Date 2017-09-08 14:23
 */
public class CrawlerThread {

    /**
     * 抓取网页数据是否连通
     *
     * @param webPage 网页参数
     * @return 成功、失败
     */
    private boolean fetchHtml(WebPage webPage) throws IOException {
        Connection.Response response = Jsoup.connect(webPage.getUrl()).timeout(3000).execute();
        webPage.setHtml(response.body());
        return response.statusCode() == 200 ? true : false;

    }

    public static void main(String[] args) throws IOException {
        WebPage webPage = new WebPage("http://music.163.com/#/discover/playlist");
        CrawlerThread crawlerThread = new CrawlerThread();
        crawlerThread.fetchHtml(webPage);
        System.out.println(webPage.getHtml());
    }


}
