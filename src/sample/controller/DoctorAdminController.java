package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.conostructor.AdminDoctor;
import sample.DatabaseConnection;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DoctorAdminController implements Initializable {
    @FXML
    private TextField doctor_name_textfield;
    @FXML
    private TextField doctor_email_textfield;
    @FXML
    private TextField doctor_phone_textfield;
    @FXML
    private TextField doctor_chamber_textfield;
    @FXML
    private TextField doctor_specialist_textfield;
    @FXML
    private TextField doctor_visit_time_textfield;
    @FXML
    private TextField doctor_visit_day_textfield;
    @FXML
    private TextField doctor_visit_fees_textfield;
    @FXML
    private TextField doctor_degree_textfield;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void saveOnClick(ActionEvent event) throws SQLException {

         String doctor_Hospital_Name=AdminDashboardController.hospital_for_this_user;
         String doctor_name=doctor_name_textfield.getText();
         String doctor_email=doctor_email_textfield.getText();
         String doctor_phone=doctor_phone_textfield.getText();
         String doctor_chamber=doctor_chamber_textfield.getText();
         String doctor_specialist=doctor_specialist_textfield.getText();
         String doctor_visit_time=doctor_visit_time_textfield.getText();
         String doctor_visit_day=doctor_visit_day_textfield.getText();
         String doctor_visit_fees=doctor_visit_fees_textfield.getText();
         String doctor_degree=doctor_degree_textfield.getText();

         if(doctor_name.equals("") || doctor_email.equals("") || doctor_phone.equals("") || doctor_chamber.equals("") || doctor_specialist.equals("") ||doctor_visit_time.equals("") ||doctor_visit_day.equals("") ||doctor_visit_fees.equals("")||doctor_degree.equals(""))return;

        DatabaseConnection databaseConnection=new DatabaseConnection();
        Connection connectDB=databaseConnection.getConnection();
        System.out.println(connectDB);
        AdminDoctor adminDoctor=new AdminDoctor(doctor_Hospital_Name,doctor_name,doctor_email,doctor_phone,doctor_chamber,doctor_specialist,doctor_visit_time,doctor_visit_day,doctor_visit_fees,doctor_degree);

        Statement statement=connectDB.createStatement();
        String query="INSERT INTO `doctor_information` (`doctor_Hospital_Name`, `doctor_name`, `doctor_email`, `doctor_phone`, `doctor_chamber`,`doctor_specialist`,`doctor_visit_time`,`doctor_visit_day`,`doctor_visit_fees`,`doctor_degree`) "
                +"VALUES('"+adminDoctor.getDoctor_Hospital_Name()+"','"+adminDoctor.getDoctor_name()+"','"+adminDoctor.getDoctor_email()+"','"+adminDoctor.getDoctor_phone()+"','"+adminDoctor.getDoctor_chamber()+"','"+adminDoctor.getDoctor_specialist()+"','"+adminDoctor.getDoctor_visit_time()+"','"+adminDoctor.getDoctor_visit_day()+"','"+adminDoctor.getDoctor_visit_fees()+"','"+adminDoctor.getDoctor_degree()+"')";

        if(statement.executeUpdate(query)>0){
            JOptionPane.showMessageDialog(null,"Successfully Create");

             doctor_name_textfield.clear();
             doctor_email_textfield.clear();
             doctor_phone_textfield.clear();
             doctor_chamber_textfield.clear();
             doctor_specialist_textfield.clear();
             doctor_visit_time_textfield.clear();
             doctor_visit_day_textfield.clear();
             doctor_visit_fees_textfield.clear();
             doctor_degree_textfield.clear();
            connectDB.close();
        }
        else {
            JOptionPane.showMessageDialog(null," Create Fail");
        }



    }
}
