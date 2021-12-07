module com.example.foodorderfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires  kernel;
    requires layout;
    requires io;


    opens com.example.foodorderfx to javafx.fxml;
    exports com.example.foodorderfx;
    exports com.example.foodorderfx.used;
    opens com.example.foodorderfx.used to javafx.fxml;
    exports com.example.foodorderfx.temp;
    opens com.example.foodorderfx.temp to javafx.fxml;
    exports com.example.foodorderfx.gui;
    opens com.example.foodorderfx.gui to javafx.fxml;
}