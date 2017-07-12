import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

/**
 * Created by kamal on 10/7/17.
 */
public class Scrap {
    public static void main(String[] args) {

        /*StocksBSE se = new StocksBSE();
        StocksNSE ne = new StocksNSE();

        HashMap<String,String> gainersBSE = se.getLosers();

        gainersBSE.entrySet().forEach(entry -> {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        });*/


        Newscraper ns = new Newscraper();
        ns.fetchBusiness();
    }
}
