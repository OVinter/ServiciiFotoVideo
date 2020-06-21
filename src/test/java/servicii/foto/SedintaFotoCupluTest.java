package servicii.foto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class SedintaFotoCupluTest extends ServiciiFoto {

    private SedintaFotoCuplu sfc;
    private SedintaFotoCuplu sfc1;
    private SedintaFotoCuplu sfc2;
    private SedintaFotoCuplu sfc3;

    public SedintaFotoCupluTest(String numeClient, String data, boolean studio, boolean album) {
        super(numeClient, data, studio, album);
    }

    SedintaFotoCuplu createSF(String nume, String data, boolean studio, boolean album) {
        return new SedintaFotoCuplu(nume, data, studio, album);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Alin", "13/06/2021", true, true}, {"Alin", "12/08/2020", false, false},
                {"Marius", "12/04/2021", false, true}, {"Alex", "12/04/2021", true, false}});
    }

    @Test
    public void testInformatiiServici() {

        sfc = createSF("Andrei", "10/09/2020", true, true);
        String actual = sfc.informatiiServici();
        String want = "Ati ales servicii foto: Sedinta foto cuplu in studio. Sedinta va dura 90 minute si va costa 165 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want, actual);
        sfc1 = createSF("Alin", "12/08/2020", false, false);
        String actual1 = sfc1.informatiiServici();
        String want1 = "Ati ales servicii foto: Sedinta foto cuplu in aer liber. Sedinta va dura 90 minute si va costa 90 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want1, actual1);
        sfc2 = createSF("Marius", "12/04/2021", false, true);
        String actual2 = sfc2.informatiiServici();
        String want2 = "Ati ales servicii foto: Sedinta foto cuplu in aer liber. Sedinta va dura 90 minute si va costa 140 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want2, actual2);
        sfc3 = createSF("Alex", "12/04/2021", true, false);
        String actual3 = sfc3.informatiiServici();
        String want3 = "Ati ales servicii foto: Sedinta foto cuplu in studio. Sedinta va dura 90 minute si va costa 115 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want3, actual3);
    }

    @Test
    public void testNumeClient() {
        sfc = createSF("Andrei", "10/09/2020", true, true);
        assertEquals("Andrei", sfc.getNumeClient());
        sfc1 = createSF("Alin", "12/08/2020", false, false);
        assertEquals("Alin", sfc1.getNumeClient());
        sfc2 = createSF("Marius", "12/04/2021", false, true);
        assertEquals("Marius", sfc2.getNumeClient());
        sfc3 = createSF("Alex", "12/04/2021", true, false);
        assertEquals("Alex", sfc3.getNumeClient());
    }

    @Test
    public void testData() {
        sfc = createSF("Andrei", "10/09/2020", true, true);
        assertEquals("10/09/2020", sfc.getData());
        sfc1 = createSF("Alin", "12/08/2020", false, false);
        assertEquals("12/08/2020", sfc1.getData());
        sfc2 = createSF("Marius", "12/04/2021", false, true);
        assertEquals("12/04/2021", sfc2.getData());
        sfc3 = createSF("Alex", "12/04/2021", true, false);
        assertEquals("12/04/2021", sfc3.getData());
    }

    @Test
    public void testStudio() {
        sfc = createSF("Andrei", "10/09/2020", true, true);
        assertEquals(true, sfc.isStudio());
        sfc1 = createSF("Alin", "12/08/2020", false, false);
        assertEquals(false, sfc1.isStudio());
    }

    @Test
    public void testAlbum() {
        sfc = createSF("Andrei", "10/09/2020", true, true);
        assertEquals(true, sfc.isAlbum());
        sfc1 = createSF("Alin", "12/08/2020", false, false);
        assertEquals(false, sfc1.isAlbum());
    }
}