package com.example.foodorderfx.gui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class ClickedControls {

    ArrayList<Label> nameLabels;
    ArrayList<Label> preisLabels;
    ArrayList<ImageView> imageViews;


    SpeiseplanController controller;

    Label lblName;
    Label lblPreis;
    ImageView imageView;

    public ClickedControls(SpeiseplanController controller) {

        this.controller = controller;
        nameLabels = new ArrayList<>(
                Arrays.asList(controller.lblNameA1, controller.lblNameA2, controller.lblNameA3, controller.lblNameA4, controller.lblNameA5,
                        controller.lblNameB1, controller.lblNameB2, controller.lblNameB3, controller.lblNameB4, controller.lblNameB5));
        preisLabels = new ArrayList<>(
                Arrays.asList(controller.preisA1, controller.preisA2, controller.preisA3, controller.preisA4, controller.preisA5,
                        controller.preisB1, controller.preisB2, controller.preisB3, controller.preisB4, controller.preisB5));
        imageViews = new ArrayList<>(
                Arrays.asList(controller.imgViewA1, controller.imgViewA2, controller.imgViewA3, controller.imgViewA4, controller.imgViewA5,
                        controller.imgViewB1, controller.imgViewB2, controller.imgViewB3, controller.imgViewB4, controller.imgViewB5)
        );

    }

    public void calculateIndex(Node clicked) {
        int index = -1;
        if (clicked.getId().indexOf("lblName") == 0) {
            index = getIndexForClickedNameLabel(controller, (Label) clicked);
        }
        if (clicked.getId().indexOf("preis") == 0) {
            index = getIndexForClickedPreisLabel(controller, (Label) clicked);
        }
        if (clicked.getId().indexOf("imgView") == 0) {
            index = getIndexForClickedImageView(controller, (ImageView) clicked);
        }

        lblName = nameLabels.get(index);
        lblPreis = preisLabels.get(index);
        imageView = imageViews.get(index);
    }

    private int getIndexForClickedNameLabel(SpeiseplanController controller, Label clickedName) {
        return nameLabels.indexOf(clickedName);
    }

    private int getIndexForClickedPreisLabel(SpeiseplanController controller, Label clickedPreis) {
        return preisLabels.indexOf(clickedPreis);
    }

    private int getIndexForClickedImageView(SpeiseplanController controller, ImageView clickedImage) {
        return imageViews.indexOf(clickedImage);
    }

    public Label getLblName() {
        return lblName;
    }

    public Label getLblPreis() {
        return lblPreis;
    }

    public ImageView getImageView() {
        return imageView;
    }

}
