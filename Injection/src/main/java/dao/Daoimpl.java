package dao;

public class Daoimpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Version 1");
        double wind = 5000;
        return wind;
    }
}
