package servicii.video;

import servicii.Servicii;

public abstract class ServiciiVideo implements Servicii {

    protected String data;
    protected int secunde;
    protected int pretMinut;
    protected double pretTotal;
    protected final boolean stick = true;
    protected String numeClient;

    public ServiciiVideo(String numeClient, String data, int secunde) {
        this.numeClient = numeClient;
        this.data = data;
        this.secunde = secunde;
    }
    @Override
    public double getCostTotal() {
        return this.pretTotal;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public String getNumeClient(){
        return this.numeClient;
    }

    @Override
    public String informatiiServici() {
        return "Ati ales servicii video";
    }
}
