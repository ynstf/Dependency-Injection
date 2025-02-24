package pres;

import dao.Daoimpl;
import metier.MetierImpl;

/*
* Par instanciation statique
*/
public class PresentationV1 {
    public static void main(String[] args) {
        Daoimpl d = new Daoimpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d);
        System.out.println(metier.calcul());
    }
}
