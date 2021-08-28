package sample.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;

import sample.DatabaseConnection;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
        public static String hospital_for_this_user;
        @FXML
        private BorderPane adminMainPane;
        @FXML
        private Label id_admin;


    public void adminDashLogOut() {
        loginController.loginStage.close();
        Main.primaryStage.show();
    }




    public void addDoctorAppointment() throws IOException,SQLException {
        Parent pane =FXMLLoader.load(getClass().getResource("../fxml/adminDoctorView.fxml"));
        adminMainPane.setCenter(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_admin.setText(loginController.hospital_login_site);
        Parent pane = null;
        try {

            DatabaseConnection databaseConnection=new DatabaseConnection();
            Connection connectDB=databaseConnection.getConnection();
            System.out.println(connectDB);
            String query = "SELECT hospital_name FROM `hospital_information` WHERE userid='" +loginController.hospital_login_site+"'";
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                hospital_for_this_user= rs.getString("hospital_name");
            }

            pane = FXMLLoader.load(getClass().getResource("../fxml/hospitalAdmin.fxml"));
            connectDB.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        adminMainPane.setCenter(pane);



    }

    public void homeOnclick() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/hospitalAdmin.fxml"));
        adminMainPane.setCenter(pane);

    }


    public void allTestView() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/adminTestview.fxml"));
        adminMainPane.setCenter(pane);

    }

    public void adminDashAccomodetion() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/adminAccomodetionView.fxml"));
        adminMainPane.setCenter(pane);
          }

    public void packgeOnClcik() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/adminPackgeView.fxml"));
        adminMainPane.setCenter(pane);
    }
}
