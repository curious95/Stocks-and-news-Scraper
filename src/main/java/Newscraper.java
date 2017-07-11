import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by aptus on 11/7/17.
 */
public class Newscraper {


    void fetchNews(){
        try {

            Document doc = Jsoup.connect("https://news.google.com/news/headlines/section/topic/NATION.en_in/India?ned=in&hl=en-IN").userAgent("Mozilla").data("name", "jsoup").get();

            Elements links = doc.getElementsByClass("nuEeue hzdq5d ME7ew");

            for (Element link : links) {
                // get the value from the href attribute
                System.out.println("\nlink: " + link.attr("href"));
                System.out.println("text: " + link.text());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
