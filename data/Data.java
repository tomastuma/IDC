package data;

/**
 * Created by Latitude on 17.8.2016.
 */
public class Data {

    public String country;
    public String timeScale;
    private String vendor;
    private Double units;

    public Data(String country, String timeScale, String vendor, Double units) {
        this.country = country;
        this.timeScale = timeScale;
        this.vendor = vendor;
        this.units = units;
    }


    public String getVendor() {
        return vendor;
    }


    public Double getUnits() {
        return units;
    }

}
