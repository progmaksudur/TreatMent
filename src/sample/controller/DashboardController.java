package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private   BorderPane userMainPane;
    @FXML
    private Label id_user;

    public void userDashHospital(ActionEvent event) throws IOException {
        Parent pane =FXMLLoader.load(getClass().getResource("../fxml/userHospital.fxml"));
        userMainPane.setCenter(pane);

    }

    public void userDashDoctor(ActionEvent event) throws IOException {
       Parent pane =FXMLLoader.load(getClass().getResource("../fxml/userDoctor.fxml"));
        userMainPane.setCenter(pane);
    }

    public void userDashLogOut(ActionEvent event) {
        loginController.loginStage.close();
        Main.primaryStage.show();
    }

    public void userEstimatedCost(ActionEvent event) throws IOException {
        Parent pane =FXMLLoader.load(getClass().getResource("../fxml/estimatedCost.fxml"));
        userMainPane.setCenter(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_user.setText(loginController.hospital_login_site);
    }

    public void userTestOnClick(ActionEvent event) throws IOException {
        Parent pane =FXMLLoader.load(getClass().getResource("../fxml/userTestView.fxml"));
        userMainPane.setCenter(pane);
    }

    public void userDashHome(ActionEvent event) {

    }

    public void userDashPackge(ActionEvent event) throws IOException {
        Parent pane =FXMLLoader.load(getClass().getResource("../fxml/userPackgeView.fxml"));
        userMainPane.setCenter(pane);
    }
}
