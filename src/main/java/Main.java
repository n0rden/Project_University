public class Main {
    public static void main(String[] args) {
        University university = new University("1",
                "Mile Kolin", "Mike", 2010, StudyProfile.biology);
        Student student1 = new Student("Mike Kolin", "1", 10, 4.986f);
        System.out.println(university.toString());
        System.out.println(student1.toString());
    }
}