package com.example.filesgenerator.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class InsuranceCompanyDatabase {
    public static ObservableList<String> readInsurerNames() throws IOException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/Lista ZU.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        ObservableList<String> insurerNames = FXCollections.observableArrayList();
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null && cell.getCellType() == CellType.STRING) {
                String insurerName = cell.getStringCellValue().trim();
                if (!insurerName.isEmpty()) {
                    insurerNames.add(insurerName);
                }
            }
        }
        return insurerNames;
    }

    public static void readOtherInsuranceData(String selectedInsuranceNumber, javafx.scene.control.TextField insurerName) throws IOException {

        FileInputStream inputStream = new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/Lista ZU.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(selectedInsuranceNumber)) {
                Cell companyCell = row.getCell(2);
                String company = companyCell != null ? companyCell.getStringCellValue().trim() : "";
                insurerName.setText(company);
            }
        }

    }
}
