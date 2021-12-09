package com.example.foodorderfx.temp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.awt.Desktop;
import java.io.IOException;

public class Playground extends Application {
    public static void main(String[] args) throws IOException {

        if (Desktop.isDesktopSupported()) {
            System.out.println("Hallo");
            Desktop d = Desktop.getDesktop();
            d.open(new File("C:\\Users\\Franzi\\FoodorderFX\\src\\main\\java\\com\\example\\foodorderfx\\pdf\\test.txt"));
        }

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
