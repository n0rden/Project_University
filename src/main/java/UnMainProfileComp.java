import org.apache.commons.lang3.StringUtils;

public class UnMainProfileComp implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().getSpecialty(), o2.getMainProfile().getSpecialty());
    }
}