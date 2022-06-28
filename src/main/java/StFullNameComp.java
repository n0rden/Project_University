import org.apache.commons.lang3.StringUtils;

public class StFullNameComp implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
