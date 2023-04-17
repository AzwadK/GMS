package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class addCourseController implements Initializable {

    @FXML
    private Label assgn;

    @FXML
    private TextField assgnField;

    @FXML
    private Label att;

    @FXML
    private TextField attField;

    @FXML
    private Button cancel_btn;

    @FXML
    private Label cname;

    @FXML
    private TextField courseNameField;

    @FXML
    private Label ct1;

    @FXML
    private TextField ct1Field;

    @FXML
    private Label ct2;

    @FXML
    private TextField ct2Field;

    @FXML
    private Label ct3;

    @FXML
    private TextField ct3Field;

    @FXML
    private TextField finalField;

    @FXML
    private Label finalText;

    @FXML
    private Label logo;

    @FXML
    private Label mid;

    @FXML
    private TextField midField;

    @FXML
    private Button save_btn;

    @FXML
    private Label section;

    @FXML
    private TextField sectionField;

    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    course c = null;
    private boolean update;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void save(MouseEvent event) {

        connection = DB.getConnection();
        String c_name = courseNameField.getText();
        System.out.println(c_name);
        String section = sectionField.getText();
        String ct1 = ct1Field.getText();
        String ct2 = ct2Field.getText();
        String ct3 = ct3Field.getText();
        String mid = midField.getText();
        String att = attField.getText();
        String fin = finalField.getText();
        String assign = assgnField.getText();

        if (c_name.isEmpty() || section.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Course Name and Section required MINIMUM");
            alert.showAndWait();

        } else {
            getQuery();
            insert();
            clean();

        }

    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clean() {
        courseNameField.setText(null);
        sectionField.setText(null);
        ct1Field.setText(null);
        ct2Field.setText(null);
        ct3Field.setText(null);
        midField.setText(null);
        attField.setText(null);
        finalField.setText(null);
        assgnField.setText(null);

    }

    private void getQuery() {
        LoginController lg = new LoginController();

        if (update == false) {

            query = "INSERT INTO course( `s_id` ,`c_name`, `section`, ct1, ct2, ct3,mid,attendance,assignment,final) VALUES ('"+ lg.getSid() +"',?,?,?,?,?,?,?,?,?)";

        }else{
            query = "UPDATE course SET "
                    + "`c_name`=?,"
                    + "`section`=?,"
                    + "`ct1`=?,"
                    + "`ct2`= ?,"
                    + "`ct3`= ?,"
                    + "`mid`= ?,"
                    + "`attendance`= ?,"
                    + "`assignment`= ?,"
                    + "`final`= ? WHERE s_id = '"+lg.getSid()+"' AND c_name = '"+ courseNameField.getText()+"'";
        }

    }

    private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, courseNameField.getText());
            preparedStatement.setString(2, sectionField.getText());
            if(ct1Field.getText().length() != 0 && ct1Field.getText() != null){
                preparedStatement.setString(3, ct1Field.getText());
            }else{preparedStatement.setNull(3, Types.INTEGER);}
            if(ct2Field.getText().length() != 0 && ct2Field.getText() != null) {
                preparedStatement.setString(4, ct2Field.getText());
            }else{preparedStatement.setNull(4, Types.INTEGER);}
            if(ct3Field.getText().length() != 0 && ct3Field.getText() != null) {
                preparedStatement.setString(5, ct3Field.getText());
            }else{preparedStatement.setNull(5, Types.INTEGER);}
            if(midField.getText().length() != 0 && midField.getText() != null) {
                preparedStatement.setString(6, midField.getText());
            }else{preparedStatement.setNull(6, Types.INTEGER);}
            if(attField.getText().length() != 0 && attField.getText() != null) {
                preparedStatement.setString(7, attField.getText());
            }else{preparedStatement.setNull(7, Types.INTEGER);}
            if(assgnField.getText().length() != 0 && assgnField.getText() != null) {
                preparedStatement.setString(8, assgnField.getText());
            }else{preparedStatement.setNull(8, Types.INTEGER);}
            if(finalField.getText().length() != 0 && finalField.getText() != null) {
                preparedStatement.setString(9, finalField.getText());
            }else{preparedStatement.setNull(9, Types.INTEGER);}



            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(addCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setTextField(String c_name, String section, String ct1, String ct2, String ct3 , String mid , String att , String fin , String assign) {


        courseNameField.setText(c_name);
        sectionField.setText(section);
        ct1Field.setText(ct1);
        ct2Field.setText(ct2);
        ct3Field.setText(ct3);
        midField.setText(mid);
        attField.setText(att);
        finalField.setText(fin);
        assgnField.setText(assign);

    }

    void setUpdate(boolean b) {
        this.update = b;
    }
}

