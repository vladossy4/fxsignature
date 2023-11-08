package com.fxsignature;

import exception.IllegalParameterException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class SignController {

    @FXML
    private Button exitBtn;

    @FXML
    private TextArea messageText;

    @FXML
    private Button signBtn;

    @FXML
    private TextArea resultSign;

    @FXML
    private TextField signGparam;

    @FXML
    private TextField signPparam;

    @FXML
    private TextField signXparam;

    @FXML
    private Label welcomeText;

    @FXML
    void onExitBTN(ActionEvent event) {
        exitBtn.getScene().getWindow().hide();
    }


    @FXML
    void onSignBtn(ActionEvent event) throws IllegalParameterException {
        String text = messageText.getText();
        BigInteger P = new BigInteger(signPparam.getText());
        BigInteger G = new BigInteger(signGparam.getText());
        BigInteger X = new BigInteger(signXparam.getText());
        BigInteger messageHash = StringHasher.hashStringToBigInteger(text);
        KeyPair keypair = KeyPairFactory.createKeyPair(P,G,X, BigInteger.valueOf(0));

        Signature signature = SignatureOperation.sign(messageHash, keypair);
        //System.out.println(signature);
        resultSign.setText(String.valueOf(signature));
    }

    @FXML
    void initialize() throws IllegalParameterException {
        //BigInteger p = KeyPairFactory.getKeyPairP();
        //BigInteger g = KeyPairFactory.g;
        if (KeyPairFactory.p != null && KeyPairFactory.g != null && KeyPairFactory.x != null) {
            signPparam.setText(String.valueOf(KeyPairFactory.p));
            signGparam.setText(String.valueOf(KeyPairFactory.g));
            signXparam.setText(String.valueOf(KeyPairFactory.x));
        }
    }

}
