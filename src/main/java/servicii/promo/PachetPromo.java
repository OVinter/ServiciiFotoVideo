package servicii.promo;

import servicii.Servicii;
import servicii.foto.ServiciiFoto;
import servicii.video.VideoHighlights;
import servicii.foto.SedintaFotoSimpla;

import java.util.ArrayList;

public class PachetPromo implements Servicii {

    private String numeClient;
    private String data;
    private boolean album = true;
    private int nrFotografi;
    private int nrVideografi;
    private int nrMinute;
    private ArrayList<Servicii> servicii = new ArrayList<Servicii>();

    public PachetPromo(String numeClient, String data, int nrFotografi, int nrVideografi) {
        this.numeClient = numeClient;
        this.data = data;
        //this.album = album;
        this.nrFotografi = nrFotografi;
        this.nrVideografi = nrVideografi;
        this.nrMinute = 8 * 60;


        if (nrFotografi == 2 && nrVideografi == 0) {
            servicii.add(new SedintaFotoSimpla(numeClient, data, false, album, nrMinute));
            servicii.add(new SedintaFotoSimpla(numeClient, data, false, album, nrMinute));
        } else if (nrVideografi == 2 && nrFotografi == 0) {
            servicii.add(new VideoHighlights(numeClient, data, 120));
            servicii.add(new VideoHighlights(numeClient, data, 120));
        } else if (nrFotografi == 1 && nrVideografi == 1) {
            servicii.add(new SedintaFotoSimpla(numeClient, data, false, album, nrMinute));
            servicii.add(new VideoHighlights(numeClient, data, 120));
        } else if (nrFotografi == 2 && nrVideografi == 2) {
            servicii.add(new SedintaFotoSimpla(numeClient, data, false, album, nrMinute));
            servicii.add(new SedintaFotoSimpla(numeClient, data, false, album, nrMinute));
            servicii.add(new VideoHighlights(numeClient, data, 120));
            servicii.add(new VideoHighlights(numeClient, data, 120));
        }
    }

    @Override
    public double getCostTotal() {
        double costTotal = 0;
        for (Servicii ser : servicii)
            if (ser instanceof ServiciiFoto)
                costTotal += ser.getCostTotal() - ((ServiciiFoto) ser).getPretAlbum();
            else
                costTotal += ser.getCostTotal();
        return costTotal;
    }

    @Override
    public String informatiiServici() {
        if (nrFotografi == 2 && nrVideografi == 0)
            return " Pachet promo Foto. Echipa va fi formata din " + nrFotografi + " fotografi si "
                    + nrVideografi + " videografi. Va costa " + (int) getCostTotal()
                    + "$ . Livrarea se va face atat pe stick si respectiv pe un album gratuit din partea noastra.";
        else if (nrVideografi == 1 && nrFotografi == 1)
            return " Pachet promo Simplu. Echipa va fi formata din " + nrFotografi + " fotograf si "
                    + nrVideografi + " videograf. Va costa " + (int) getCostTotal()
                    + "$ . Livrarea se va face atat pe stick si respectiv pe un album gratuit din partea noastra.";
        else if (nrVideografi == 2 && nrFotografi == 0) {
            double costTotal = getCostTotal() - (getCostTotal() * (25.0f / 100.0f));
            return " Pachet promo Video. Echipa va fi formata din " + nrFotografi + " fotografi si "
                    + nrVideografi + " videografi. Va costa " + (int) costTotal
                    + "$ . Livrarea se va face pe stick.";
        } else if (nrFotografi == 2 && nrVideografi == 2) {
            double costTotal = getCostTotal() - (getCostTotal() * (15.0f / 100.0f));
            return " Pachet VIP. Echipa va fi formata din " + nrFotografi + " fotografi si "
                    + nrVideografi + " videografi. Va costa " + (int) costTotal
                    + "$ . Livrarea se va face pe stick si respectiv pe un album gratuit din partea noastra.";
        } else return "Nu ati ales un pachet din oferta noastra";
    }

    @Override
    public String getNumeClient() {
        return this.numeClient;
    }

    @Override
    public String getData() {
        return this.data;
    }
}


