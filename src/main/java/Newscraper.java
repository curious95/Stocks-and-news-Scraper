import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;

/**
 * Created by Curious95 on 11/7/17.
 */
public class Newscraper {

    final String ECONOMY_ENDPOINT = "https://news.google.com/news/headlines/section/q/economy/economy?ned=in&hl=en-IN";
    final String COUNTYR_ENDPOINT = "https://news.google.com/news/headlines/section/topic/NATION.en_in/India?ned=in&hl=en-IN";
    final String BUSINESS_ENDPOINT = "https://news.google.com/news/headlines/section/topic/BUSINESS.en_in/Business?ned=in&hl=en-IN";

    final String CLASS_ID = "nuEeue hzdq5d ME7ew";

    Document doc = null;
    Elements links = null;


    HashMap<String,String> fetchEconomy(){

        HashMap<String,String> economyNews= new HashMap<String,String>();

        try{
        doc = Jsoup.connect(ECONOMY_ENDPOINT).userAgent("Mozilla").data("name", "jsoup").get();
            links = doc.getElementsByClass(CLASS_ID);
            links.forEach(item-> economyNews.put(item.text(),item.attr("href")));
        }catch (Exception e){
            e.printStackTrace();
        }

        return economyNews;
    }

    HashMap<String, String> fetchCountry(){
        HashMap<String,String> countryNews = new HashMap<String,String>();
        try{
            doc = Jsoup.connect(COUNTYR_ENDPOINT).userAgent("Mozilla").data("name", "jsoup").get();
            links = doc.getElementsByClass(CLASS_ID);

            links.forEach(item-> countryNews.put(item.text(),item.attr("href")));
        }catch (Exception e){
            e.printStackTrace();
        }

        return countryNews;
    }

    HashMap<String,String> fetchBusiness(){
        HashMap<String,String> businessNews = new HashMap<String,String>();
        try{
            doc = Jsoup.connect(BUSINESS_ENDPOINT).userAgent("Mozilla").data("name", "jsoup").get();
            links = doc.getElementsByClass(CLASS_ID);
            links.forEach(item-> businessNews.put(item.text(),item.attr("href")));
        }catch (Exception e){
            e.printStackTrace();
        }

        return businessNews;
    }


}
