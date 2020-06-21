package servicii.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class VideoHighlightsTest extends ServiciiVideo {

    private VideoHighlights vh;
    private VideoHighlights vh1;


    public VideoHighlightsTest(String numeClient, String data, int secunde) {
        super(numeClient, data, secunde);
    }


    VideoHighlights createVideo(String nume, String data, int secunde) {
        return new VideoHighlights(nume, data, secunde);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Andrei", "13/06/2021", 120}, {"Alin", "12/08/2020", 180}});
    }

    @Test
    public void testInformatiiServici() {
        vh = createVideo("Andrei", "13/06/2021", 120);
        String actual = vh.informatiiServici();
        String want = "Ati ales servicii video: Video Highlights. Va costa 300 $. " +
                "Livrarea se va face pe stick.";
        assertEquals(want, actual);
        vh1 = createVideo("Alin", "12/08/2020", 180);
        String actual1 = "Ati ales servicii video: Video Highlights. Va costa 450 $. " +
                "Livrarea se va face pe stick.";
        String want1 = vh1.informatiiServici();
        assertEquals(want1, actual1);
    }

    @Test
    public void testNume() {
        vh = createVideo("Andrei", "13/06/2021", 120);
        assertEquals("Andrei", vh.getNumeClient());
        vh1 = createVideo("Alin", "12/08/2020", 180);
        assertEquals("Alin", vh1.getNumeClient());
    }

    @Test
    public void testData() {
        vh = createVideo("Andrei", "13/06/2021", 120);
        assertEquals("13/06/2021", vh.getData());
        vh1 = createVideo("Alin", "12/08/2020", 180);
        assertEquals("12/08/2020", vh1.getData());
    }
}