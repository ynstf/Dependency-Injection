package pres;

import dao.Daoimpl;
import metier.MetierImpl;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;

/*
* Par instanciation xml
*/
public class PresentationV3 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-ioc.xml");
        IMetier metier= (IMetier) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}

