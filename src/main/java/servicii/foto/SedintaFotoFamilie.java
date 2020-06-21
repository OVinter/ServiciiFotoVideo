package servicii.foto;

public class SedintaFotoFamilie extends ServiciiFoto {

    //private int nrTinute;

    public SedintaFotoFamilie(String numeClient, String data, boolean studio, boolean album, int nrTinute) {
        super(numeClient, data, studio, album);
        super.stick = true;
        //this.nrTinute = nrTinute;
        super.nrMinute = 45 * nrTinute;
        super.pretOra = 75;
        super.pretTotal = super.pretOra  * (super.nrMinute / 60);
        if(super.album)
            super.pretTotal += 50;
        if(super.studio )
            super.pretTotal += 25;
    }

    @Override
    public String informatiiServici() {
        if(album && !studio)
            return super.informatiiServici() + ": Sedinta foto familie in aer liber. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face atat pe stick si veti avea si un album";
        else if(!album  && !studio)
            return super.informatiiServici() + ": Sedinta foto familie in aer liber. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else if(!album)
            return super.informatiiServici() + ": Sedinta foto familie in studio. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else return super.informatiiServici() + ": Sedinta foto familie in studio. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                + " $. Livrarea se va face atat pe stick si veti avea si un album";
    }

}
