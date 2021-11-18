module com.example.foodorderfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires  kernel;
    requires layout;
    requires io;


    opens com.example.foodorderfx to javafx.fxml;
    exports com.example.foodorderfx;
}