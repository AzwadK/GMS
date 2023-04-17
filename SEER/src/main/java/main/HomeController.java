package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;



public class HomeController implements Initializable {


    @FXML
    private Label st_id;

    @FXML
    private TableColumn<course, Integer> assgn_col;

    @FXML
    private TableColumn<course, Integer> att_col;

    @FXML
    private TableColumn<course, String> cname_col;

    @FXML
    private TableColumn<course, Integer> ct1_col;

    @FXML
    private TableColumn<course, Integer> ct2_col;

    @FXML
    private TableColumn<course, Integer> ct3_col;

    @FXML
    private TableColumn<course, String> edit_col;

    @FXML
    private TableColumn<course, Integer> final_col;

    @FXML
    private Tab homeTab;

    @FXML
    private Label logo1;

    @FXML
    private Button logout_btn;

    @FXML
    private TableColumn<course, Integer> mid_col;

    @FXML
    private Button newCourse_btn;

    @FXML
    private Tab progressTab;

    @FXML
    private TableColumn<course, Integer> sec_col;

    @FXML
    private Label st_name;

    @FXML
    private TableView<course> courseview;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    course course = null;

    ObservableList<course> Courselist = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        try {
            LoginController lg = new LoginController();
            query = "SELECT s_name FROM student WHERE s_id = '" + lg.getSid() + "'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            st_name.setText("Name: " + resultSet.getString("s_name"));
            String s_id = lg.getSid();
//            System.out.println(s_id);
            st_id.setText("ID: " + s_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void goBackButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage window = (Stage) logout_btn.getScene().getWindow();
        window.setScene(new Scene(root, 560, 470));
    }
    @FXML
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addCourse.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void refreshTable () {
        try {
            LoginController lg = new LoginController();
            Courselist.clear();

            query = "SELECT * FROM course WHERE s_id = '" + lg.getSid() + "'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                Courselist.add(new course(
                        resultSet.getString("c_name"),
                        resultSet.getString("section"),
                        resultSet.getString("ct1"),
                        resultSet.getString("ct2"),
                        resultSet.getString("ct3"),
                        resultSet.getString("mid"),
                        resultSet.getString("attendance"),
                        resultSet.getString("assignment"),
                        resultSet.getString("final")

                        ));
                courseview.setItems(Courselist);
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = resultSet.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }

            }


        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void print(MouseEvent event) {
    }

    private void loadData() {

        connection = DB.getConnection();
        refreshTable();

        assgn_col.setCellValueFactory(new PropertyValueFactory<>("assign"));
        att_col.setCellValueFactory(new PropertyValueFactory<>("att"));
        cname_col.setCellValueFactory(new PropertyValueFactory<>("c_name"));
        ct1_col.setCellValueFactory(new PropertyValueFactory<>("ct1"));
        ct2_col.setCellValueFactory(new PropertyValueFactory<>("ct2"));
        ct3_col.setCellValueFactory(new PropertyValueFactory<>("ct3"));
        final_col.setCellValueFactory(new PropertyValueFactory<>("fin"));
        mid_col.setCellValueFactory(new PropertyValueFactory<>("mid"));
        sec_col.setCellValueFactory(new PropertyValueFactory<>("section"));


        //add cell of button edit
        Callback<TableColumn<course, String>, TableCell<course, String>> cellFactory = (TableColumn<course, String> param) -> {
            // make cell containing buttons
            final TableCell<course, String> cell = new TableCell<course, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

//                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
//                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        Button delete = new Button();
                        Button edit = new Button();
                        Button stats = new Button();

                        delete.setStyle(
                                " -fx-cursor: hand ;"
                                        + "-glyph-size:28px;"
                                        + "-fx-fill:#ff1744;"
                        );
                        edit.setStyle(
                                " -fx-cursor: hand ;"
                                        + "-glyph-size:28px;"
                                        + "-fx-fill:#00E676;"
                        );
                        delete.setMinWidth(28);
                        edit.setMinWidth(28);



                        delete.setText("Delete");
                        edit.setText("Update");
                        stats.setText("Stats");

                        stats.setOnMouseClicked((MouseEvent event) -> {
                            course = courseview.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("stats.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            statsController statsController = loader.getController();
                            statsController.setTextField(course.getC_name(), course.getSection(), course.getCt1(), course.getCt2() , course.getCt3() ,course.getMid() ,course.getAtt() ,course.getFin() , course.getAssign());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                        });
                        delete.setOnMouseClicked((MouseEvent event) -> {

                            try {
                                LoginController lg = new LoginController();
                                course = courseview.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `course` WHERE s_id  = '"+lg.getSid()+"' AND c_name = '"+course.getC_name()+"'";
                                connection = DB.getConnection();
                                preparedStatement = connection.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();

                            } catch (SQLException ex) {
                                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                            }





                        });
                        edit.setOnMouseClicked((MouseEvent event) -> {

                            course = courseview.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("addCourse.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            addCourseController addcoursecontroller = loader.getController();
                            addcoursecontroller.setUpdate(true);
                            addcoursecontroller.setTextField(course.getC_name(), course.getSection(), course.getCt1(), course.getCt2() , course.getCt3() ,course.getMid() ,course.getAtt() ,course.getFin() , course.getAssign());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();




                        });

                        HBox managebtn = new HBox(edit, delete, stats);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(delete, new Insets(2, 2, 0, 3));
                        HBox.setMargin(edit, new Insets(2, 3, 0, 2));
                        HBox.setMargin(stats, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        edit_col.setCellFactory(cellFactory);
        courseview.setItems(Courselist);


    }

}



