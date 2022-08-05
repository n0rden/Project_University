package utils;

import comparators.*;
import enums.StudentsComparators;
import enums.UniversityComparators;

import java.util.logging.Logger;

public class GetComparatorFromEnum {

    private static Logger logger = Logger.getLogger(GetComparatorFromEnum.class.getName());

    private GetComparatorFromEnum() {
    }

    public static StudentComparator getStudentComparator(StudentsComparators comparator) {

        StudentComparator studentComparator = null;
        logger.info("Choosing a \"Student\" comparator");
        switch (comparator) {
            case SORTBYNAME:
                studentComparator = new StFullNameComp();
                break;
            case SORTBYUNIVERSITYID:
                studentComparator = new StUniversityIdComp();
                break;
            case SORTBYCOURSENUMBER:
                studentComparator = new StCurrentCourseNumberComp();
                break;
            case SORTBYAVGSCORE:
                studentComparator = new StAvgExamScoreComp();
                break;
        }
        return studentComparator;
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators comparator) {

        UniversityComparator universityComparator = null;
        logger.info("Choosing a \"University\" comparator");
        switch (comparator) {
            case SORTBYID:
                universityComparator = new UnIdComp();
                break;
            case SORTBYMAINPROFILE:
                universityComparator = new UnMainProfileComp();
                break;
            case SORTBYSHORTNAME:
                universityComparator = new UnShortNameComp();
                break;
            case SORTBYYEAROFFUNDUNATION:
                universityComparator = new UnYearOfFoundationComp();
                break;
            case SOTRBYFULLNAME:
                universityComparator = new UnFullNameComp();
                break;
        }
        return universityComparator;
    }
}