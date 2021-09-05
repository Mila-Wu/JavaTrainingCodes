package loadbyannotation;

import loadbyannotation.aop.ISchool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class SpringHomeWork2_02LodByAnnotation {
    public static  void main(String[] srgs){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ISchool school2 = (ISchool)context.getBean("school2");
        System.out.println("school2 : " + school2.toString());
        school2.goToSchool();

    }
}
