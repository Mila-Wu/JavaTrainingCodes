package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolProperties.class)
@ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
public class Week5SpringBootApplication {

	@Autowired(required=true)
	private SchoolProperties schoolProperties;

	@Bean
	public School school() {
		Student student1 = new Student("100", "student1");
		Student student2 = new Student("200", "student2");
		Klass class1 = new Klass("1100", "class1");
		class1.addStudent(student1);
		Klass class2 = new Klass("1200", "class2");
		class2.addStudent(student2);
		List<Klass> classes = new ArrayList<>();
		classes.add(class1);
		classes.add(class2);
		return new School(classes);

//		List<String> studentIds = schoolProperties.getStudentIds();
//		List<String> studentNames = schoolProperties.getStudentNames();
//		List<String> classIds = schoolProperties.getKlassIds();
//		List<String> classNames = schoolProperties.getKlassNames();
//		List<Map<String, Integer>> studentOfClass = schoolProperties.getStudentOfClass();
//
//		List<Student> students = new ArrayList<>(studentIds.size());
//		for (int i=0; i<studentIds.size(); i++) {
//			students.add(new Student(studentIds.get(i), studentNames.get(i)));
//		}
//
//		List<Klass> myClasses = new ArrayList<>();
//		for (int i=0; i<classIds.size(); i++) {
//			myClasses.add(new Klass(classIds.get(i), classNames.get(i)));
//		}
//
//		for (Map info: studentOfClass) {
//			myClasses.get((Integer) info.get("myClassId")).addStudent(students.get((Integer) info.get("studentId")));
//		}
//
//		System.out.println(studentIds.toString());
//		System.out.println(studentNames.toString());
//		System.out.println(classIds.toString());
//		System.out.println(classNames.toString());
//		System.out.println(studentOfClass.toString());
//
//		return new School(myClasses);
	}
}
