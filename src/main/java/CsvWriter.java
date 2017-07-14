import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aptus on 14/7/17.
 */
public class CsvWriter {
    private static final Object[] FILE_HEADER = {"news_id", "time_id","timestamp" ,"news", "news_category",
                "news_link", "BSE_points", "NSE_points", "BSE_G1", "BSE_G2", "BSE_G3", "BSE_G4",
                "BSE_G5", "BSE_L1", "BSE_L2", "BSE_L3", "BSE_L4", "BSE_L5", "NSE_G1", "NSE_G2",
                "NSE_G3", "NSE_G4", "NSE_G5", "NSE_L1", "NSE_L2", "NSE_L3", "NSE_L4", "NSE_L5"};

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

    FileWriter fileWriter = null;
    CSVPrinter csvFilePrinter = null;

    static boolean head_status = false;


    void fileWriter(ArrayList<List> newsRecords){
        try{

            if(head_status!=true) {
                fileWriter = new FileWriter("test.csv");


                csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
                csvFilePrinter.printRecord(FILE_HEADER);
            }

            for(List l1 : newsRecords){

                csvFilePrinter.printRecord(l1);
                //System.out.println(l1.toString());
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
