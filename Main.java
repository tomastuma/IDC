import data.Data;
import export.ExportToHTML;
import fileUtils.FileUtils;
import sortData.SortData;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Latitude on 17.8.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        boolean sortRowsAlpha = false;
        String vendor = "Dell";
        String country = "Czech Republic";
        String Quarter = "2010 Q4";

        run(vendor, country, Quarter,sortRowsAlpha);

    }

    private static void run(String vendor, String country, String quarter,boolean sortRowsAlpha) throws IOException {

        // Set where load data file
        File dataCsv = new File("C:\\Users\\Latitude\\Downloads\\data.csv");
        FileUtils fu = new FileUtils(dataCsv);
        List<Data> data =  fu.getDataFromFile();


        SortData sd = new SortData();

            List<Data> sortedByQuarterAndState = sd.createTable(quarter,country,data);

        if(sortRowsAlpha) {
            sortedByQuarterAndState = sd.sortRowsAlpha(sortedByQuarterAndState);
        }
        // Set path where to create new html file
        ExportToHTML exp = new ExportToHTML("C:\\Users\\Latitude\\Documents\\htmlexport\\exporthtml.html");
        exp.create(sortedByQuarterAndState);
        System.out.println(sd.findUnitAndPercByVendor(vendor,sortedByQuarterAndState ));
        System.out.println(sd.findRowByVendor(vendor, sortedByQuarterAndState));



        exp.create(sortedByQuarterAndState);
    }


}
