package fr._42.pdespres.avaj_launcher.aircraft;

/*
**  pas de set, il faut passer de new coord a chaque fois
*/

public class Coordinates {

    private int     longitude;
    private int     latitude;
    private int     height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100)
            height = 100;
        if (height < 0)
            height = 0;
        this.height = height;
        if (this.longitude < 0)
            this.longitude = 0;
        if (this.latitude < 0)
            this.latitude = 0;
    }

    public int getLongitude()
    {
        return (this.longitude);
    }

    public int getLatitude() {
        return (this.latitude);
    }

    public int getHeight() {
        return (this.height);
    }
}
