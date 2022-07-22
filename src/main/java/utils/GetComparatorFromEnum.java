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

        logger.info("Choosing a \"Student\" comparator");
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

    public static UniversityComparator getUniversityComparator(UniversityComparators comparator) {

        logger.info("Choosing a \"University\" comparator");
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