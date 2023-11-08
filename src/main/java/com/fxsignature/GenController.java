package com.fxsignature;

import javafx.event.ActionEvent;
import exception.IllegalParameterException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class GenController {

    @FXML
    private Button exitBtn;

    @FXML
    private Button generateBNT;

    @FXML
    private TextArea resultgen;

    @FXML
    private Label welcomeText;

    @FXML
    void onExitBTN(ActionEvent event) {
        exitBtn.getScene().getWindow().hide();
    }

    @FXML
    void onGenerateBTN(ActionEvent event) {
        KeyPair keyPair = null;
        try {
            keyPair = KeyPairFactory.generateKeyPair();
        } catch (exception.IllegalParameterException e) {
            System.out.println("Invalid income parameters");
        } //y,x,p
        if (keyPair != null)
            resultgen.setText(String.valueOf(keyPair));
        else
            resultgen.setText("Попробуйте еще раз");
    }

}
