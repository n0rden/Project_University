package utils;

import enums.StudyProfile;
import models.Statistics;
import models.Student;
import models.University;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GetStatistics {

    private GetStatistics() {
    }

    public static List<Statistics> getStatistics(List<University> universities, List<Student> students) {

        List<Statistics> statisticsList = new ArrayList<>();
        int universitiesCount = 0;
        int studentsCount = 0;
        double examScore = 0;

        for (int i = 0; i < StudyProfile.values().length; i++) {
            List<Integer> index = new ArrayList<>();
            for (int j = 0; j < universities.size(); j++) {
                if (StudyProfile.values()[i].equals(universities.get(j).getMainProfile())) {
                    universitiesCount++;
                    index.add(j);
                }
            }
            if (universitiesCount != 0) {
                for (int k = 0; k < index.size(); k++) {
                    for (int l = 0; l < students.size(); l++) {
                        if (universities.get(index.get(k)).getId().equals(students.get(l).getUniversityId())) {
                            studentsCount++;
                            examScore += students.get(k).getAvgExamScore();
                        }
                    }
                    BigDecimal avgExamScore;
                    if (studentsCount != 0) {
                        avgExamScore = new BigDecimal(examScore / studentsCount).setScale(2, RoundingMode.HALF_UP);
                    } else {
                        avgExamScore = new BigDecimal(0);
                    }
                    statisticsList.add(new Statistics()
                            .setMainProfile(StudyProfile.values()[i])
                            .setUniversityName(universities.get(index.get(k)).getFullName())
                            .setNumberOfUniversitiesByProfile(universitiesCount)
                            .setNumberOfStudentsByProfile(studentsCount)
                            .setAvgExamScore(studentsCount == 0 ? (double) 0 : avgExamScore.doubleValue())
                    );
                }
                studentsCount = 0;
                examScore = 0;
            }
            universitiesCount = 0;
        }
        return statisticsList;
    }
}