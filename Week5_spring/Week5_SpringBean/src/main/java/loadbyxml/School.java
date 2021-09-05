package loadbyxml;

import loadbyxml.aop.ISchool;
import lombok.Data;

@Data
public class School implements ISchool {
    Klass klass;
    Student student;

    public void goToSchool(){
        System.out.println("Student go to school");
    }
}
