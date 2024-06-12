module com.angel.btsstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.angel.btsstore.controllers to javafx.fxml;
    exports com.angel.btsstore.controllers;
    opens com.angel.btsstore to javafx.fxml;
    exports com.angel.btsstore;
    opens com.angel.btsstore.models to javafx.fxml;
    exports com.angel.btsstore.models;
}