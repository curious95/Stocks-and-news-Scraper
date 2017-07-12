import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Kamal on 11/7/17.
 */
public class Newscraper {

    final String ECONOMY_ENDPOINT = "https://news.google.com/news/headlines/section/q/economy/economy?ned=in&hl=en-IN";
    final String COUNTYR_ENDPOINT = "https://news.google.com/news/headlines/section/topic/NATION.en_in/India?ned=in&hl=en-IN";
    final String BUSINESS_ENDPOINT = "https://news.google.com/news/headlines/section/topic/BUSINESS.en_in/Business?ned=in&hl=en-IN";

    final String CLASS_ID = "nuEeue hzdq5d ME7ew";

    Document doc = null;
    Elements links = null;


    void fetchEconomy(){
        try{
        doc = Jsoup.connect(ECONOMY_ENDPOINT).userAgent("Mozilla").data("name", "jsoup").get();
            links = doc.getElementsByClass(CLASS_ID);
            links.forEach(item-> System.out.println(item.text()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void fetchCountry(){
        try{
            doc = Jsoup.connect(COUNTYR_ENDPOINT).userAgent("Mozilla").data("name", "jsoup").get();
            links = doc.getElementsByClass(CLASS_ID);

            links.forEach(item-> System.out.println(item.text()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void fetchBusiness(){
        try{
            doc = Jsoup.connect(BUSINESS_ENDPOINT).userAgent("Mozilla").data("name", "jsoup").get();
            links = doc.getElementsByClass(CLASS_ID);
            links.forEach(item-> System.out.println(item.text()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
