package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.conostructor.AdminTest;
import sample.DatabaseConnection;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminTestController implements Initializable {
            @FXML
            private TextField test_name_textfield;
             @FXML
            private TextField test_place_textfield;
             @FXML
            private TextField test_type_textfield;
             @FXML
            private TextField test_requarment_textfield;
             @FXML
            private TextField test_time_textfield;
             @FXML
            private TextField test_day_textfield;
             @FXML
            private TextField test_rate_textfield;



    public void saveOnClick(ActionEvent event) throws SQLException {
         String test_hospital_name=AdminDashboardController.hospital_for_this_user.toString();
         String test_name=test_name_textfield.getText();
         String test_place=test_place_textfield.getText();
         String test_type=test_type_textfield.getText();
         String test_requarment=test_requarment_textfield.getText();
         String test_time=test_time_textfield.getText();
         String test_day=test_day_textfield.getText();
         String test_rate=test_rate_textfield.getText();

         if(test_hospital_name.equals("") || test_name.equals("") || test_place.equals("")||test_type.equals("")||test_requarment.equals("")||test_time.equals("")||test_day.equals("")||test_rate.equals("")) return;
        AdminTest adminTest =new AdminTest(test_hospital_name,test_name,test_place,test_type,test_requarment,test_time,test_day,test_rate);
        DatabaseConnection databaseConnection=new DatabaseConnection();
        Connection connectDB=databaseConnection.getConnection();
        Statement statement=connectDB.createStatement();
        String query="INSERT INTO `test_information` (`test_hospital_name`, `test_name`, `test_place`, `test_type`, `test_requarment`,`test_time`,`test_day`,`test_rate`) "
                +"VALUES('"+adminTest.getTest_hospital_name()+"','"+adminTest.getTest_name()+"','"+adminTest.getTest_place()+"','"+adminTest.getTest_type()+"','"+adminTest.getTest_requarment()+"','"+adminTest.getTest_time()+"','"+adminTest.getTest_day()+"','"+adminTest.getTest_rate()+"')";

        if(statement.executeUpdate(query)>0){
            JOptionPane.showMessageDialog(null,"Successfully Create");

            test_name_textfield.clear();
            test_place_textfield.clear();
            test_type_textfield.clear();
            test_requarment_textfield.clear();
            test_time_textfield.clear();
            test_day_textfield.clear();
            test_rate_textfield.clear();
            connectDB.close();

        }
        else {
            JOptionPane.showMessageDialog(null," Create Fail");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
