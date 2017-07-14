import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;

/**
 * Created by Curious95 on 10/7/17.
 */
public class Scrap {
    public static void main(String[] args) {

        StocksBSE se = new StocksBSE();
        StocksNSE ne = new StocksNSE();
        Newscraper nes = new Newscraper();
        Hasher hash = new Hasher();

        HashMap<String, String> seGainers = se.getGainers();
        HashMap<String, String> seLosers = se.getLosers();
        HashMap<String, String> neGainers = se.getGainers();
        HashMap<String, String> neLosers = se.getLosers();

        String seIndex = se.getIndex();
        String neIndex = ne.getIndex();

        HashMap<String, String> neEconomy = nes.fetchEconomy();
        HashMap<String, String> neBusiness = nes.fetchBusiness();
        HashMap<String, String> neCountry = nes.fetchCountry();


        neEconomy.entrySet().forEach(item->{

        });


        System.out.println(hash.generateHash(new java.util.Date().toString()));




    }
}
