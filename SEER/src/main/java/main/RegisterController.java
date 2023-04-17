package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import  javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegisterController{

    @FXML
    private Button close_btn;

    @FXML
    private Label successMessage;

    @FXML
    private PasswordField pass_tf;

    @FXML
    private PasswordField cpass_tf;

    @FXML
    private Label confirmPass;
    @FXML
    private TextField name_tf;

    @FXML
    private TextField id_tf;

    @FXML
    private TextField email_tf;

    @FXML
    private Button goBack_btn;

    public void goBackButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage window = (Stage) goBack_btn.getScene().getWindow();
        window.setScene(new Scene(root, 560, 470));
    }


    public void registerButtonOnAction(ActionEvent event){

        if (pass_tf.getText().equals(cpass_tf.getText())){
            registerUser();
            confirmPass.setText("");
        } else {
            confirmPass.setText("Password does not match");
        }
    }


    public void registerUser(){
        DB connectNow = new DB();
        Connection connectDB = connectNow.getConnection();

        String id = id_tf.getText();
        String name = name_tf.getText();
        String email = email_tf.getText();
        String password = pass_tf.getText();

        String insertFields = "INSERT INTO student (s_id, s_name, s_email, s_pass) VALUES('";
        String insertValues = id + "','" + name + "','" + email + "','" + password + "')";
        String insertRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertRegister);
            successMessage.setText("User registered successfully");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}
