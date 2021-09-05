package loadbyannotation;

import loadbyannotation.aop.ISchool;
import loadbyxml.Klass;
import loadbyxml.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Data
@Component
public class School2 implements ISchool {
    @Autowired
    Klass klass;

    @Resource(name = "student100")
    Student student;

    @Override
    public void goToSchool(){
        System.out.println("Student go to school");
    }
}
