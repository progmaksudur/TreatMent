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
import sample.conostructor.Packge;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminPackgeViewController implements Initializable {
    @FXML
    private TextField searchTestTextField;
    @FXML
    private TableView<Packge> allPackge_tableview;
    @FXML
    private TableColumn<Packge,String> packge_name_col;
    @FXML
    private TableColumn<Packge,String>packge_detail_col;
    @FXML
    private TableColumn<Packge,String>packge_include_col;
    @FXML
    private TableColumn<Packge,String>packge_price_col;

    ObservableList<Packge> packge_info= FXCollections.observableArrayList();


    public void search(KeyEvent keyEvent) {
        FilteredList<Packge> filteredList=new FilteredList<>(packge_info, p->true);
        searchTestTextField.textProperty().addListener((observable,oldvalue,newvalue)->{
            filteredList.setPredicate(pers->{
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
                String texttyped=newvalue.toString();
                if(pers.getPackge_name().toString().indexOf(texttyped)!=-1){
                    return true;
                }


                return false;
            });

            SortedList<Packge> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(allPackge_tableview.comparatorProperty());
            allPackge_tableview.setItems(sortedList);
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            Connection connectDB = databaseConnection.getConnection();
            String quary = "SELECT packge_name,packge_detail,packge_include,packge_price from package_information where packge_for_hospital='" + AdminDashboardController.hospital_for_this_user.toString() + "'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                Packge packge = new Packge();
                packge.setPackge_name(mainTable.getString("packge_name"));
                packge.setPackge_detail(mainTable.getString("packge_detail"));
                packge.setPackge_include(mainTable.getString("packge_include"));
                packge.setPackge_price(mainTable.getString("packge_price"));
                packge_info.addAll(packge);
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        packge_name_col.setCellValueFactory(new PropertyValueFactory<Packge, String>("packge_name"));
        packge_detail_col.setCellValueFactory(new PropertyValueFactory<Packge, String>("packge_detail"));
        packge_include_col.setCellValueFactory(new PropertyValueFactory<Packge, String>("packge_include"));
        packge_price_col.setCellValueFactory(new PropertyValueFactory<Packge, String>("packge_price"));
        allPackge_tableview.setItems(packge_info);

    }
}
