package sortData;

import data.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Latitude on 17.8.2016.
 */
public class SortData {

    public List<Data> createTable(String timescale, String country, List<Data> list) {
        List<Data> result = list.stream()
                .filter(data -> data.timeScale.equals(timescale))
                .filter(data -> data.country.equals(country))
                .collect(Collectors.toList());

        double totalUnits = 0;
        for (Data data : result) {
            totalUnits = totalUnits + data.getUnits();
        }
        Data total = new Data(country, timescale, "Total", totalUnits);
        result.add(total);
        return result;
    }

    public String findUnitAndPercByVendor(String vendor, List<Data> dataList) {
        List<Data> result = dataList.stream().filter(o -> o.getVendor().equals(vendor)).collect(Collectors.toList());
        return result.get(0).getUnits().toString() + " and " + result.get(0).getUnits() / dataList.get((dataList.size() - 1)).getUnits() * 100 + "%";
    }

    public String findRowByVendor(String vendor, List<Data> dataList) {
        List<Data> result = dataList.stream().filter(o -> o.getVendor().equals(vendor)).collect(Collectors.toList());
        return "Row:" + (dataList.indexOf(result.get(0)) + 1);
    }

    public List<Data> sortRowsAlpha(List<Data> dataList) {
        return dataList
                .stream()
                .sorted((object1, object2) -> object1.getVendor().compareTo(object2.getVendor()))
                .collect(Collectors.toList());
    }
}


