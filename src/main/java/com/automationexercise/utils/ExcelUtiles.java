package com.automationexercise.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtiles {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    // Constructor: load specific sheet
    public ExcelUtiles(String excelPath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(excelPath)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.err.println("❌ Sheet '" + sheetName + "' not found in file: " + excelPath);
            }
        } catch (IOException e) {
            System.err.println("❌ Failed to load Excel file: " + excelPath);
            e.printStackTrace();
        }
    }

    // Utility to check if sheet loaded
    public boolean isSheetLoaded() {
        return sheet != null;
    }

    // Get cell data safely
    public String getCellData(int rowNum, int colNum) {
        if (!isSheetLoaded()) return "";

        if (sheet.getRow(rowNum) == null || sheet.getRow(rowNum).getCell(colNum) == null) return "";
        XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);

        CellType type = cell.getCellType();
        switch (type) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC:
                double value = cell.getNumericCellValue();
                if (value == (long) value) return String.valueOf((long) value);
                else return String.valueOf(value);
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case BLANK: return "";
            default: return cell.toString();
        }
    }

    // Row and column counts
    public int getRowCount() {
        return isSheetLoaded() ? sheet.getPhysicalNumberOfRows() : 0;
    }

    public int getColCount() {
        if (!isSheetLoaded() || sheet.getRow(0) == null) return 0;
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    // ------------------- Sheet1: Signup -------------------
    public String getSignupName(int row) { return getCellData(row, 0); }
    public String getSignupEmail(int row) { return getCellData(row, 1); }
    public String getSignupPassword(int row) { return getCellData(row, 2); }
    public String getSignupFirstName(int row) { return getCellData(row, 3); }
    public String getSignupLastName(int row) { return getCellData(row, 4); }
    public String getSignupCompany(int row) { return getCellData(row, 5); }
    public String getSignupAddress1(int row) { return getCellData(row, 6); }
    public String getSignupAddress2(int row) { return getCellData(row, 7); }
    public String getSignupCountry(int row) { return getCellData(row, 8); }
    public String getSignupState(int row) { return getCellData(row, 9); }
    public String getSignupCity(int row) { return getCellData(row, 10); }
    public String getSignupZipcode(int row) { return getCellData(row, 11); }
    public String getSignupMobileNumber(int row) { return getCellData(row, 12); }

    // ------------------- Sheet2: Login -------------------
    public String getLoginEmail(int row) { return getCellData(row, 0); }
    public String getLoginPassword(int row) { return getCellData(row, 1); }

    // ------------------- Sheet3: Contact Us -------------------
    public String getContactName(int row) { return getCellData(row, 0); }
    public String getContactEmail(int row) { return getCellData(row, 1); }
    public String getContactSubject(int row) { return getCellData(row, 2); }
    public String getContactMessage(int row) { return getCellData(row, 3); }
}
