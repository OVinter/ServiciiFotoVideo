package servicii.foto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class SedintaFotoProdusTest extends ServiciiFoto {

    private SedintaFotoProdus sfp;
    private SedintaFotoProdus sfp1;
    private SedintaFotoProdus sfp2;
    private SedintaFotoProdus sfp3;

    public SedintaFotoProdusTest(String numeClient, String data, boolean studio, boolean album, int nrProduse) {
        super(numeClient, data, studio, album);
    }

    SedintaFotoProdus createSF(String nume, String data, boolean studio, boolean album, int nrProduse) {
        return new SedintaFotoProdus(nume, data, studio, album, nrProduse);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Andrei", "13/06/2021", true, true, 10}, {"Alin", "12/08/2020", false, false, 10},
                {"Marius", "12/04/2021", false, true, 10}, {"Alex", "12/04/2021", true, false, 10}});
    }

    @Test
    public void testInformatiiServici() {

        sfp = createSF("Andrei", "10/09/2020", true, true, 10);
        String actual = sfp.informatiiServici();
        String want = "Ati ales servicii foto: Fotografie produs in studio. Sedinta va dura 100 minute si va costa 141 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want, actual);
        sfp1 = createSF("Alin", "12/08/2020", false, false, 10);
        String actual1 = sfp1.informatiiServici();
        String want1 = "Ati ales servicii foto: Fotografie produs in aer liber. Sedinta va dura 100 minute si va costa 66 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want1, actual1);
        sfp2 = createSF("Marius", "12/04/2021", false, true, 10);
        String actual2 = sfp2.informatiiServici();
        String want2 = "Ati ales servicii foto: Fotografie produs in aer liber. Sedinta va dura 100 minute si va costa 116 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want2, actual2);
        sfp3 = createSF("Alex", "12/04/2021", true, false, 10);
        String actual3 = sfp3.informatiiServici();
        String want3 = "Ati ales servicii foto: Fotografie produs in studio. Sedinta va dura 100 minute si va costa 91 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want3, actual3);
    }

    @Test
    public void testNumeClient() {
        sfp = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals("Andrei", sfp.getNumeClient());
        sfp1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals("Alin", sfp1.getNumeClient());
        sfp2 = createSF("Marius", "12/04/2021", false, true, 60);
        assertEquals("Marius", sfp2.getNumeClient());
        sfp3 = createSF("Alex", "12/04/2021", true, false, 60);
        assertEquals("Alex", sfp3.getNumeClient());
    }

    @Test
    public void testData() {
        sfp = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals("10/09/2020", sfp.getData());
        sfp1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals("12/08/2020", sfp1.getData());
        sfp2 = createSF("Marius", "12/04/2021", false, true, 60);
        assertEquals("12/04/2021", sfp2.getData());
        sfp3 = createSF("Alex", "12/04/2021", true, false, 60);
        assertEquals("12/04/2021", sfp3.getData());
    }

    @Test
    public void testStudio() {
        sfp = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals(true, sfp.isStudio());
        sfp1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals(false, sfp1.isStudio());
    }

    @Test
    public void testAlbum() {
        sfp = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals(true, sfp.isAlbum());
        sfp1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals(false, sfp1.isAlbum());
    }
}