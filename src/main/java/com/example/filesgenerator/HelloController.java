package com.example.filesgenerator;

import com.example.filesgenerator.data.CompanyDatabase;
import com.example.filesgenerator.data.InsuranceCompanyDatabase;
import com.example.filesgenerator.saveData.SaveDataToDoc;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;


public class HelloController {
    //Dane najmu
    @FXML
    public DatePicker datePicker;
    @FXML
    public ComboBox<String> comboBoxRegisterNumber;
    @FXML
    public TextField textFieldMakeAndModel1;
    @FXML
    public TextField textFieldVIN;
    @FXML
    public TextField textFieldCategory;
    @FXML
    public TextField textFieldPrice;
    @FXML
    public TextField textFieldFuel;
    @FXML
    public TextField textFieldCompany;
    @FXML
    public TextField textFieldNip;
    //Poszkodowany
    @FXML
    public TextField textFieldNameAndSurname;
    @FXML
    public TextField textFieldRegisterNumber1;
    @FXML
    public TextField textFieldMakeAndModel2;
    @FXML
    public TextField textFieldStreetNameAndNumber;
    @FXML
    public TextField textFieldIdSeries;
    @FXML
    public TextField textFieldIdNumber;
    @FXML
    public TextField textFiledPostCode;
    @FXML
    public TextField textFieldLocation;
    //Sprawca
    @FXML
    public TextField textFieldInsuranceNumber;
    @FXML
    public TextField textFieldRegisterNumber2;
    @FXML
    public TextField textFiledApplicationNumber;
    @FXML
    public ComboBox<String> comboBoxInsuranceCompany;
    @FXML
    public TextField textFiledInsurerFullName;
    @FXML
    public TextField textFieldAgreementLocation;
    @FXML
    public TextField textFiledAccidentLocation;
    @FXML
    public TextField textFieldEmail;
    @FXML
    public TextField textFieldPhoneNumber;
    @FXML
    public DatePicker datePickerSecond;

    @FXML
    public void initialize() throws IOException {
        comboBoxRegisterNumber.setItems(CompanyDatabase.readLicensePlates());
        comboBoxInsuranceCompany.setItems(InsuranceCompanyDatabase.readInsurerNames());
        new AutoCompleteComboBoxListener<>(comboBoxRegisterNumber);
        new AutoCompleteComboBoxListener<>(comboBoxInsuranceCompany);
        //datePicker.setValue(LocalDate.now());
    }

    public void onActionComboBox() throws IOException {
        CompanyDatabase.readOtherData(String.valueOf(comboBoxRegisterNumber.getSelectionModel().getSelectedItem()), textFieldMakeAndModel1, textFieldVIN, textFieldCompany, textFieldNip, textFieldCategory, textFieldFuel, textFieldPrice);
    }

    public void onActionComboBoxInsurer() throws IOException {
        InsuranceCompanyDatabase.readOtherInsuranceData(comboBoxInsuranceCompany.getSelectionModel().getSelectedItem(), textFiledInsurerFullName);
    }

    public void onActionContract() {
        SaveDataToDoc.saveUmowaNajmu(textFieldMakeAndModel2.getText(), textFieldRegisterNumber1.getText().toUpperCase(),
                comboBoxInsuranceCompany.getValue(), textFiledApplicationNumber.getText(),
                datePicker, textFieldAgreementLocation.getText(), textFieldLocation.getText(), textFieldCompany.getText(),
                textFieldNip.getText(), textFieldNameAndSurname.getText(), textFiledPostCode.getText(),
                textFieldStreetNameAndNumber.getText(), textFieldIdSeries.getText().toUpperCase(), textFieldIdNumber.getText(),
                textFieldMakeAndModel1.getText(), comboBoxRegisterNumber.getSelectionModel().getSelectedItem(),
                textFieldVIN.getText(), textFieldFuel.getText(), textFieldPrice.getText(), textFieldCategory.getText());
    }

    public void onActionCession() {
        SaveDataToDoc.saveCesja(datePicker, textFieldCompany.getText(),
                textFieldNip.getText(), textFieldNameAndSurname.getText(), textFieldLocation.getText(), textFiledPostCode.getText(),
                textFieldStreetNameAndNumber.getText(), textFieldIdSeries.getText().toUpperCase(), textFieldIdNumber.getText(),
                textFieldRegisterNumber1.getText().toUpperCase(), textFieldRegisterNumber2.getText().toUpperCase(), textFieldInsuranceNumber.getText(),
                textFiledInsurerFullName.getText());
    }

