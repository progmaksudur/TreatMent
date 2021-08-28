package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseConnection;
import sample.Main;

import java.io.IOException;
import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class loginController {
    public static  String hospital_login_site;
     public static  Stage createStage;
     public static  Stage loginStage;

    @FXML
    private TextField userEmailTextField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label loginLable;

    public void loginOnClick(ActionEvent event) throws IOException, SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = databaseConnection.getConnection();
        System.out.println(connectDB);
        if(userEmailTextField.getText().isBlank() && passwordField.getText().isBlank()){
         loginLable.setText("Fill Your Information");
        }
        else {
            String verifyLogin = "SELECT COUNT(1),userType,userName FROM `user_Information` WHERE userEmail='" + userEmailTextField.getText() + "' AND userPassword='" + passwordField.getText() + "'";
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(verifyLogin);
            while (rs.next()) {
                if (rs.getInt(1) == 1 && rs.getString("userType").equals("user")) {
                    hospital_login_site=rs.getString("userName").toString();
                    System.out.println(hospital_login_site);

                    this.loginStage = loginStage;
                    Main.primaryStage.close();
                    Parent pane = FXMLLoader.load(getClass().getResource("../fxml/dashboard.fxml"));
                    loginStage = new Stage();
                    loginStage.setScene(new Scene(pane, 1200, 600));
                    loginStage.show();
                } else if (rs.getInt(1) == 1 && rs.getString("userType").equals("hospital")) {
                    hospital_login_site=rs.getString("userName").toString();
                    System.out.println(hospital_login_site);

                    this.loginStage = loginStage;
                    Main.primaryStage.close();
                    Parent pane = FXMLLoader.load(getClass().getResource("../fxml/adminDashboard.fxml"));
                    loginStage = new Stage();
                    loginStage.setScene(new Scene(pane, 1200, 600));
                    loginStage.show();

                } else {
                    loginLable.setText("Wrong Password");
                }
            }
            connectDB.close();
        }
    }
    public void goCreateOnClick(ActionEvent event) throws IOException {
        this.createStage=createStage;
        Main.primaryStage.close();
        Parent pane = FXMLLoader.load(getClass().getResource("../fxml/createAccount.fxml"));
        createStage=new Stage();
        createStage.setScene(new Scene(pane,1200,600));
        createStage.show();
    }


}
