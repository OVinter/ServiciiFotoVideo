package servicii.foto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import servicii.Servicii;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class SedintaFotoSimplaTest extends ServiciiFoto {

    private ServiciiFoto sfs;
    private ServiciiFoto sfs1;
    private ServiciiFoto sfs2;
    private ServiciiFoto sfs3;

    public SedintaFotoSimplaTest(String numeClient, String data, boolean studio, boolean album, int nrMinute) {
        super(numeClient, data, studio, album);
    }

    SedintaFotoSimpla createSF(String nume, String data, boolean studio, boolean album, int nrMinute) {
        return new SedintaFotoSimpla(nume, data, studio, album, nrMinute);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"Andrei", "13/06/2021", true, true, 60}, {"Alin", "12/08/2020", false, false, 60},
                {"Marius", "12/04/2021", false, true, 60}, {"Alex", "12/04/2021", true, false, 60}});
    }

    @Test
    public void testInformatiiServici() {

        sfs = createSF("Andrei", "10/09/2020", true, true, 60);
        String actual = sfs.informatiiServici();
        String want = "Ati ales servicii foto: Sedinta foto in studio. Sedinta va dura 60 minute si va costa 125 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want, actual);
        sfs1 = createSF("Alin", "12/08/2020", false, false, 60);
        String actual1 = sfs1.informatiiServici();
        String want1 = "Ati ales servicii foto: Sedinta foto in aer liber. Sedinta va dura 60 minute si va costa 50 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want1, actual1);
        sfs2 = createSF("Marius", "12/04/2021", false, true, 60);
        String actual2 = sfs2.informatiiServici();
        String want2 = "Ati ales servicii foto: Sedinta foto. Sedinta va dura 60 minute si va costa 100 $. " +
                "Livrarea se va face atat pe stick si veti avea si un album";
        assertEquals(want2, actual2);
        sfs3 = createSF("Alex", "12/04/2021", true, false, 60);
        String actual3 = sfs3.informatiiServici();
        String want3 = "Ati ales servicii foto: Sedinta foto in studio. Sedinta va dura 60 minute si va costa 75 $. " +
                "Livrarea se va face pe stick";
        assertEquals(want3, actual3);
    }

    @Test
    public void testNumeClient() {
        sfs = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals("Andrei", sfs.getNumeClient());
        sfs1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals("Alin", sfs1.getNumeClient());
        sfs2 = createSF("Marius", "12/04/2021", false, true, 60);
        assertEquals("Marius", sfs2.getNumeClient());
        sfs3 = createSF("Alex", "12/04/2021", true, false, 60);
        assertEquals("Alex", sfs3.getNumeClient());
    }

    @Test
    public void testData() {
        sfs = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals("10/09/2020", sfs.getData());
        sfs1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals("12/08/2020", sfs1.getData());
        sfs2 = createSF("Marius", "12/04/2021", false, true, 60);
        assertEquals("12/04/2021", sfs2.getData());
        sfs3 = createSF("Alex", "12/04/2021", true, false, 60);
        assertEquals("12/04/2021", sfs3.getData());
    }

    @Test
    public void testStudio() {
        sfs = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals(true, sfs.isStudio());
        sfs1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals(false, sfs1.isStudio());
    }

    @Test
    public void testAlbum() {
        sfs = createSF("Andrei", "10/09/2020", true, true, 60);
        assertEquals(true, sfs.isAlbum());
        sfs1 = createSF("Alin", "12/08/2020", false, false, 60);
        assertEquals(false, sfs1.isAlbum());
    }

}