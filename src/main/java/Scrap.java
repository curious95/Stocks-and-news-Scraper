import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Curious95 on 10/7/17.
 */
public class Scrap {

    public static List newsRecord = new ArrayList();
    public static ArrayList<List> Allrecords = new ArrayList<List>();

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

        CsvWriter writeRecord = new CsvWriter();

        /*neEconomy.entrySet().forEach(item->{
            System.out.println(item.getKey());
        });*/

        Scrap sc = new Scrap();

        for (Map.Entry<String, String> entry : neEconomy.entrySet()) {

            newsRecord = new ArrayList();

            newsRecord.add(hash.generateHash(entry.getKey()));
            newsRecord.add(hash.generateHash(new java.util.Date().toString()));
            newsRecord.add(new java.util.Date());
            newsRecord.add(entry.getKey());
            newsRecord.add("Economy");
            newsRecord.add(entry.getValue());
            newsRecord.add(seIndex);
            newsRecord.add(neIndex);

            seGainers.entrySet().forEach(gn -> {
                newsRecord.add(gn.getKey());
            });
            seLosers.entrySet().forEach(gn -> {
                newsRecord.add(gn.getKey());
            });
            neGainers.entrySet().forEach(gn -> {
                newsRecord.add(gn.getKey());
            });
            neLosers.entrySet().forEach(gn -> {
                newsRecord.add(gn.getKey());
            });

            Allrecords.add(newsRecord);
        }

        writeRecord.fileWriter(Allrecords);

    }

}
