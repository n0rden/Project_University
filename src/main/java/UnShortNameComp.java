import org.apache.commons.lang3.StringUtils;

public class UnShortNameComp implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
