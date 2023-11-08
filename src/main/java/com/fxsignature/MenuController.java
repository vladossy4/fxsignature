package com.fxsignature;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button exitBtn;

    @FXML
    private Button signBTN;

    @FXML
    private Button genKeyBTN;

    @FXML
    private Button verifyBTN;

    @FXML
    private Label welcomeText;

    @FXML
    void onExitBTN(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onSignBTN(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("signm.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Signature.app");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void onGenKeyBTN(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("secretGen.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Signature.app");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void onVerifyBTN(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("verifym.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Signature.app");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
