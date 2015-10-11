package atthack.privatechat.io.model;

/**
 * Created by LEONARDO on 11/10/2015.
 */
public class Update {
    private String key;
    private double lon;
    private double lat;

    public Update(String key, double lon, double lat) {
        this.key = key;
        this.lon = lon;
        this.lat = lat;
    }

    public String getKey() {
        return key;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
