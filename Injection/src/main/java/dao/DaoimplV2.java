package dao;

public class DaoimplV2 implements IDao{

    @Override
    public double getData() {
        System.out.println("Version 2");
        double wind = 5000;
        return wind;
    }
}
