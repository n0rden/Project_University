enum StudyProfile {

    physics ("физика"),
    chemistry ("химия"),
    history ("история"),
    philosophy ("философия"),
    biology ("биология"),
    architecture ("архитектура");
    private String specialty;

    StudyProfile(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}