package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.DatabaseConnection;
import sample.Main;
import sample.conostructor.UserInfo;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CreateAccount implements Initializable {
    @FXML
    private TextField createUser;
    @FXML
    private TextField createPassword;
    @FXML
    private TextField createUserPhone;
    @FXML
    private TextField createEmail;
    @FXML
    private ChoiceBox<String> usertype;

    public String selected;





    public void createOnClick(ActionEvent event) throws SQLException {

        String userName =createUser.getText() ;
        String userPassword = createPassword.getText() ;
        String userPhone = createUserPhone.getText() ;
        String userEmail = createEmail.getText() ;
        String userType = selected.toLowerCase();

       if(userName.equals("") || userPassword.equals("") || userPhone.equals("") || userEmail.equals("") || userType.equals("")) return;
        UserInfo userInfo=new UserInfo(userName,userPassword,userPhone,userEmail,userType);

        DatabaseConnection databaseConnection=new DatabaseConnection();
        Connection connectDB=databaseConnection.getConnection();
        System.out.println(connectDB);
        Statement statement=connectDB.createStatement();
        String query="INSERT INTO `user_Information` (`userName`, `userPassword`, `userPhone`, `userEmail`, `userType`) "
                +"VALUES('"+userInfo.getUserName()+"','"+userInfo.getUserPassword()+"','"+userInfo.getUserPhone()+"','"+userInfo.getUserEmail()+"','"+userInfo.getUserType()+"')";


       if(statement.executeUpdate(query)>0){
           JOptionPane.showMessageDialog(null,"Successfully Create");
           createUser.clear();
           createPassword.clear();
           createUserPhone.clear();
           createEmail.clear();
           usertype.setValue("User");
           connectDB.close();
       }
       else {
           JOptionPane.showMessageDialog(null," Create Fail");
       }




    }

    public void goLoginOnClick(ActionEvent event) {
        Main.primaryStage.show();
        loginController.createStage.close();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String>usertypelist= FXCollections.observableArrayList("User","Hospital");
        usertype.setItems(usertypelist);
        usertype.setValue("User");

    }


    public void setOnClick(ActionEvent event) {
        selected= usertype.getSelectionModel().getSelectedItem().toString();
        System.out.println(selected);
    }
}
