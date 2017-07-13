import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Curious95 on 11/7/17.
 */

public class StocksBSE {

    static  Document doc = null;
    final String TOP_GAINERS_NAME = "#bseGainerDiv .row_GL .row_GL_col1 h4";
    final String TOP_GAINERS_RATIO = "#bseGainerDiv .row_GL .row_GL_col3";
    final String TOP_LOSERS_NAME = "#bseLoserDiv .row_GL .row_GL_col1 h4";
    final String TOP_LOSERS_RATIO = "#bseLoserDiv .row_GL .row_GL_col3";
    final String BSE_INDEX = "#bseindex";
    final String CHANGE_PERCENT = "span .green";



    StocksBSE(){
        try {
            doc = Jsoup.connect("http://money.rediff.com/index.html").userAgent("Mozilla").data("name", "jsoup").get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // Top Five Gainers
    HashMap<String, String> getGainers(){
        int i = 0;

        ArrayList<String> orgName = new ArrayList<String>();
        ArrayList<String> orgPercent = new ArrayList<String>();

        HashMap<String,String> topGainers = new HashMap<String, String>();

        Elements orgs = doc.select(TOP_GAINERS_NAME);

        for (Element org : orgs) {
            orgName.add(org.text());
        }

        Elements changes = doc.select(TOP_GAINERS_RATIO);

        for (Element change : changes) {
            orgPercent.add(change.text());
        }

        for(String org : orgName){
            topGainers.put(org,orgPercent.get(i));
            i++;
        }

    return topGainers;
    }

    // Top Five Losers
    HashMap<String, String> getLosers(){
        int i = 0;

        ArrayList<String> orgName = new ArrayList<String>();
        ArrayList<String> orgPercent = new ArrayList<String>();

        HashMap<String,String> topLosers = new HashMap<String, String>();

        Elements orgs = doc.select(TOP_LOSERS_NAME);

        for (Element org : orgs) {
            orgName.add(org.text());
        }

        Elements changes = doc.select(TOP_LOSERS_RATIO);

        for (Element change : changes) {
            orgPercent.add(change.text());
        }

        for(String org : orgName){
            topLosers.put(org,orgPercent.get(i));
            i++;
        }

    return topLosers;
    }

    String getIndex(){
        Elements index = doc.select(BSE_INDEX);

        return(index.get(0).text());
    }
}
