package cn.bayllech.thread;

import cn.bayllech.pojo.Song;
import cn.bayllech.pojo.WebPage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author bei.qi
 * @Description 爬虫线程
 * @Date 2017-09-08 14:23
 */
public class CrawlerThread {
    private String BASE_URL = "http://music.163.com/";

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

    private List<WebPage> parsePlaylists(WebPage webPage) {
        List<WebPage> webPages = new ArrayList<>();
        Elements songs = Jsoup.parse(webPage.getHtml()).select("#m-pl-container li p.dec a");
        return songs.stream().map(e -> new WebPage(BASE_URL + e.attr("href"), WebPage.PageType.playlists, e.html())).collect(Collectors.toList());
    }

    private List<WebPage> parsePlaylist(WebPage webPage) {
        List<WebPage> webPages = new ArrayList<>();
        Elements songs = Jsoup.parse(webPage.getHtml()).select("ul.f-hide li a");
        return songs.stream().map(e -> new WebPage(BASE_URL + e.attr("href"), WebPage.PageType.playlist, e.html())).collect(Collectors.toList());
    }

 /*   private Song parseSong(WebPage webPage) throws Exception {
        return new Song(webPage.getUrl(), webPage.getTitle(), getCommentCount(webPage.getUrl().split("=")[1]));
    }
*/
    public static void main(String[] args) throws IOException {
        WebPage webPage = new WebPage("http://music.163.com/discover/playlist/?order=hot&cat=%E5%85%A8%E9%83%A8&limit=35&offset=0", WebPage.PageType.playlists);
        CrawlerThread crawlerThread = new CrawlerThread();
        crawlerThread.fetchHtml(webPage);
        System.out.println(webPage.getHtml());
//        System.out.println(crawlerThread.parsePlaylists(webPage));
//        System.out.println(crawlerThread.parsePlaylist(webPage));

    }


}
