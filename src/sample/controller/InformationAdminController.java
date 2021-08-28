package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.DatabaseConnection;
import sample.conostructor.Hospital;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class InformationAdminController implements Initializable {
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



    public void saveOnClick(ActionEvent event) throws SQLException {

         String userid=loginController.hospital_login_site.toString();
         String hospital_name=hospital_name_textfield.getText();
         String hospital_address=hospital_address_textfield.getText();
         String hospital_numbers=hospital_numbers_textfield.getText();
         String hospital_emails=hospital_emails_textfield.getText();
         String hospital_website=hospital_website_textfield.getText();
         String hospital_type=hospital_type_textfield.getText();

         if(hospital_name.equals("") || hospital_address.equals("") || hospital_numbers.equals("") || hospital_emails.equals("") || hospital_website.equals("") || hospital_type.equals("")) return;
          Hospital hospital=new Hospital(userid,hospital_name,hospital_address,hospital_numbers,hospital_emails,hospital_website,hospital_type);
          DatabaseConnection databaseConnection=new DatabaseConnection();
          Connection connectDB=databaseConnection.getConnection();
          System.out.println(connectDB);
          Statement statement=connectDB.createStatement();
             String query="INSERT INTO `hospital_information` (`userid`, `hospital_name`, `hospital_address`, `hospital_numbers`, `hospital_emails`,`hospital_website`,`hospital_type`) "
                +"VALUES('"+hospital.getUserid()+"','"+hospital.getHospital_name()+"','"+hospital.getHospital_address()+"','"+hospital.getHospital_numbers()+"','"+hospital.getHospital_emails()+"','"+hospital.getHospital_website()+"','"+hospital.getHospital_type()+"')";


        if(statement.executeUpdate(query)>0){
            JOptionPane.showMessageDialog(null,"Successfully save");

             hospital_name_textfield.clear();
             hospital_address_textfield.clear();
             hospital_numbers_textfield.clear();
             hospital_emails_textfield.clear();
             hospital_website_textfield.clear();
             hospital_type_textfield.clear();
            connectDB.close();

        }
        else {
            JOptionPane.showMessageDialog(null,"Save Failed");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
