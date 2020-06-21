package servicii.promo;

import org.junit.Test;

import static org.junit.Assert.*;

public class PachetPromoTest {

    PachetPromo p = new PachetPromo("Marius", "10/09/2020", 1, 1);
    PachetPromo p1 = new PachetPromo("Andrei", "11/10/2020", 1, 2);
    PachetPromo p2 = new PachetPromo("Alin", "12/10/2020", 2, 2);
    PachetPromo p3 = new PachetPromo("Alex", "21/10/2020", 2, 1);

    @Test
    public void getCostTotal() {
        assertEquals(700, (int)p.getCostTotal());
        assertEquals(1000, (int)p1.getCostTotal());
        assertEquals(1400, (int)p2.getCostTotal());
        assertEquals(1100, (int)p3.getCostTotal());
    }

    @Test
    public void informatiiServici() {
        String actual = p.informatiiServici();
        String actual1= p1.informatiiServici();
        String actual2= p2.informatiiServici();
        String actual3 = p3.informatiiServici();
        String want = " Pachet promo Simplu. Echipa va fi formata din 1 fotograf si 1 videograf. Va costa 700$ . " +
                "Livrarea se va face atat pe stick si respectiv pe un album gratuit din partea noastra.";
        String want1 = " Pachet promo Video + Foto. Echipa va fi formata din 1 fotograf si 2 videografi. Va costa 750$ . " +
                "Livrarea se va face pe stick.";
        String want2 = " Pachet VIP. Echipa va fi formata din 2 fotografi si 2 videografi. Va costa 1189$ . " +
                "Livrarea se va face pe stick si respectiv pe un album gratuit din partea noastra.";
        String want3 = " Pachet promo Foto + Video. Echipa va fi formata din 2 fotografi si 1 videograf. Va costa 825$ . " +
                "Livrarea se va face atat pe stick si respectiv pe un album gratuit din partea noastra.";
        assertEquals(want, actual);
        assertEquals(want1, actual1);
        assertEquals(want2, actual2);
        assertEquals(want3, actual3);
    }

    @Test
    public void getNumeClient() {
        assertEquals("Marius", p.getNumeClient());
        assertEquals("Andrei", p1.getNumeClient());
        assertEquals("Alin", p2.getNumeClient());
        assertEquals("Alex", p3.getNumeClient());
    }

    @Test
    public void getData() {
        assertEquals("10/09/2020", p.getData());
        assertEquals("11/10/2020", p1.getData());
        assertEquals("12/10/2020", p2.getData());
        assertEquals("21/10/2020", p3.getData());
    }
}