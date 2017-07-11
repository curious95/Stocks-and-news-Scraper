import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aptus on 11/7/17.
 */

public class StocksNSE {

    static  Document doc = null;
    final String TOP_GAINERS_NAME = "#nseGainerDiv .row_GL .row_GL_col1 h4";
    final String TOP_GAINERS_RATIO = "#nseGainerDiv .row_GL .row_GL_col3";
    final String TOP_LOSERS_NAME = "#nseLoserDiv .row_GL .row_GL_col1 h4";
    final String TOP_LOSERS_RATIO = "#nseLoserDiv .row_GL .row_GL_col3";
    final String NSE_INDEX = "#nseindex";

    StocksNSE(){
       try {
           doc = Jsoup.connect("http://money.rediff.com/index.html").userAgent("Mozilla").data("name", "jsoup").get();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    // Top Five Gainers
    HashMap<String,String> getGainers(){
        int i = 0;

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
            topGainers.put(org,orgPercent.get(i));
            i++;
        }
    return topGainers;

    }

    // Top Five Losers
    HashMap<String,String> getLosers(){
        int i = 0;

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
            topLosers.put(org,orgPercent.get(i));
            i++;
        }

        return topLosers;
    }

    String getIndex(){
        Elements index = doc.select(NSE_INDEX);

        return(index.get(0).text());
    }
}
