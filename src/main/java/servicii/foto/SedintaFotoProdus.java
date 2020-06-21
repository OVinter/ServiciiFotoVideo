package servicii.foto;

public class SedintaFotoProdus extends ServiciiFoto {

    //private int nrProduse;

    public SedintaFotoProdus(String numeClient, String data, boolean studio, boolean album, int nrProduse) {
        super(numeClient, data, studio, album);
        //this.nrProduse = nrProduse;
        super.pretOra = 40;
        super.nrMinute = nrProduse * 10;
        super.pretTotal = super.pretOra * (super.nrMinute / 60);
        if(super.album)
            super.pretTotal += 50;
        if(super.studio )
            super.pretTotal += 25;
    }

    @Override
    public String informatiiServici() {
        if(album && !studio)
            return super.informatiiServici() + ": Fotografie produs in aer liber. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face atat pe stick si veti avea si un album";
        else if(!album  && !studio)
            return super.informatiiServici() + ": Fotografie produs in aer liber. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else if(!album)
            return super.informatiiServici() + ": Fotografie produs in studio. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else return super.informatiiServici() + ": Fotografie produs in studio. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                + " $. Livrarea se va face atat pe stick si veti avea si un album";
    }
}
