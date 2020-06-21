package servicii.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class VideoMuzicalTest extends ServiciiVideo {

    private VideoMuzical vm;
    private VideoMuzical vm1;

    public VideoMuzicalTest(String numeClient, String data, int secunde, int nrFani) {
        super(numeClient, data, secunde);
    }

    VideoMuzical createVideo(String nume, String data, int secunde, int nrFani) {
        return new VideoMuzical(nume, data, secunde, nrFani);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Andrei", "13/06/2021", 120, 2000}, {"Alin", "12/08/2020", 120, 1000}});
    }

    @Test
    public void testInformatiiServici() {
        vm = createVideo("Andrei", "13/06/2021", 120, 1000000);
        String actual = vm.informatiiServici();
        String want = "Ati ales servicii video: Video muzical. Va costa 700 $. " +
                "Livrarea se va face pe stick.";;
        assertEquals(want, actual);
        vm1 = createVideo("Alin", "12/08/2020", 120, 500000);
        String actual1 = "Ati ales servicii video: Video muzical. Va costa 650 $. " +
                "Livrarea se va face pe stick.";
        String want1 = vm1.informatiiServici();
        assertEquals(want1, actual1);
    }

    @Test
    public void testNume() {
        vm = createVideo("Andrei", "13/06/2021", 120, 2000);
        assertEquals("Andrei", vm.getNumeClient());
        vm1 = createVideo("Alin", "12/08/2020", 120, 1000);
        assertEquals("Alin", vm1.getNumeClient());
    }

    @Test
    public void testData() {
        vm = createVideo("Andrei", "13/06/2021", 120, 2000);
        assertEquals("13/06/2021", vm.getData());
        vm1 = createVideo("Alin", "12/08/2020", 120, 1000);
        assertEquals("12/08/2020", vm1.getData());
    }
}