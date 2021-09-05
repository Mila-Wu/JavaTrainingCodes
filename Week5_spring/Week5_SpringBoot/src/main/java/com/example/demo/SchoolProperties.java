package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private List<String> studentIds;
    private List<String> studentNames;
    private List<String> klassIds;
    private List<String> klassNames;
    private List<Map<String, Integer>> studentOfClass;

    public List<String> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<String> studentIds) {
        this.studentIds = studentIds;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }

    public List<String> getKlassIds() {
        return klassIds;
    }

    public void setKlassIds(List<String> klassIds) {
        this.klassIds = klassIds;
    }

    public List<String> getKlassNames() {
        return klassNames;
    }

    public void setKlassNames(List<String> klassNames) {
        this.klassNames = klassNames;
    }

    public List<Map<String, Integer>> getStudentOfClass() {
        return studentOfClass;
    }

    public void setStudentOfClass(List<Map<String, Integer>> studentOfClass) {
        this.studentOfClass = studentOfClass;
    }
}
