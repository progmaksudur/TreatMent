package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.DatabaseConnection;
import sample.conostructor.Packge;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminPackgeController {
    @FXML
    private TextField packge_name_textfield;
    @FXML
    private TextArea packge_detail_textfield;
    @FXML
    private TextArea packge_include_textfield;
    @FXML
    private TextField packge_price_textfield;


    public void saveOnClick(ActionEvent event) throws SQLException {

          String packge_for_hospital=AdminDashboardController.hospital_for_this_user.toString();
          String packge_name=packge_name_textfield.getText();
          String packge_detail=packge_detail_textfield.getText();
          String packge_include=packge_include_textfield.getText();
          String packge_price=packge_price_textfield.getText();


          if(packge_for_hospital.equals("")||packge_name.equals("")||packge_detail.equals("")||packge_include.equals("")||packge_price.equals(""))return;

          Packge packge =new Packge(packge_for_hospital,packge_name,packge_detail,packge_include,packge_price);
          DatabaseConnection databaseConnection=new DatabaseConnection();
          Connection connectDB=databaseConnection.getConnection();
          Statement statement=connectDB.createStatement();
          String query="INSERT INTO `package_information` (`packge_for_hospital`, `packge_name`, `packge_detail`, `packge_include`, `packge_price`) "
                +"VALUES('"+packge.getPackge_for_hospital()+"','"+packge.getPackge_name()+"','"+packge.getPackge_detail()+"','"+packge.getPackge_include()+"','"+packge.getPackge_price()+"')";
            if(statement.executeUpdate(query)>0){
                JOptionPane.showMessageDialog(null,"Successfully save");
                packge_name_textfield.clear();
                packge_detail_textfield.clear();
                packge_include_textfield.clear();
                packge_price_textfield.clear();
                connectDB.close();
            }
            else {
                JOptionPane.showMessageDialog(null," Create Failed");
            }


    }
}
