package enums;

public enum StudyProfile {

    PHYSICS("физика"),
    CHEMISTRY("химия"),
    HISTORY("история"),
    PHILOSOPHY("философия"),
    LINGUISTICS("лингвистика"),
    MEDICINE("медицина"),
    MATHEMATICS("математика");

    private String specialty;

    StudyProfile(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}