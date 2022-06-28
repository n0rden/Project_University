public class GetComparatorFromEnum {

    private GetComparatorFromEnum() {
    }

    public static IStudentComparator getStudentComparator(EStudentsComparators comparator) {
        switch (comparator) {
            case SORTBYNAME -> {
                return new StFullNameComp();
            }
            case SORTBYUNIVERSITYID -> {
                return new StUniversityIdComp();
            }
            case SORTBYCOURSENUMBER -> {
                return new StCurrentCourseNumberComp();
            }
            case SORTBYAVGSCORE -> {
                return new StAvgExamScoreComp();
            }
            default -> {
                return null;
            }
        }
    }

    public static IUniversityComparator getUniversityComparator(EUniversityComparators comparator) {
        switch (comparator) {
            case SORTBYID -> {
                return new UnIdComp();
            }
            case SORTBYMAINPROFILE -> {
                return new UnMainProfileComp();
            }
            case SORTBYSHORTNAME -> {
                return new UnShortNameComp();
            }
            case SORTBYYEAROFFUNDUNATION -> {
                return new UnYearOfFoundationComp();
            }
            case SOTRBYFULLNAME -> {
                return new UnFullNameComp();
            }
            default -> {
                return null;
            }
        }
    }
}