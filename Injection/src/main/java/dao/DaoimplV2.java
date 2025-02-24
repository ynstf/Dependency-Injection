/*package dao;

public class DaoimplV2 implements IDao{

    @Override
    public double getData() {
        System.out.println("Version 2");
        double wind = 5000;
        return wind;
    }
}*/
package dao;

import org.springframework.stereotype.Component;

@Component("daoBean") // le nom du bean est optionnel
public class DaoimplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version 2");
        double wind = 6000; // ou une autre valeur
        return wind;
    }
}
