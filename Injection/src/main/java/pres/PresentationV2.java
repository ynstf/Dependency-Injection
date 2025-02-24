package pres;

import dao.Daoimpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

/*
* Par instanciation dynamique
*/
public class PresentationV2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("config.txt"));
            String daoClass = sc.nextLine();
            //System.out.println(daoClass);
            Class cDao = Class.forName(daoClass);
            IDao dao =(IDao) cDao.getConstructor().newInstance();

            String metierClass = sc.nextLine();
            //Sys    tem.out.println(metierClass);
            Class cMetier = Class.forName(metierClass);
            IMetier metier =(IMetier) cMetier.getConstructor().newInstance();

            Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);
            System.out.println("Result : "+metier.calcul());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
