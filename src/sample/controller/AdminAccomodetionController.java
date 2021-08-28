package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.conostructor.Accomodetion;
import sample.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminAccomodetionController {
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



    public void saveOnClick() throws SQLException {
          String accomodetion_hospital=AdminDashboardController.hospital_for_this_user;
          String icu_rate=icu_rate_textfield.getText();
          String ccu_rate=ccu_rate_textfield.getText();
          String acCabin_rate=acCabin_rate_textfield.getText();
          String noneAcCabinDouble_rate=noneAcCabinDouble_rate_textfield.getText();
          String noneAcCabineSingle_rate=noneAcCabineSingle_rate_textfield.getText();
          String localBed_rate=localBed_rate_textfield.getText();

          if(accomodetion_hospital.equals("")||icu_rate.equals("")||ccu_rate.equals("")||acCabin_rate.equals("")||noneAcCabinDouble_rate.equals("")||noneAcCabineSingle_rate.equals("")||localBed_rate.equals("")) return;

        Accomodetion accomodetion=new Accomodetion(accomodetion_hospital,icu_rate,ccu_rate,acCabin_rate,noneAcCabinDouble_rate,noneAcCabineSingle_rate,localBed_rate);

        DatabaseConnection databaseConnection=new DatabaseConnection();
        Connection connectDB=databaseConnection.getConnection();
        System.out.println(connectDB);
        Statement statement=connectDB.createStatement();
        String query="INSERT INTO `accomodetion_information` (`accomodetion_hospital`, `icu_rate`, `ccu_rate`, `acCabin_rate`, `noneAcCabinDouble_rate`,`noneAcCabineSingle_rate`,`localBed_rate`) "
                +"VALUES('"+accomodetion.getAccomodetion_hospital()+"','"+accomodetion.getIcu_rate()+"','"+accomodetion.getCcu_rate()+"','"+accomodetion.getAcCabin_rate()+"','"+accomodetion.getNoneAcCabinDouble_rate()+"','"+accomodetion.getNoneAcCabineSingle_rate()+"','"+accomodetion.getLocalBed_rate()+"')";

        if(statement.executeUpdate(query)>0){
            JOptionPane.showMessageDialog(null,"Successfully save");
            icu_rate_textfield.clear();
            ccu_rate_textfield.clear();
            acCabin_rate_textfield.clear();
            noneAcCabinDouble_rate_textfield.clear();
            noneAcCabineSingle_rate_textfield.clear();
            localBed_rate_textfield.clear();

        }
        else {
            JOptionPane.showMessageDialog(null," Save Failed");
        }
        connectDB.close();




    }
}
