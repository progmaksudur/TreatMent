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
import sample.conostructor.UserHospitalView;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UserHospitalController  implements Initializable {
    @FXML
    private TableView userHospitalList;
    @FXML
    private TextField searchHospitalTextField;
    @FXML
    private TableColumn <UserHospitalView,String> hospital_name_col;
    @FXML
    private TableColumn <UserHospitalView,String> hospital_address_col;
    @FXML
    private TableColumn <UserHospitalView,String> hospital_numbers_col;
    @FXML
    private TableColumn <UserHospitalView,String> hospital_website_col;
    @FXML
    private TableColumn <UserHospitalView,String> icu_rate_col;
    @FXML
    private TableColumn <UserHospitalView,String> ccu_rate_col;
    @FXML
    private TableColumn <UserHospitalView,String> acCabin_rate_col;
    @FXML
    private TableColumn <UserHospitalView,String> noneAcCabinDouble_rate_col;
    @FXML
    private TableColumn <UserHospitalView,String> noneAcCabineSingle_rate_col;
    @FXML
    private TableColumn <UserHospitalView,String> localBed_rate_col;
    @FXML
    private TableColumn <UserHospitalView,String> hospital_type_col;


    ObservableList<UserHospitalView> hospitalView_info= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Connection connectDB = databaseConnection.getConnection();
            String quary="SELECT hospital_name,hospital_address,hospital_numbers,hospital_website,icu_rate,ccu_rate,acCabin_rate, noneAcCabinDouble_rate,noneAcCabineSingle_rate,localBed_rate,hospital_type FROM \n" +
                    "hospital_information RIGHT JOIN accomodetion_information ON\n" +
                    "hospital_information.hospital_name=accomodetion_information.accomodetion_hospital";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                UserHospitalView userHospitalView=new UserHospitalView();

                userHospitalView.setHospital_name(mainTable.getString("hospital_name"));
                userHospitalView.setHospital_address(mainTable.getString("hospital_address"));
                userHospitalView.setHospital_numbers(mainTable.getString("hospital_numbers"));
                userHospitalView.setHospital_website(mainTable.getString("hospital_website"));
                userHospitalView.setIcu_rate(mainTable.getString("icu_rate"));
                userHospitalView.setCcu_rate(mainTable.getString("ccu_rate"));
                userHospitalView.setAcCabin_rate(mainTable.getString("acCabin_rate"));
                userHospitalView.setNoneAcCabinDouble_rate(mainTable.getString("noneAcCabinDouble_rate"));
                userHospitalView.setNoneAcCabineSingle_rate(mainTable.getString("noneAcCabineSingle_rate"));
                userHospitalView.setLocalBed_rate(mainTable.getString("localBed_rate"));
                userHospitalView.setHospital_type(mainTable.getString("hospital_type"));
                hospitalView_info.addAll(userHospitalView);
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        hospital_name_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("hospital_name"));
        hospital_address_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("hospital_address"));
        hospital_numbers_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("hospital_numbers"));
        hospital_website_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("hospital_website"));
        icu_rate_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("icu_rate"));
        ccu_rate_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("ccu_rate"));
        acCabin_rate_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("acCabin_rate"));
        noneAcCabinDouble_rate_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("noneAcCabineSingle_rate"));
        noneAcCabineSingle_rate_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("noneAcCabineSingle_rate"));
        localBed_rate_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("localBed_rate"));
        hospital_type_col.setCellValueFactory(new PropertyValueFactory<UserHospitalView,String>("hospital_type"));
        userHospitalList.setItems(hospitalView_info);

    }

    public void search(KeyEvent keyEvent) {
        FilteredList<UserHospitalView> filteredList=new FilteredList<>(hospitalView_info, p->true);
        searchHospitalTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
                String texttyped=newvalue.toString();
                if(pers.getHospital_name().toString().indexOf(texttyped)!=-1){
                    return true;
                }

                return false;
            });

            SortedList<UserHospitalView> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(userHospitalList.comparatorProperty());
            userHospitalList.setItems(sortedList);
        });
    }
}
