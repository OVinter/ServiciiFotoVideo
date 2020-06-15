package servicii.foto;

public class SedintaFotoCuplu extends ServiciiFoto {

    public SedintaFotoCuplu(String numeClient, String data, boolean studio, boolean album) {
        super(numeClient, data, studio, album);
        super.stick = true;
        super.pretOra = 60;
        super.nrMinute = 90;
        super.pretTotal = pretOra * (nrMinute / 60);
        if(super.album)
            super.pretTotal += 50;
        if(super.studio )
            super.pretTotal += 25;
    }

    @Override
    public String informatiiServici(){
        if(album && !studio)
            return super.informatiiServici() + ": Sedinta foto cuplu in aer liber. Sedinta va dura " + nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face atat pe stick si veti avea si un album";
        else if(!album  && !studio)
            return super.informatiiServici() + ": Sedinta foto cuplu in aer liber. Sedinta va dura " + nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else if(!album)
            return super.informatiiServici() + ": Sedinta foto cuplu in studio. Sedinta va dura " + nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face pe stick";
        else return super.informatiiServici() + ": Sedinta foto cuplu in studio. Sedinta va dura " + nrMinute + " minute si va costa " + (int)pretTotal
                    + " $. Livrarea se va face atat pe stick si veti avea si un album";
    }
}

