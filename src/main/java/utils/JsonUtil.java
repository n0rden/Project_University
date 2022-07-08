package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Student;
import models.University;
import java.util.Arrays;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    // Serialization methods
    public static String studentSerialization(Student student) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(student);
    }

    public static String universitySerialization(University university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(university);
    }

    public static String studentsListSerialization(List<Student> studentsList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(studentsList);
    }

    public static String universityListSerialization(List<University> universitiesList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(universitiesList);
    }

    // Deserialization methods
    public static Student studentDeserialization(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static University universityDeserialization(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static List<Student> studentsListDeserialization(String json) {
        return Arrays.asList(new Gson().fromJson(json, Student[].class));
    }

    public static List<University> universityListDeserialization(String json) {
        return Arrays.asList(new Gson().fromJson(json, University[].class));
    }
}