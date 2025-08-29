module com.oop.carmanufacturing {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.rmi;

    opens common to javafx.fxml;
    opens supto to javafx.fxml;
    exports common;
    exports supto;
}