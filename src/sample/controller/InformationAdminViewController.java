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

public class InformationAdminViewController implements Initializable {
    @FXML
    private TextField hospital_name_textfield;
    @FXML
    private TextField hospital_address_textfield;
    @FXML
    private TextField hospital_numbers_textfield;
    @FXML
    private TextField hospital_emails_textfield;
    @FXML
    private TextField hospital_website_textfield;
    @FXML
    private TextField hospital_type_textfield;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws ClassCastException{
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = null;
        try {
            connectDB = databaseConnection.getConnection();
            String quary="SELECT hospital_name,hospital_address,hospital_numbers,hospital_emails,hospital_website,hospital_type FROM hospital_information where userid='" + loginController.hospital_login_site.toString() + "'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                hospital_name_textfield.setText(mainTable.getString("hospital_name"));
                hospital_address_textfield.setText(mainTable.getString("hospital_address"));
                hospital_numbers_textfield.setText(mainTable.getString("hospital_numbers"));
                hospital_emails_textfield.setText(mainTable.getString("hospital_emails"));
                hospital_website_textfield.setText(mainTable.getString("hospital_website"));
                hospital_type_textfield.setText(mainTable.getString("hospital_type"));

            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
