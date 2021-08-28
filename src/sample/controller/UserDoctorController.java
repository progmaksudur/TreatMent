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
import sample.DatabaseConnection;
import sample.conostructor.ShowDoctor;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UserDoctorController implements Initializable {
            @FXML
            private TableView userDoctorViewList;
            @FXML
            private TextField searchSpecialistTextField;
            @FXML
            private TextField searchHospitalTextField;
            @FXML
            private TextField searchNameTextField;
            @FXML
            private TableColumn<ShowDoctor,String> doctor_name_col;
            @FXML
            private TableColumn <ShowDoctor,String> doctor_specialist_col;
            @FXML
            private TableColumn <ShowDoctor,String> doctor_degree_col;
            @FXML
            private TableColumn <ShowDoctor,String> doctor_visit_day_col;
            @FXML
            private TableColumn <ShowDoctor,String> doctor_visit_time_col;
            @FXML
            private TableColumn <ShowDoctor,String> doctor_chamber_col;
            @FXML
            private TableColumn <ShowDoctor,String> doctor_visit_fees_col;
            @FXML
            private TableColumn<ShowDoctor,String> doctor_hospital_name_col;

            ObservableList<ShowDoctor> doctorView_info= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Connection connectDB = databaseConnection.getConnection();
            String quary="SELECT doctor_name,doctor_specialist,doctor_degree,doctor_visit_day,doctor_visit_time,doctor_chamber,doctor_visit_fees,doctor_Hospital_Name FROM doctor_information";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                ShowDoctor showDoctor=new ShowDoctor();
                showDoctor.setDoctor_name(mainTable.getString("doctor_name"));
                showDoctor.setDoctor_specialist(mainTable.getString("doctor_specialist"));
                showDoctor.setDoctor_degree(mainTable.getString("doctor_degree"));
                showDoctor.setDoctor_visit_day(mainTable.getString("doctor_visit_day"));
                showDoctor.setDoctor_visit_time(mainTable.getString("doctor_visit_time"));
                showDoctor.setDoctor_chamber(mainTable.getString("doctor_chamber"));
                showDoctor.setDoctor_visit_fees(mainTable.getString("doctor_visit_fees"));
                showDoctor.setDoctor_Hospital_Name(mainTable.getString("doctor_Hospital_Name"));
                doctorView_info.addAll(showDoctor);
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        doctor_name_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_name"));
        doctor_specialist_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_specialist"));
        doctor_degree_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_degree"));
        doctor_visit_day_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_visit_day"));
        doctor_visit_time_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_visit_time"));
        doctor_chamber_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_chamber"));
        doctor_visit_fees_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_visit_fees"));
        doctor_hospital_name_col.setCellValueFactory(new PropertyValueFactory<ShowDoctor,String>("doctor_Hospital_Name"));
        userDoctorViewList.setItems(doctorView_info);


    }
    public void searchName(KeyEvent keyEvent) {
        FilteredList<ShowDoctor> filteredList=new FilteredList<>(doctorView_info, p->true);
        searchNameTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
                String texttyped=newvalue.toString();
                if(pers.getDoctor_name().toString().indexOf(texttyped)!=-1){
                    return true;
                }

                return false;
            });

            SortedList<ShowDoctor> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(userDoctorViewList.comparatorProperty());
            userDoctorViewList.setItems(sortedList);
        });


    }
    public void searchHospital(KeyEvent keyEvent) {
        FilteredList<ShowDoctor> filteredList=new FilteredList<>(doctorView_info, p->true);
        searchHospitalTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
                String texttyped=newvalue.toString();
                if(pers.getDoctor_Hospital_Name().toString().indexOf(texttyped)!=-1){
                    return true;
                }

                return false;
            });

            SortedList<ShowDoctor> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(userDoctorViewList.comparatorProperty());
            userDoctorViewList.setItems(sortedList);
        });

    }
    public void searchSpecialist(KeyEvent keyEvent) {
        FilteredList<ShowDoctor> filteredList=new FilteredList<>(doctorView_info, p->true);
        searchSpecialistTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
                String texttyped=newvalue.toString();
                if(pers.getDoctor_specialist().toString().indexOf(texttyped)!=-1){
                    return true;
                }

                return false;
            });

            SortedList<ShowDoctor> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(userDoctorViewList.comparatorProperty());
            userDoctorViewList.setItems(sortedList);
        });


    }
}
