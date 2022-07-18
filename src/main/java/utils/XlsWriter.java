package utils;

import models.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsWriter {

    private XlsWriter() {
    }

    public static void tableGenerateAndWrite(List<Statistics> statisticsList, String fileName) {

        final short blackColor = IndexedColors.BLACK.getIndex();
        // толщина границ ячейки
        final BorderStyle THIN = BorderStyle.THIN;

        //fileName = "src\\main\\resources\\statistics.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");
        XSSFRow headerRow = sheet.createRow(0);
        XSSFCell mainProfile = headerRow.createCell(0);
        XSSFCell universityName = headerRow.createCell(1);
        XSSFCell numberOfUniversitiesByProfile = headerRow.createCell(2);
        XSSFCell numberOfStudentsByProfile = headerRow.createCell(3);
        XSSFCell avgExamScore = headerRow.createCell(4);

        // заполняем значениями ячейки заголовка
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            headerRow.getCell(i).setCellType(CellType.STRING);
        }

        mainProfile.setCellValue("Профиль обучения");
        universityName.setCellValue("Наименование университета");
        numberOfUniversitiesByProfile.setCellValue("Кол-во университетов по профилю");
        numberOfStudentsByProfile.setCellValue("Кол-во студентов");
        avgExamScore.setCellValue("Средний бал по экзаменам");

        // стиль оформления ячеек заголовка
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setBorderBottom(THIN);
        headerStyle.setBorderTop(THIN);
        headerStyle.setBorderLeft(THIN);
        headerStyle.setBorderRight(THIN);
        // выравнивание
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // шрифт заголовка
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setFontName("Calibri");
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // стиль оформления остальных ячеек таблицы
        CellStyle otherCellsStyle = workbook.createCellStyle();
        otherCellsStyle.setBorderBottom(THIN);
        otherCellsStyle.setBorderTop(THIN);
        otherCellsStyle.setBorderLeft(THIN);
        otherCellsStyle.setBorderRight(THIN);
        // выравнивание
        otherCellsStyle.setAlignment(HorizontalAlignment.LEFT);
        otherCellsStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // шрифт заголовка
        Font otherCellsFont = workbook.createFont();
        otherCellsFont.setFontHeightInPoints((short) 11);
        otherCellsFont.setFontName("Calibri");
        otherCellsFont.setBold(false);
        otherCellsStyle.setFont(otherCellsFont);

        // применяем стиль оформления к заголовку и "автоширину" ячейки
        for (int i = 0; i < 5; i++) {
            headerRow.getCell(i).setCellStyle(headerStyle);
            sheet.autoSizeColumn(i);
        }

        // заполняем таблицу данными
        for (int i = 1; i <= statisticsList.size(); i++) {
            XSSFRow plainRow = sheet.createRow(i);
            XSSFCell cell0 = plainRow.createCell(0);
            cell0.setCellType(CellType.STRING);
            cell0.setCellStyle(otherCellsStyle);
            cell0.setCellValue(statisticsList.get(i - 1).getMainProfile());

            XSSFCell cell1 = plainRow.createCell(1);
            cell1.setCellType(CellType.STRING);
            cell1.setCellStyle(otherCellsStyle);
            cell1.setCellValue(statisticsList.get(i - 1).getUniversityName());

            XSSFCell cell2 = plainRow.createCell(2);
            cell2.setCellType(CellType.NUMERIC);
            cell2.setCellStyle(otherCellsStyle);
            cell2.setCellValue(statisticsList.get(i - 1).getNumberOfUniversitiesByProfile());

            XSSFCell cell3 = plainRow.createCell(3);
            cell3.setCellType(CellType.NUMERIC);
            cell3.setCellStyle(otherCellsStyle);
            cell3.setCellValue(statisticsList.get(i - 1).getNumberOfStudentsByProfile());

            XSSFCell cell4 = plainRow.createCell(4);
            cell4.setCellStyle(otherCellsStyle);
            cell4.setCellType(CellType.NUMERIC);
            cell4.setCellValue(statisticsList.get(i - 1).getAvgExamScore().orElse ((double) 0));
        }

        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            workbook.close();
            // System.out.println("File save correctly");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
