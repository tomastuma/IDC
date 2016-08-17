package fileUtils;

import data.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Latitude on 17.8.2016.
 */
public class FileUtils {



    private File source;

    public FileUtils(File source) {
        this.source = source;
    }


    public  List<Data> getDataFromFile() throws IOException {
        List<Data> dataList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(source));
        try {
            String line = br.readLine();
             line = br.readLine();
            while (line != null) {
                dataList.add(createData(line));
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return dataList;
    }

    public Data createData(String line){

        int splitIndex = line.indexOf(',');
        String country = line.substring(0, splitIndex);

        line = line.substring(splitIndex+1);
        splitIndex = line.indexOf(',');
        String timeScale = line.substring(0, splitIndex);
        line = line.substring(splitIndex+1);
        splitIndex = line.indexOf(',');
        String vendor = line.substring(0, splitIndex);


         String unit = line.substring(splitIndex+1);
         unit = unit.replace(".", "");
         Double units = Double.valueOf(unit);

        return new Data(country,timeScale,vendor,units);


    }
}
