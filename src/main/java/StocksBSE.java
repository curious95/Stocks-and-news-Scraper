import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aptus on 11/7/17.
 */

public class StocksBSE {

    static  Document doc = null;
    final String TOP_GAINERS_NAME = "#bseGainerDiv .row_GL .row_GL_col1 h4";
    final String TOP_GAINERS_RATIO = "#bseGainerDiv .row_GL .row_GL_col3";
    final String TOP_LOSERS_NAME = "#bseLoserDiv .row_GL .row_GL_col1 h4";
    final String TOP_LOSERS_RATIO = "#bseLoserDiv .row_GL .row_GL_col3";
    public static void main(String[] args) {



        try {
            doc = Jsoup.connect("http://money.rediff.com/index.html").userAgent("Mozilla").data("name", "jsoup").get();

            Elements links = doc.select("#bseGainerDiv .row_GL .row_GL_col3");

            StocksBSE obj = new StocksBSE();


        }catch (Exception e){
            e.printStackTrace();
        }
    }



    // Top Five Gainers
    void getGainers(){

        ArrayList<String> orgName = new ArrayList<String>();
        ArrayList<String> orgPercent = new ArrayList<String>();

        HashMap<String,String> topGainers = new HashMap<String, String>();

        Elements orgs = doc.select(TOP_GAINERS_NAME);

        for (Element org : orgs) {
            // get the value from the href attribute
            //System.out.println("text: " + link.text());
            orgName.add(org.text());
        }

        Elements changes = doc.select(TOP_GAINERS_RATIO);

        for (Element change : changes) {
            // get the value from the href attribute
            //System.out.println("text: " + link.text());
            orgPercent.add(change.text());
        }

        for(String org : orgName){
            int i = 0;
            topGainers.put(org,orgPercent.get(i));
            i++;
        }


    }

    // Top Five Losers
    void getLosers(){

        ArrayList<String> orgName = new ArrayList<String>();
        ArrayList<String> orgPercent = new ArrayList<String>();

        HashMap<String,String> topLosers = new HashMap<String, String>();

        Elements orgs = doc.select(TOP_LOSERS_NAME);

        for (Element org : orgs) {
            // get the value from the href attribute
            //System.out.println("text: " + link.text());
            orgName.add(org.text());
        }

        Elements changes = doc.select(TOP_LOSERS_RATIO);

        for (Element change : changes) {
            // get the value from the href attribute
            //System.out.println("text: " + link.text());
            orgPercent.add(change.text());
        }

        for(String org : orgName){
            int i = 0;
            topLosers.put(org,orgPercent.get(i));
            i++;
        }

    }
}
