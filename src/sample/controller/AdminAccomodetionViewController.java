package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.DatabaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminAccomodetionViewController implements Initializable {
    @FXML
    private TextField icu_rate_textfield;
    @FXML
    private TextField ccu_rate_textfield;
    @FXML
    private TextField acCabin_rate_textfield;
    @FXML
    private TextField noneAcCabinDouble_rate_textfield;
    @FXML
    private TextField noneAcCabineSingle_rate_textfield;
    @FXML
    private TextField localBed_rate_textfield;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = null;
        try {
            connectDB = databaseConnection.getConnection();
            String quary="SELECT icu_rate,ccu_rate,acCabin_rate,noneAcCabinDouble_rate,noneAcCabineSingle_rate,localBed_rate FROM accomodetion_information where accomodetion_hospital='" +AdminDashboardController.hospital_for_this_user+ "'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                icu_rate_textfield.setText(mainTable.getString("icu_rate"));
                ccu_rate_textfield.setText(mainTable.getString("ccu_rate"));
                acCabin_rate_textfield.setText(mainTable.getString("acCabin_rate"));
                noneAcCabinDouble_rate_textfield.setText(mainTable.getString("noneAcCabinDouble_rate"));
                noneAcCabineSingle_rate_textfield.setText(mainTable.getString("noneAcCabineSingle_rate"));
                localBed_rate_textfield.setText(mainTable.getString("localBed_rate"));

            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(connectDB);

    }
}
