package servicii;

import servicii.Servicii;

import java.util.ArrayList;
import java.util.List;

public class ProgramareSedinte {

    private List<Servicii> sedinte = new ArrayList<>();

    public void addServiciu(Servicii s) {
        sedinte.add(s);
    }

    public String getSedinte() {
        String s = "";
        for(Servicii ser : sedinte) {
            s += "Nume: " + ser.getNumeClient() + "\nData: " + ser.getData() + "\nDetalii: " + ser.informatiiServici() + "\n";
        }
        return s;
    }

}
