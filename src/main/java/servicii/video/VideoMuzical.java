package servicii.video;

public class VideoMuzical extends ServiciiVideo {

    public VideoMuzical(String numeClient, String data, int secunde, int fani) {
        super(numeClient, data, secunde);
        super.pretMinut = 300;
        super.pretTotal = (secunde / 60) * pretMinut + fani * 0.0001;
    }

    @Override
    public String informatiiServici() {
        return super.informatiiServici() + ": Video muzical. Va costa " + (int)pretTotal + " $. " +
                "Livrarea se va face pe stick.";
    }
}
