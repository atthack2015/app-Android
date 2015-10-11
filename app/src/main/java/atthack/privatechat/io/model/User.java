package atthack.privatechat.io.model;

/**
 * Created by LEONARDO on 11/10/2015.
 */
public class User {

    private String name;
    private double longitud;
    private double latitud;

    public User(String name, double longitud, double latitud) {
        this.name = name;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getName() {
        return name;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }
}
