module com.ln.crudln {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ln.crudln to javafx.fxml;
    exports com.ln.crudln;
    exports com.ln.crudln.model;
    opens com.ln.crudln.model to javafx.fxml;
    exports com.ln.crudln.ui;
    opens com.ln.crudln.ui to javafx.fxml;
    exports com.ln.crudln.service;
    opens com.ln.crudln.service to javafx.fxml;
}