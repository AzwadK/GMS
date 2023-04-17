package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessagelabel;

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField enterPasswordField;

    public static String sid;


    public void loginButtonOnAction(ActionEvent event){

        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            setSid(usernameTextField.getText());
            validateLogin();
        } else {
            loginMessagelabel.setText("Please enter username and password!");
        }
    }

    public void setSid(String s){
        this.sid = s;
        System.out.println(sid);
    }
    public String getSid(){
        return sid;
    }

    public void validateLogin(){
        DB cn = new DB();
        Connection connectDB = cn.getConnection();

        String loginVerify = "SELECT count(1) FROM student WHERE s_id = '" + usernameTextField.getText() + "' AND s_pass = '" + enterPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet query = statement.executeQuery(loginVerify);
            while(query.next()) {
                if (query.getInt(1) == 1) {
                    loginMessagelabel.setText("Login Success!");
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Stage window = (Stage) loginButton.getScene().getWindow();
                    window.setScene(new Scene(root, 1020, 590));
                }
                else {
                    loginMessagelabel.setText("Invalid login, please try again!");

                }
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void registerButtonOnAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage window = (Stage) RegisterButton.getScene().getWindow();
        window.setScene(new Scene(root, 560, 470));
    }
}