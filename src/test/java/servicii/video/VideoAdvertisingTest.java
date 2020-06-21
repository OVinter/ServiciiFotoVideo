package servicii.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import servicii.foto.SedintaFotoSimpla;
import servicii.foto.ServiciiFoto;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class VideoAdvertisingTest extends ServiciiVideo {

    private VideoAdvertising va;
    private VideoAdvertising va1;


    public VideoAdvertisingTest(String numeClient, String data, int secunde, int nrTarget) {
        super(numeClient, data, secunde);
    }


    VideoAdvertising createVideo(String nume, String data, int secunde, int nrTarget) {
        return new VideoAdvertising(nume, data, secunde, nrTarget);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Andrei", "13/06/2021", 120, 2000}, {"Alin", "12/08/2020", 120, 1000}});
    }

    @Test
    public void testInformatiiServici() {
        va = createVideo("Andrei", "13/06/2021", 120, 2000);
        String actual = va.informatiiServici();
        String want = "Ati ales servicii video: Video advertising. Va costa 420 $. " +
                "Livrarea se va face pe stick.";;
        assertEquals(want, actual);
        va1 = createVideo("Alin", "12/08/2020", 120, 1000);
        String actual1 = "Ati ales servicii video: Video advertising. Va costa 410 $. " +
        "Livrarea se va face pe stick.";
        String want1 = va1.informatiiServici();
        assertEquals(want1, actual1);
    }

    @Test
    public void testNume() {
        va = createVideo("Andrei", "13/06/2021", 120, 2000);
        assertEquals("Andrei", va.getNumeClient());
        va1 = createVideo("Alin", "12/08/2020", 120, 1000);
        assertEquals("Alin", va1.getNumeClient());
    }

    @Test
    public void testData() {
        va = createVideo("Andrei", "13/06/2021", 120, 2000);
        assertEquals("13/06/2021", va.getData());
        va1 = createVideo("Alin", "12/08/2020", 120, 1000);
        assertEquals("12/08/2020", va1.getData());
    }
}