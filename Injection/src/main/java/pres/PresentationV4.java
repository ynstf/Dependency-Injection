package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Par instanciation annotations
 */
public class PresentationV4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Result : " + metier.calcul());
    }
}
