package servicii.video;

public class VideoHighlights extends ServiciiVideo {
    public VideoHighlights(String numeClient, String data, int secunde) {
        super(numeClient, data, secunde);
        super.pretMinut = 150;
        super.pretTotal = (super.secunde / 60) * pretMinut;
    }

    @Override
    public String informatiiServici() {
        return super.informatiiServici() + ": Video Highlights. Va costa " + (int)pretTotal + " $. " +
                "Livrarea se va face pe stick.";
    }

}
