package com.example.foodorderfx.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ExitCheckController {

    @FXML
    private Button btJa;

    @FXML
    private Button btNein;

    public void initialize() {

    }

    @FXML
    void handleBtJa(ActionEvent event) {
        SpeiseplanController.safeChangesOnExit = true;
        SpeiseplanController.closeStage(event);
    }

    @FXML
    void handleBtNein(ActionEvent event) {
        SpeiseplanController.closeStage(event);
    }

}


