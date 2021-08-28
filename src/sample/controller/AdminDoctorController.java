package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import sample.conostructor.AdminDoctor;
import sample.DatabaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class  AdminDoctorController implements Initializable {
    @FXML
    private TextField searchSpecialistTextField;
    @FXML
    private TableView<AdminDoctor> adminDoctorTable;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_name_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_email_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_phone_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_chamber_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_specialist_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_visit_time_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_visit_day_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_visit_fees_coloum;
    @FXML
    private TableColumn<AdminDoctor,String> doctor_degree_coloum;


    ObservableList<AdminDoctor> doctor_info=FXCollections.observableArrayList();
    @FXML
    private void searchSpecialist(KeyEvent keyEvent){
        FilteredList<AdminDoctor>filteredList=new FilteredList<>(doctor_info,p->true);
        searchSpecialistTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
            if(newvalue==null || newvalue.isEmpty()){
                return true;
            }
            String texttyped=newvalue.toString();
            if(pers.getDoctor_name().toString().indexOf(texttyped)!=-1){
                return true;
                }
                if(pers.getDoctor_email().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_phone().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_chamber().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_specialist().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_visit_time().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_visit_day().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_visit_fees().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getDoctor_degree().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                return false;
            });

            SortedList<AdminDoctor> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(adminDoctorTable.comparatorProperty());
            adminDoctorTable.setItems(sortedList);
        });

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Connection connectDB = databaseConnection.getConnection();
            String quary="SELECT doctor_name,doctor_email,doctor_phone,doctor_chamber,doctor_specialist,doctor_visit_time,doctor_visit_day,doctor_visit_fees,doctor_degree FROM doctor_information where doctor_Hospital_Name='" + AdminDashboardController.hospital_for_this_user.toString()+"'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                AdminDoctor adminDoctor=new AdminDoctor();
                adminDoctor.setDoctor_name(mainTable.getString("doctor_name"));
                adminDoctor.setDoctor_email(mainTable.getString("doctor_email"));
                adminDoctor.setDoctor_phone(mainTable.getString("doctor_phone"));
                adminDoctor.setDoctor_chamber(mainTable.getString("doctor_chamber"));
                adminDoctor.setDoctor_specialist(mainTable.getString("doctor_specialist"));
                adminDoctor.setDoctor_visit_time(mainTable.getString("doctor_visit_time"));
                adminDoctor.setDoctor_visit_day(mainTable.getString("doctor_visit_day"));
                adminDoctor.setDoctor_visit_fees(mainTable.getString("doctor_visit_fees"));
                adminDoctor.setDoctor_degree(mainTable.getString("doctor_degree"));
                doctor_info.addAll(adminDoctor);
                connectDB.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        doctor_name_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_name"));
        doctor_email_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_email"));
        doctor_phone_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_phone"));
        doctor_chamber_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_chamber"));
        doctor_specialist_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_specialist"));
        doctor_visit_time_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_visit_time"));
        doctor_visit_day_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_visit_day"));
        doctor_visit_fees_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_visit_fees"));
        doctor_degree_coloum.setCellValueFactory(new PropertyValueFactory<AdminDoctor,String>("doctor_degree"));
         adminDoctorTable.setItems(doctor_info);


    }
}
