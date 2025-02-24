package metier;

import dao.Daoimpl;
import dao.IDao;

public class MetierImpl implements IMetier {
    //private IDao dao = new Daoimpl(); //Couplage fort

    private IDao dao; //Couplage faible
    @Override
    public double calcul() {
        double w_speed = dao.getData();
        double res = w_speed / 1000;
        return res;
    }

    public void setDao(IDao dao){
        this.dao = dao;
    }
}