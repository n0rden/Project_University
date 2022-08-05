// Парсер Excel таблиц

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.xml.txw2.annotation.XmlElement;
import enums.StudyProfile;
import models.Student;
import models.University;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
    static List<Student> studentsList;
    static List<University> universityList;

    private static Logger logger = Logger.getLogger(ExcelReader.class.getName());

    private ExcelReader() {
    }
    public static List<Student> studentsReader(String fileName) {
        logger.info("Start parsing \"Students\" from XLSX file");
        studentsList = new ArrayList<>();

        try (InputStream is = new FileInputStream(fileName)) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> itRow = sheet.iterator();
            itRow.next();
            while (itRow.hasNext()) {
                Row row = itRow.next();
                Iterator<Cell> itCell = row.iterator();
                while (itCell.hasNext()) {

                    studentsList.add(new Student(itCell.next().getStringCellValue(),
                            itCell.next().getStringCellValue(),
                            (int) itCell.next().getNumericCellValue(),
                            (float) itCell.next().getNumericCellValue()));
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Student parsing error message", e);
            e.printStackTrace();
        }
        return studentsList;
    }

    public static List<University> universityReader(String fileName) {
        logger.info("Start parsing \"University\" from XLSX file");
        universityList = new ArrayList<>();

        try (InputStream is = new FileInputStream(fileName)) {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> itRow = sheet.iterator();
            itRow.next();
            while (itRow.hasNext()) {
                Row row = itRow.next();
                Iterator<Cell> itCell = row.iterator();
                while (itCell.hasNext()) {

                    universityList.add(new University(itCell.next().getStringCellValue(),
                            itCell.next().getStringCellValue(),
                            itCell.next().getStringCellValue(),
                            (int) itCell.next().getNumericCellValue(),
                            StudyProfile.valueOf(itCell.next().getStringCellValue())));
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "University parsing error message", e);
            e.printStackTrace();
        }

        return universityList;
    }
}