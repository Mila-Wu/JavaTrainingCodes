package loadbyxml;

import loadbyxml.aop.ISchool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHomeWork2_01LodByXml {
    public static  void main(String[] srgs){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student100 = (Student)context.getBean("student100");
        System.out.println("student100 : " + student100.toString());

        Student student200 = (Student)context.getBean("student200");
        System.out.println("student200 : " + student200.toString());

        Klass klass01 = (Klass)context.getBean("klass01");
        System.out.println("klass01 : " + klass01.toString());

        ISchool school = (ISchool) context.getBean("school");
        System.out.println("school : " + school.toString());
        school.goToSchool();

    }
}
