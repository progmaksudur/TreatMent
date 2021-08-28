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
import sample.conostructor.AdminTest;
import sample.DatabaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminTestViewController implements Initializable {
    @FXML
    private TextField searchTestTextField;
    @FXML
    private TableView<AdminTest> alltest_tableview;
    @FXML
    private TableColumn<AdminTest,String> test_name_col;
    @FXML
    private TableColumn<AdminTest,String>test_place_col;
    @FXML
    private TableColumn<AdminTest,String>test_type_col;
    @FXML
    private TableColumn<AdminTest,String>test_requarment_col;
    @FXML
    private TableColumn<AdminTest,String>test_time_col;
    @FXML
    private TableColumn<AdminTest,String>test_day_col;
    @FXML
    private TableColumn<AdminTest,String>test_rate_col;

    ObservableList<AdminTest> test_info= FXCollections.observableArrayList();
    @FXML
    private void search(KeyEvent keyEvent){
        FilteredList<AdminTest> filteredList=new FilteredList<>(test_info, p->true);
        searchTestTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
                String texttyped=newvalue.toString();
                if(pers.getTest_name().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getTest_place().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getTest_type().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getTest_requarment().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getTest_time().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getTest_day().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                if(pers.getTest_rate().toString().indexOf(texttyped)!=-1){
                    return true;
                }
                return false;
            });

            SortedList<AdminTest> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(alltest_tableview.comparatorProperty());
            alltest_tableview.setItems(sortedList);
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Connection connectDB = databaseConnection.getConnection();
            String quary="SELECT test_name,test_place,test_type,test_requarment,test_time,test_day,test_rate from test_information where test_hospital_name='" + AdminDashboardController.hospital_for_this_user.toString()+"'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                AdminTest adminTest=new AdminTest();

                adminTest.setTest_name(mainTable.getString("test_name"));
                adminTest.setTest_place(mainTable.getString("test_place"));
                adminTest.setTest_type(mainTable.getString("test_type"));
                adminTest.setTest_requarment(mainTable.getString("test_requarment"));
                adminTest.setTest_time(mainTable.getString("test_time"));
                adminTest.setTest_day(mainTable.getString("test_day"));
                adminTest.setTest_rate(mainTable.getString("test_rate"));
                test_info.addAll(adminTest);
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        test_name_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_name"));
        test_place_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_place"));
        test_type_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_type"));
        test_requarment_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_requarment"));
        test_time_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_time"));
        test_day_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_day"));
        test_rate_col.setCellValueFactory(new PropertyValueFactory<AdminTest,String>("test_rate"));

        alltest_tableview.setItems(test_info);


    }
}
