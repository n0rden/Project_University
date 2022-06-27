import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src\\main\\resources\\universityInfo.xlsx";
        List<University> universityList = ExcelReader.universityReader(fileName);
        List<Student> studentList = ExcelReader.studentsReader(fileName);

        for (University university : universityList) {
            System.out.println(university.toString());
        }

        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }
}