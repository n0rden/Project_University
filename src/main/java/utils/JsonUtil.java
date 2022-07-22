package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Student;
import models.University;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class JsonUtil {

    private static Logger logger = Logger.getLogger(JsonUtil.class.getName());
    private JsonUtil() {
    }

    // Serialization methods
    public static String studentSerialization(Student student) {

        logger.info("Start \"Student\" to JSON serialization");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(student);
    }

    public static String universitySerialization(University university) {
        logger.info("Start \"University\" to JSON serialization");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(university);
    }

    public static String studentsListSerialization(List<Student> studentsList) {

        logger.info("Start \"Student\" list to JSON serialization");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(studentsList);
    }

    public static String universityListSerialization(List<University> universitiesList) {

        logger.info("Start \"University\" list to JSON serialization");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(universitiesList);
    }

    // Deserialization methods
    public static Student studentDeserialization(String json) {

        logger.info("Start deserialization \"Student\" from JSON");
        return new Gson().fromJson(json, Student.class);
    }

    public static University universityDeserialization(String json) {

        logger.info("Start deserialization \"University\" from JSON");
        return new Gson().fromJson(json, University.class);
    }

    public static List<Student> studentsListDeserialization(String json) {

        logger.info("Start deserialization \"Student\" list from JSON");
        return Arrays.asList(new Gson().fromJson(json, Student[].class));
    }

    public static List<University> universityListDeserialization(String json) {

        logger.info("Start deserialization \"University\" list from JSON");
        return Arrays.asList(new Gson().fromJson(json, University[].class));
    }
}