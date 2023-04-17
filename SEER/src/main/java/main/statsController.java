package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class statsController implements Initializable {

    @FXML
    private Label assgn_marks;

    @FXML
    private Label attendance_marks;

    @FXML
    private Label course_name;

    @FXML
    private Label ct_1;

    @FXML
    private Label ct_2;

    @FXML
    private Label ct_3;

    @FXML
    private Label final_marks;

    @FXML
    private TextField goal_grade;

    @FXML
    private Label grade;

    @FXML
    private Label m1;

    @FXML
    private Label m2;

    @FXML
    private Label m3;

    @FXML
    private Label m4;

    @FXML
    private Label m5;

    @FXML
    private Label m6;

    @FXML
    private Label m7;

    @FXML
    private Label mid_marks;

    @FXML
    private ProgressBar pg_bar;

    @FXML
    private Label section_n;

    @FXML
    private Button set_grade;

    @FXML
    private Label t_1;

    @FXML
    private Label t_2;

    @FXML
    private Label t_3;

    @FXML
    private Label t_4;

    @FXML
    private Label t_5;

    @FXML
    private Label t_6;

    @FXML
    private Label t_7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    void setTextField(String c_name, String section, String ct1, String ct2, String ct3 , String mid , String att , String fin , String assign) {


        course_name.setText("Course: "+c_name);
        section_n.setText("Section: "+section);
        ct_1.setText(ct1);
        ct_2.setText(ct2);
        ct_3.setText(ct3);
        mid_marks.setText(mid);
        attendance_marks.setText(att);
        final_marks.setText(fin);
        assgn_marks.setText(assign);

    }

    void prog(int v){
        int c1 = parseInt(ct_1.getText());
        int c2 = parseInt(ct_2.getText());
        int c3 = parseInt(ct_3.getText());
        int md = parseInt(mid_marks.getText());
        int at = parseInt(attendance_marks.getText());
        int ass= parseInt(assgn_marks.getText());
        int fn = parseInt(final_marks.getText());

        double sum = c1+c2+c3+md+fn+ass+at;
        double value = sum/v;
        pg_bar.setProgress(value);

    }

    @FXML
    private void calculate(javafx.scene.input.MouseEvent mouseEvent){

        grade.setText(goal_grade.getText());

        int c1 = parseInt(ct_1.getText());
        int c2 = parseInt(ct_2.getText());
        int c3 = parseInt(ct_3.getText());
        int md = parseInt(mid_marks.getText());
        int at = parseInt(attendance_marks.getText());
        int ass= parseInt(assgn_marks.getText());
        int fn = parseInt(final_marks.getText());

        if(Objects.equals(goal_grade.getText(), "A")) {
            prog(90);
            int loss = 0;
            int i =0;
            t_1.setText("10");
            t_2.setText("10");
            t_3.setText("10");
            t_4.setText("25");
            t_5.setText("5");
            t_6.setText("5");
            t_7.setText("35");
//            System.out.println("in");
            while (true) {
//                System.out.println("in2");
                if (c1 == 10) {
                    m1.setText("Target marks achieved, on track!.");
                } else if (c1 > 10) {
                    int dif = c1 - 10;
                    int sum = 10 - dif;
                    t_2.setText(sum + "");
                    m1.setText("Marks surplus,next CT target reduced!.");
                } else if(c1 < 10 && c1>0){
                    int dif = 10 - c1;
                    loss = loss + dif;
                    int sum = 10 + dif;
                    t_2.setText(sum + "");
                    m1.setText("Insufficient marks,next CT target increased.");
                }

                if (c2 == 10) {
                    m2.setText("Target marks achieved, on track!.");
                } else if (c2 > 10) {
                    int dif = c2 - 10;
                    int sum = 10 - dif;
                    t_3.setText(sum + "");
                    m2.setText("Marks surplus,next CT target reduced!.");
                } else if (c2>0 && c2 <10){
                    int dif = 10 - c2;
                    int sum = 10 + dif;
                    loss = loss + dif;
                    t_3.setText(sum + "");
                    m2.setText("Insufficient marks,next CT target increased.");
                }

                if (c3 == 10) {
                    m3.setText("Target marks achieved, on track!.");
                } else if (c3 > 10) {
                    int dif = c3 - 10;
                    int sum = 10 - dif;
                    t_7.setText(sum + "");
                    m3.setText("Marks surplus,Finals target reduced!.");
                } else if (c3>0 && c3<10){
                    int dif = 10 - c3;
                    int sum = 10 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m3.setText("Insufficient marks,Finals target increased.");
                }

                if (at == 5) {
                    m5.setText("Target marks achieved, on track!.");
                } else if (at > 5) {
                    int dif = at - 5;
                    int sum = 5 - dif;
                    t_4.setText(sum + "");
                    m5.setText("Marks surplus,Mid  target reduced!.");
                } else if(at>0 && at<5){
                    int dif = 5 - at;
                    int sum = 5 + dif;
                    loss = loss + dif;
                    t_4.setText(sum + "");
                    m5.setText("Insufficient marks,Mid target increased.");
                }
                if (ass == 5) {
                    m6.setText("Target marks achieved, on track!.");
                } else if (ass > 5) {
                    int dif = ass - 5;
                    int sum = 5 - dif;
                    t_7.setText(sum + "");
                    m6.setText("Marks surplus,Final  target reduced!.");
                } else if (ass>0 && ass<5){
                    int dif = 5 - ass;
                    int sum = 5 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m6.setText("Insufficient marks,Final target increased.");
                }

                if (md == 20) {
                    m4.setText("Target marks achieved, on track!.");
                } else if (md > 5) {
                    int dif = md - 5;
                    int sum = 5 - dif;
                    t_7.setText(sum + "");
                    m4.setText("Marks surplus,Final  target reduced!.");
                } else if(md>0 && at<20){
                    int dif = 5 - md;
                    int sum = 5 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m4.setText("Insufficient marks,Final target increased.");
                }

                if (fn == 30) {
                    m7.setText("Target marks achieved, on track!.");
                } else if (fn > 30) {
                    int dif = fn - 30;
                    int sum = 30 - dif;
                    t_7.setText(sum + "");
                    m7.setText("Marks surplus,Final  target reduced!.");
                } else if(fn>0 && fn<30){
                    int dif = 30 - fn;
                    int sum = 30 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m7.setText("Congrats on ending the semester!");


                }
                if(loss >=35)
                {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Unable to reach Goal grade, setting goal to next best grade..");
                    grade.setText("B+");
                    a.show();
                    break;
                }
                if(i == 1){
                    break;
                }
                i++;

            }

        }
        if(Objects.equals(grade.getText(), "A-")){
            double loss = 0;
            int i = 0;
            t_1.setText("9.3");
            t_2.setText("9.3");
            t_3.setText("9.3");
            t_4.setText("20");
            t_5.setText("4");
            t_6.setText("4");
            t_7.setText("30");

            while (true) {

                if (c1 == 9.3) {
                    m1.setText("Target marks achieved, on track!.");
                } else if (c1 > 9.3) {
                    double dif = c1 - 9.3;
                    double sum = 9.3 - dif;
                    t_2.setText(sum + "");
                    m1.setText("Marks surplus,next CT target reduced!.");
                } else if(c1>0 && c1<9.3){
                    double dif = 9.3 - c1;
                    loss = loss + dif;
                    double sum = 9.3 + dif;
                    t_2.setText(sum + "");
                    m1.setText("Insufficient marks,next CT target increased.");
                }

                if (c2 == 9.3) {
                    m2.setText("Target marks achieved, on track!.");
                } else if (c2 > 9.3) {
                    double dif = c2 - 9.3;
                    double sum = 9.3 - dif;
                    t_3.setText(sum + "");
                    m2.setText("Marks surplus,next CT target reduced!.");
                } else if(c2 >0 && c2< 9.3){
                    double dif = 9.3 - c2;
                    double sum = 9.3 + dif;
                    loss = loss + dif;
                    t_3.setText(sum + "");
                    m2.setText("Insufficient marks,next CT target increased.");
                }

                if (c3 == 9.3) {
                    m3.setText("Target marks achieved, on track!.");
                } else if (c3 > 9.3) {
                    double dif = c3 - 9.3;
                    double sum = 9.3 - dif;
                    t_7.setText(sum + "");
                    m3.setText("Marks surplus,Finals target reduced!.");
                } else if(c3>0 && c3<9.3){
                    double dif = 9.3 - c3;
                    double sum = 9.3 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m3.setText("Insufficient marks,Finals target increased.");
                }

                if (at == 4) {
                    m5.setText("Target marks achieved, on track!.");
                } else if (at > 4) {
                    int dif = at - 4;
                    int sum = 4 - dif;
                    t_4.setText(sum + "");
                    m5.setText("Marks surplus,Mid  target reduced!.");
                } else if(at>0 && at<4){
                    int dif = 4 - at;
                    int sum = 4 + dif;
                    loss = loss + dif;
                    t_4.setText(sum + "");
                    m5.setText("Insufficient marks,Mid target increased.");
                }
                if (ass == 4) {
                    m6.setText("Target marks achieved, on track!.");
                } else if (ass > 4) {
                    int dif = ass - 4;
                    int sum = 4 - dif;
                    t_7.setText(sum + "");
                    m6.setText("Marks surplus,Final  target reduced!.");
                } else if(ass>0 && ass<4){
                    int dif = 4 - ass;
                    int sum = 4 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m6.setText("Insufficient marks,Final target increased.");
                }

                if (md == 20) {
                    m4.setText("Target marks achieved, on track!.");
                } else if (md > 20) {
                    int dif = md - 20;
                    int sum = 20 - dif;
                    t_7.setText(sum + "");
                    m4.setText("Marks surplus,Final  target reduced!.");
                } else if(md>0 && md<20){
                    int dif = 20 - md;
                    int sum = 20 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m4.setText("Insufficient marks,Final target increased.");
                }

                if (fn == 30) {
                    m7.setText("Target marks achieved, on track!.");
                } else if (fn > 30) {
                    int dif = fn - 30;
                    int sum = 30 - dif;
                    t_7.setText(sum + "");
                    m7.setText("Marks surplus,Final  target reduced!.");
                } else if(fn>0 && fn<30){
                    int dif = 30 - fn;
                    int sum = 30 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m7.setText("Congrats on finishing the semester!");


                }

                if(loss >=30)
                {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Unable to reach Goal grade, setting goal to next best grade..");
                    grade.setText("B+");
                    a.show();
                    break;
                }
                if(i == 1){
                    break;
                }
                i++;



            }

        }

        if(Objects.equals(grade.getText(), "B+")){
            double loss = 0;
            int i = 0;
            t_1.setText("8.33");
            t_2.setText("8.33");
            t_3.setText("8.33");
            t_4.setText("20");
            t_5.setText("3.5");
            t_6.setText("3.5");
            t_7.setText("30");

            while (true) {

                if (c1 == 8.33) {
                    m1.setText("Target marks achieved, on track!.");
                } else if (c1 > 8.33) {
                    double dif = c1 - 8.33;
                    double sum = 8.33 - dif;
                    t_2.setText(sum + "");
                    m1.setText("Marks surplus,next CT target reduced!.");
                } else if(c1>0 && c1<8.33){
                    double dif = 8.33 - c1;
                    loss = loss + dif;
                    double sum = 8.33 + dif;
                    t_2.setText(sum + "");
                    m1.setText("Insufficient marks,next CT target increased.");
                }

                if (c2 == 8.33) {
                    m2.setText("Target marks achieved, on track!.");
                } else if (c2 > 8.33) {
                    double dif = c2 - 8.33;
                    double sum = 8.33 - dif;
                    t_3.setText(sum + "");
                    m2.setText("Marks surplus,next CT target reduced!.");
                } else if(c2 >0 && c2< 8.33){
                    double dif = 8.33 - c2;
                    double sum = 8.33 + dif;
                    loss = loss + dif;
                    t_3.setText(sum + "");
                    m2.setText("Insufficient marks,next CT target increased.");
                }

                if (c3 == 8.33) {
                    m3.setText("Target marks achieved, on track!.");
                } else if (c3 > 8.33) {
                    double dif = c3 - 8.33;
                    double sum = 8.33 - dif;
                    t_7.setText(sum + "");
                    m3.setText("Marks surplus,Finals target reduced!.");
                } else if(c3>0 && c3<8.33){
                    double dif = 8.33 - c3;
                    double sum = 8.33 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m3.setText("Insufficient marks,Finals target increased.");
                }

                if (at == 3.5) {
                    m5.setText("Target marks achieved, on track!.");
                } else if (at > 3.5) {
                    double dif = at - 3.5;
                    double sum = 3.5 - dif;
                    t_4.setText(sum + "");
                    m5.setText("Marks surplus,Mid  target reduced!.");
                } else if(at>0 && at<3.5){
                    double dif = 3.5 - at;
                    double sum = 3.5 + dif;
                    loss = loss + dif;
                    t_4.setText(sum + "");
                    m5.setText("Insufficient marks,Mid target increased.");
                }
                if (ass == 3.5) {
                    m6.setText("Target marks achieved, on track!.");
                } else if (ass > 3.5) {
                    double dif = ass - 3.5;
                    double sum = 3.5 - dif;
                    t_7.setText(sum + "");
                    m6.setText("Marks surplus,Final  target reduced!.");
                } else if(ass>0 && ass<3.5){
                    double dif = 3.5 - ass;
                    double sum = 3.5 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m6.setText("Insufficient marks,Final target increased.");
                }

                if (md == 20) {
                    m4.setText("Target marks achieved, on track!.");
                } else if (md > 20) {
                    int dif = md - 20;
                    int sum = 20 - dif;
                    t_7.setText(sum + "");
                    m4.setText("Marks surplus,Final  target reduced!.");
                } else if(md>0 && md<20){
                    int dif = 20 - md;
                    int sum = 20 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m4.setText("Insufficient marks,Final target increased.");
                }

                if (fn == 30) {
                    m7.setText("Target marks achieved, on track!.");
                } else if (fn > 30) {
                    int dif = fn - 30;
                    int sum = 30 - dif;
                    t_7.setText(sum + "");
                    m7.setText("Marks surplus,Final  target reduced!.");
                } else if(fn>0 && fn<30){
                    int dif = 30 - fn;
                    int sum = 30 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m7.setText("Unable to achieve goal grade :(  setting goal to next best grade..");
                    grade.setText("B");

                }

                if(loss >=30)
                {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Unable to reach Goal grade, setting goal to next best grade..");
                    grade.setText("B");
                    a.show();
                    break;
                }
                if(i == 1){
                    break;
                }
                i++;



            }



        }

        if(Objects.equals(grade.getText(), "B")){
            double loss = 0;
            int i = 0;
            t_1.setText("7.3");
            t_2.setText("7.3");
            t_3.setText("7.3");
            t_4.setText("20");
            t_5.setText("3.5");
            t_6.setText("3.5");
            t_7.setText("30");

            while (true) {

                if (c1 == 7.3) {
                    m1.setText("Target marks achieved, on track!.");
                } else if (c1 > 7.3) {
                    double dif = c1 - 7.3;
                    double sum = 7.3 - dif;
                    t_2.setText(sum + "");
                    m1.setText("Marks surplus,next CT target reduced!.");
                } else if(c1>0 && c1<7.3){
                    double dif = 7.3 - c1;
                    loss = loss + dif;
                    double sum = 7.3 + dif;
                    t_2.setText(sum + "");
                    m1.setText("Insufficient marks,next CT target increased.");
                }

                if (c2 == 7.3) {
                    m2.setText("Target marks achieved, on track!.");
                } else if (c2 > 7.3) {
                    double dif = c2 - 7.3;
                    double sum = 7.3 - dif;
                    t_3.setText(sum + "");
                    m2.setText("Marks surplus,next CT target reduced!.");
                } else if(c2 >0 && c2< 7.3){
                    double dif = 7.3 - c2;
                    double sum = 7.3 + dif;
                    loss = loss + dif;
                    t_3.setText(sum + "");
                    m2.setText("Insufficient marks,next CT target increased.");
                }

                if (c3 == 7.3) {
                    m3.setText("Target marks achieved, on track!.");
                } else if (c3 > 7.3) {
                    double dif = c3 - 7.3;
                    double sum = 7.3 - dif;
                    t_7.setText(sum + "");
                    m3.setText("Marks surplus,Finals target reduced!.");
                } else if(c3>0 && c3<7.3){
                    double dif = 7.3 - c3;
                    double sum = 7.3 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m3.setText("Insufficient marks,Finals target increased.");
                }

                if (at == 3.5) {
                    m5.setText("Target marks achieved, on track!.");
                } else if (at > 3.5) {
                    double dif = at - 3.5;
                    double sum = 3.5 - dif;
                    t_4.setText(sum + "");
                    m5.setText("Marks surplus,Mid  target reduced!.");
                } else if(at>0 && at<3.5){
                    double dif = 3.5 - at;
                    double sum = 3.5 + dif;
                    loss = loss + dif;
                    t_4.setText(sum + "");
                    m5.setText("Insufficient marks,Mid target increased.");
                }
                if (ass == 3.5) {
                    m6.setText("Target marks achieved, on track!.");
                } else if (ass > 3.5) {
                    double dif = ass - 3.5;
                    double sum = 3.5 - dif;
                    t_7.setText(sum + "");
                    m6.setText("Marks surplus,Final  target reduced!.");
                } else if(ass>0 && ass<3.5){
                    double dif = 3.5 - ass;
                    double sum = 3.5 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m6.setText("Insufficient marks,Final target increased.");
                }

                if (md == 20) {
                    m4.setText("Target marks achieved, on track!.");
                } else if (md > 20) {
                    int dif = md - 20;
                    int sum = 20 - dif;
                    t_7.setText(sum + "");
                    m4.setText("Marks surplus,Final  target reduced!.");
                } else if(md>0 && md<20){
                    int dif = 20 - md;
                    int sum = 20 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m4.setText("Insufficient marks,Final target increased.");
                }

                if (fn == 30) {
                    m7.setText("Target marks achieved, on track!.");
                } else if (fn > 30) {
                    int dif = fn - 30;
                    int sum = 30 - dif;
                    t_7.setText(sum + "");
                    m7.setText("Marks surplus,Final  target reduced!.");
                } else if(fn>0 && fn<30){
                    int dif = 30 - fn;
                    int sum = 30 + dif;
                    loss = loss + dif;
                    t_7.setText(sum + "");
                    m7.setText("Congratulations on finishing the semester!");

                }
                if(loss >=30)
                    {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setAlertType(Alert.AlertType.WARNING);
                        a.setContentText("Unable to reach Goal grade, setting goal to next best grade..");
                        grade.setText("B-");
                        a.show();
                        break;
                    }
                if(i == 1){
                    break;
                }
                i++;

            }



        }

    }



}