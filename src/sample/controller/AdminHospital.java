package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import sample.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminHospital implements Initializable {
    @FXML
    private BorderPane viewscreen;

    public void addDoctorOnClick(ActionEvent event) throws IOException ,ClassCastException{
       Parent pane = FXMLLoader.load(getClass().getResource("../fxml/doctorAdminPage.fxml"));
        viewscreen.setCenter(pane);

    }

    public void addTestOnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/testAdmin.fxml"));
        viewscreen.setCenter(pane);
    }

    public void addAccomodetionOnclick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/adminAccomodetion.fxml"));
        viewscreen.setCenter(pane);

    }

    public void updateOnclick(ActionEvent event) throws IOException, SQLException,ClassNotFoundException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = databaseConnection.getConnection();
        String query = "SELECT COUNT(1) FROM `hospital_information` where userid='" + loginController.hospital_login_site.toString()+ "'";
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            if(rs.getInt(1)==1){
                Parent pane = FXMLLoader.load(getClass().getResource("../fxml/informationAdminView.fxml"));
                viewscreen.setCenter(pane);
            }
            else {
                Parent pane = FXMLLoader.load(getClass().getResource("../fxml/informationAdmin.fxml"));
                viewscreen.setCenter(pane);
            }
        }
        connectDB.close();


    }

    public void addPackgeOnClick(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/adminPackge.fxml"));
        viewscreen.setCenter(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
