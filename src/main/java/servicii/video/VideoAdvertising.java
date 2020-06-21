package servicii.video;

public class VideoAdvertising extends ServiciiVideo {

    public VideoAdvertising(String numeClient, String data, int secunde, int nrPublicTarget) {
        super(numeClient, data, secunde);
        super.pretMinut = 200;
        super.pretTotal = (super.secunde / 60) * super.pretMinut + nrPublicTarget * 0.01;
    }

    @Override
    public String informatiiServici() {
        return super.informatiiServici() + ": Video advertising. Va costa " + (int)pretTotal + " $. " +
                "Livrarea se va face pe stick.";
    }
}
