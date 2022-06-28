import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src\\main\\resources\\universityInfo.xlsx";

        //Создаем и заполняем коллекции Студентов и Университетов данными, распарсивая Excel таблицы
        List<University> universityList = ExcelReader.universityReader(fileName);
        List<Student> studentList = ExcelReader.studentsReader(fileName);

        //Создаем коллекции компараторов для сортировки коллекций Студентов и Университетов
        List<IStudentComparator> studentCompList = new ArrayList<>();
        List<IUniversityComparator> universityCompList = new ArrayList<>();

        //Заполняем коллекции компараторов компараторами с помощью Enum
        for (EStudentsComparators sc : EStudentsComparators.values()) {
            studentCompList.add(GetComparatorFromEnum.getStudentComparator(sc));
        }

        for (EUniversityComparators uc : EUniversityComparators.values()) {
            universityCompList.add(GetComparatorFromEnum.getUniversityComparator(uc));
        }

        //Сортируем коллекции Студентов и Университетов и выводим их в консоль
        for (IStudentComparator sc : studentCompList) {
            studentList.stream().sorted(sc).forEach(System.out::println);
        }

        for (IUniversityComparator uc : universityCompList) {
            universityList.stream().sorted(uc).forEach(System.out::println);
        }
    }
}