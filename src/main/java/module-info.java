module RecycleMe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires java.logging;
    requires java.xml;
   requires jasperreports;


    opens com.recycleme.reports to javafx.fxml;
    exports com.recycleme.reports;
}