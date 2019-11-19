module com.mycompany.worldofzuul {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.worldofzuul to javafx.fxml;
    exports com.mycompany.worldofzuul;
}