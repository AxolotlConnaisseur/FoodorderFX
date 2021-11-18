package com.example.foodorderfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SpeiseBearbeitenApp extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(SpeiseBearbeitenApp.class.getResource("speiseBearbeiten.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Speiseplan bearbeiten");
        stage.setScene(scene);
        stage.show();
    }
}