    public void onActionCessionRepair() {
        SaveDataToDoc.saveCesjaNaprawa(datePicker, textFieldCompany.getText(),
                textFieldNip.getText(), textFieldNameAndSurname.getText(), textFieldLocation.getText(), textFiledPostCode.getText(),
                textFieldStreetNameAndNumber.getText(), textFieldIdSeries.getText().toUpperCase(), textFieldIdNumber.getText(),
                textFieldRegisterNumber1.getText().toUpperCase(), textFieldRegisterNumber2.getText().toUpperCase(), textFieldInsuranceNumber.getText(),
                textFiledInsurerFullName.getText());
    }

    public void onActionCommision() {
        SaveDataToDoc.savePelnomocnictwo(textFieldNameAndSurname.getText(), textFieldLocation.getText(),
                textFiledPostCode.getText(), textFieldStreetNameAndNumber.getText(), textFieldIdSeries.getText().toUpperCase(),
                textFieldIdNumber.getText(), textFieldMakeAndModel2.getText(), textFieldRegisterNumber1.getText().toUpperCase(),
                comboBoxInsuranceCompany.getValue(), textFieldInsuranceNumber.getText(), textFieldRegisterNumber2.getText().toUpperCase(),
                textFiledApplicationNumber.getText(), datePicker,
                textFieldAgreementLocation.getText());
    }

    public void onActionProtocol() {
        SaveDataToDoc.saveProtokol(datePicker,
                textFieldMakeAndModel1.getText(), comboBoxRegisterNumber.getValue(), textFieldRegisterNumber2.getText().toUpperCase(),
                textFieldMakeAndModel2.getText(), textFiledAccidentLocation.getText(), textFieldNameAndSurname.getText(),
                textFieldPhoneNumber.getText(), textFieldEmail.getText());
    }

    public void onActionButtonClear() {
        comboBoxRegisterNumber.getEditor().setText("");
        textFieldMakeAndModel1.clear();
        textFieldVIN.clear();
        textFieldCategory.clear();
        textFieldPrice.clear();
        textFieldFuel.clear();
        textFieldCompany.clear();
        textFieldNip.clear();
        textFieldNameAndSurname.clear();
        textFieldRegisterNumber1.clear();
        textFieldMakeAndModel2.clear();
        textFieldStreetNameAndNumber.clear();
        textFieldIdSeries.clear();
        textFieldIdNumber.clear();
        textFiledPostCode.clear();
        textFieldLocation.clear();
        textFieldInsuranceNumber.clear();
        textFieldRegisterNumber2.clear();
        textFiledApplicationNumber.clear();
        comboBoxInsuranceCompany.getEditor().setText("");
        textFiledInsurerFullName.clear();
        textFieldAgreementLocation.clear();
        textFiledAccidentLocation.clear();
        textFieldPhoneNumber.clear();
        textFieldEmail.clear();
        datePicker.getEditor().setText("");
        datePickerSecond.getEditor().setText("");
    }

    public void onActionReturn() {
        SaveDataToDoc.savePotwierdzenieZwrotu(comboBoxInsuranceCompany.getSelectionModel().getSelectedItem(), textFiledApplicationNumber.getText(),
                datePicker, textFieldLocation.getText(),
                textFieldCompany.getText(), textFieldNip.getText(), textFieldNameAndSurname.getText(), textFiledPostCode.getText(),
                textFieldStreetNameAndNumber.getText(), textFieldIdSeries.getText().toUpperCase(), textFieldIdNumber.getText(),
                textFieldMakeAndModel1.getText(), comboBoxRegisterNumber.getSelectionModel().getSelectedItem(),
                datePickerSecond);
    }

    public void onActionCarDeclaration() {
        SaveDataToDoc.saveOswiadczenieOPotrzebieAZ(textFieldAgreementLocation.getText(), textFieldLocation.getText(),
                textFieldNameAndSurname.getText(), textFiledPostCode.getText(), textFieldStreetNameAndNumber.getText(),
                comboBoxInsuranceCompany.getSelectionModel().getSelectedItem(), textFiledApplicationNumber.getText(),
                textFieldMakeAndModel1.getText(), comboBoxRegisterNumber.getSelectionModel().getSelectedItem(), datePicker);
    }
}