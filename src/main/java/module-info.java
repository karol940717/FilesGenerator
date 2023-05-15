module com.example.filesgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires java.desktop;


    opens com.example.filesgenerator to javafx.fxml;
    exports com.example.filesgenerator;
}