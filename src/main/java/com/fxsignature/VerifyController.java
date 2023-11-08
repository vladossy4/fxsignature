package com.fxsignature;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VerifyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField aText;

    @FXML
    private TextField bText;

    @FXML
    private Button exitBtn;

    @FXML
    private TextArea messageText;

    @FXML
    private TextField pText;

    @FXML
    private TextArea resultVerify;

    @FXML
    private Button verifyBtn;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField yText;

    @FXML
    void onExitBTN(ActionEvent event) {
        exitBtn.getScene().getWindow().hide();
    }

    @FXML
    void onVerifyBtn(ActionEvent event) {
        String text = messageText.getText();
        BigInteger a = new BigInteger(aText.getText());
        BigInteger b = new BigInteger(bText.getText());
        BigInteger y = new BigInteger(yText.getText());
        BigInteger p = new BigInteger(pText.getText());
        BigInteger messageHash = StringHasher.hashStringToBigInteger(text);
        boolean isVerified = SignatureOperation.verify(messageHash, new Signature(a,b), y, p);
        //System.out.println("Подпись подтвержена: " + isVerified);
        resultVerify.setText("Подпись подтверждена: " + isVerified);
    }

    @FXML
    void initialize() {
        if (KeyPairFactory.y != null && KeyPairFactory.p != null && Signature.a != null&& Signature.b != null) {
            aText.setText(String.valueOf(Signature.a));
            bText.setText(String.valueOf(Signature.b));
            yText.setText(String.valueOf(KeyPairFactory.y));
            pText.setText(String.valueOf(KeyPairFactory.p));
        }
    }

}
