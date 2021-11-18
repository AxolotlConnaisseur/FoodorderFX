package com.example.foodorderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteCheckController {
    @FXML
    private Button btCancel;
    @FXML
    private Button btJa;
    @FXML
    private Button btNein;

    static boolean entscheidung = false;


    @FXML
    public void initialize() {
        entscheidung = false;
    }

    @FXML
    public void btJaClick(ActionEvent e) {
        entscheidung = true;
        Stage s = (Stage) btCancel.getScene().getWindow();
        s.close();

    }

    @FXML
    public void btNeinClick(ActionEvent e) {

        entscheidung = false;
        Stage s = (Stage) btNein.getScene().getWindow();
        s.close();
    }

    @FXML
    public void btCancelClick(ActionEvent e) {

        Stage s = (Stage) btJa.getScene().getWindow();
        s.close();
    }
}
