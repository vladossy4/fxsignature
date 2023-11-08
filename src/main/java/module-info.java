module com.example.fxsignature {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.fxsignature;
    opens com.fxsignature to javafx.fxml;
}