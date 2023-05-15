package com.example.filesgenerator.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class CompanyDatabase {

    public static ObservableList<String> readLicensePlates() throws IOException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/Baza danych.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        ObservableList<String> licensePlates = FXCollections.observableArrayList();
        for (Row row : sheet) {
            Cell cell = row.getCell(3);
            if (cell != null && cell.getCellType() == CellType.STRING) {
                String licensePlate = cell.getStringCellValue().trim();
                if (!licensePlate.isEmpty()) {
                    licensePlates.add(licensePlate);
                }
            }
        }
        return licensePlates;
    }

    public static void readOtherData(String selectedLicensePlate, TextField commercialname, TextField VIN, TextField tfCompany, TextField NIP, TextField tfCathegory, TextField tfFuel, TextField tfPrice) throws IOException {

        FileInputStream inputStream = new FileInputStream(System.getProperty("user.home") + "/Desktop/Pliki generatora/Pliki źródłowe-NIE RUSZAĆ/Baza danych.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Cell cell = row.getCell(3);
            if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(selectedLicensePlate)) {
                Cell companyCell = row.getCell(0);
                String company = companyCell != null ? companyCell.getStringCellValue().trim() : "";
                Cell nipCell = row.getCell(1);
                String nip = nipCell != null ? nipCell.toString() : "";
                Cell modelCell = row.getCell(2);
                String makeAndModel = modelCell != null ? modelCell.getStringCellValue().trim() : "";
                Cell vinCell = row.getCell(4);
                String vin = vinCell != null ? vinCell.getStringCellValue().trim() : "";
                Cell cathegoryCell = row.getCell(5);
                String cathegory = cathegoryCell != null ? cathegoryCell.getStringCellValue().trim() : "";
                Cell priceCell = row.getCell(6);
                String price = priceCell != null ? String.valueOf(priceCell.getNumericCellValue()).trim() : "";
                Cell fuelCell = row.getCell(7);
                String fuel = fuelCell != null ? fuelCell.getStringCellValue().trim() : "";

                tfCompany.setText(company);
                NIP.setText(nip);
                commercialname.setText(makeAndModel);
                VIN.setText(vin);
                tfCathegory.setText(cathegory);
                tfPrice.setText(price.substring(0, 3));
                tfFuel.setText(fuel);
            }
        }
    }
}

