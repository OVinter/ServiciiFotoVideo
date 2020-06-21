package servicii.foto;

public class SedintaFotoSimpla extends ServiciiFoto {

    public SedintaFotoSimpla(String numeClient, String data, boolean studio, boolean album, int nrMinute) {
        super(numeClient, data, studio, album);
        super.nrMinute = nrMinute;
        super.pretOra = 50;
        super.pretTotal = super.pretOra * (super.nrMinute / 60);
        if(super.album)
            super.pretTotal += 50;
        if(super.studio )
            super.pretTotal += 25;
    }

    @Override
    public String informatiiServici() {
        if(album && !studio)
            return super.informatiiServici() + ": Sedinta foto. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face atat pe stick si veti avea si un album";
        else if(!album  && !studio)
            return super.informatiiServici() + ": Sedinta foto in aer liber. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else if(!album)
            return super.informatiiServici() + ": Sedinta foto in studio. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else return super.informatiiServici() + ": Sedinta foto in studio. Sedinta va dura " + (int)nrMinute + " minute si va costa " + (int)pretTotal
                + " $. Livrarea se va face atat pe stick si veti avea si un album";
    }
}
