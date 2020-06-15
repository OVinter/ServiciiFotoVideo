package servicii.foto;

import servicii.Servicii;

public abstract class ServiciiFoto implements Servicii {

    protected String data;
    protected boolean studio;
    protected boolean stick;
    protected boolean album;
    protected double nrMinute;
    protected int pretOra;
    protected double pretTotal;
    protected String numeClient;
    protected final double pretAlbum = 50;


    public ServiciiFoto(String numeClient, String data, boolean studio, boolean album) {
        this.numeClient = numeClient;
        this.data = data;
        this.studio = studio;
        this.stick = true;
        this.album = album;
    }

    @Override
    public double getCostTotal() {
        return this.pretTotal;
    }

    /*public boolean isAlbum() {
        return album;
    }*/

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public String getNumeClient() {
        return this.numeClient;
    }

    @Override
    public String informatiiServici() {
        return "Ati ales servicii foto";
    }

    //@Override
    public double getPretAlbum() {
        if (album)
            return pretAlbum;
        return 0;
    }
}
