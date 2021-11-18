package com.example.foodorderfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeleteCheckApp extends Application {
    public static void main(String[] args) {

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DeleteCheckApp.class.getResource("deleteCheck.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Gericht löschen?");
        stage.setScene(scene);
        stage.show();
    }
}
