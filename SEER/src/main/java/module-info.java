module com.example.seer {
    requires  javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
//    requires fontawesomefx;
//    requires jfoenix;


    opens main to javafx.fxml;
    exports main;
}