package servicii.foto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class SedintaFotoFamilieTest extends ServiciiFoto {

    private SedintaFotoFamilie sff;
    private SedintaFotoFamilie sff1;
    private SedintaFotoFamilie sff2;
    private SedintaFotoFamilie sff3;

    public SedintaFotoFamilieTest(String numeClient, String data, boolean studio, boolean album, int nrTinute) {
        super(numeClient, data, studio, album);
    }

    SedintaFotoFamilie createSF(String nume, String data, boolean studio, boolean album, int nrTinute) {
        return new SedintaFotoFamilie(nume, data, studio, album, nrTinute);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Andrei", "13/06/2021", true, true, 5}, {"Alin", "12/08/2020", false, false, 5},
                {"Marius", "12/04/2021", false, true, 5}, {"Alex", "12/04/2021", true, false, 5}});
    }

    @Test
    public void testInformatiiServici() {

        sff = createSF("Andrei", "10/09/2020", true, true, 5);
        String actual = sff.informatiiServici();
        String want = "Ati ales servicii foto: Sedinta foto familie in studio. Sedinta va dura 225 minute si va costa 356 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want, actual);
        sff1 = createSF("Alin", "12/08/2020", false, false, 5);
        String actual1 = sff1.informatiiServici();
        String want1 = "Ati ales servicii foto: Sedinta foto familie in aer liber. Sedinta va dura 225 minute si va costa 281 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want1, actual1);
        sff2 = createSF("Marius", "12/04/2021", false, true, 5);
        String actual2 = sff2.informatiiServici();
        String want2 = "Ati ales servicii foto: Sedinta foto familie in aer liber. Sedinta va dura 225 minute si va costa 331 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want2, actual2);
        sff3 = createSF("Alex", "12/04/2021", true, false, 5);
        String actual3 = sff3.informatiiServici();
        String want3 = "Ati ales servicii foto: Sedinta foto familie in studio. Sedinta va dura 225 minute si va costa 306 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want3, actual3);
    }

    @Test
    public void testNumeClient() {
        sff = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals("Andrei", sff.getNumeClient());
        sff1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals("Alin", sff1.getNumeClient());
        sff2 = createSF("Marius", "12/04/2021", false, true, 60);
        assertEquals("Marius", sff2.getNumeClient());
        sff3 = createSF("Alex", "12/04/2021", true, false, 60);
        assertEquals("Alex", sff3.getNumeClient());
    }

    @Test
    public void testData() {
        sff = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals("10/09/2020", sff.getData());
        sff1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals("12/08/2020", sff1.getData());
        sff2 = createSF("Marius", "12/04/2021", false, true, 60);
        assertEquals("12/04/2021", sff2.getData());
        sff3 = createSF("Alex", "12/04/2021", true, false, 60);
        assertEquals("12/04/2021", sff3.getData());
    }

    @Test
    public void testStudio() {
        sff = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals(true, sff.isStudio());
        sff1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals(false, sff1.isStudio());
    }

    @Test
    public void testAlbum() {
        sff = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals(true, sff.isAlbum());
        sff1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals(false, sff1.isAlbum());
    }
}