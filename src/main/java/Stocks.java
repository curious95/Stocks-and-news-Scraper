import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by aptus on 11/7/17.
 */
public class Stocks {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://money.rediff.com/index.html").userAgent("Mozilla").data("name", "jsoup").get();

            Elements links = doc.select("#bseindex");

            for (Element link : links) {
                // get the value from the href attribute
                System.out.println("text: " + link.text());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
