package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DatabaseConnection;
import sample.conostructor.IteamCartList;
import sample.conostructor.Packge;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EstimatedCostController implements Initializable {
   @FXML
   private TableView costTable;
   @FXML
   private TableColumn<IteamCartList,String> iteam_name_col;
   @FXML
   private TableColumn<IteamCartList,String> iteam_details_col;
   @FXML
   private TableColumn<IteamCartList,String> iteam_include_col;
   @FXML
   private TableColumn<IteamCartList,String> iteam_cost_col;
   @FXML
   private ComboBox hospital_name_comboBox;
   @FXML
   private ComboBox packge_name_comboBox;
   @FXML
   private ComboBox test_name_comboBox;
   @FXML
   private ChoiceBox accomodetion_name_choicebox;
   @FXML
   private TextField total_day_textField;
   @FXML
   private TextField total_cost_view_textField;







   private String hospitalselectedname="";
   private String packgeselected="";
   private String testselected="";

   ObservableList<String> hospital_name = FXCollections.observableArrayList();
   ObservableList<String> accomodetion=FXCollections.observableArrayList("ICU","CCU","AC Cabin","None AC Single Cabin","None Ac Double Cabin","Local Bed","Not Use");
   ObservableList<IteamCartList> cost_info=FXCollections.observableArrayList();
   ObservableList<String> packgeList=FXCollections.observableArrayList();
   ObservableList<String> testlistwiew=FXCollections.observableArrayList();


   public void calculateOnClick(ActionEvent event) {
       ObservableList<Integer> cost =FXCollections.observableArrayList();
       int totalCost=0;
        for(int i=0;i<costTable.getItems().size();i++){
           cost.addAll(Integer.parseInt(iteam_cost_col.getCellData(i)));
       }
        for(int i=0;i<cost.size();i++){
            totalCost+=cost.get(i);
        }
       total_cost_view_textField.setText(String.valueOf(totalCost));
   }


    public void packgeview(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = null;
        try {
            connectDB = databaseConnection.getConnection();
            String quary="SELECT packge_name FROM package_information where packge_for_hospital='"+hospitalselectedname+"'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                packgeList.addAll(mainTable.getString("packge_name"));
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        packge_name_comboBox.setItems(packgeList);
    }
    public void testlist(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = null;
        try {
            connectDB = databaseConnection.getConnection();
            String quary="SELECT test_name FROM test_information where test_hospital_name='"+hospitalselectedname+"'";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                testlistwiew.addAll(mainTable.getString("test_name"));
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        test_name_comboBox.setItems(testlistwiew);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       accomodetion_name_choicebox.setItems(accomodetion);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB = null;
        try {
            connectDB = databaseConnection.getConnection();
            String quary="SELECT hospital_name FROM hospital_information";
            Statement statement=connectDB.createStatement();
            ResultSet mainTable=statement.executeQuery(quary);
            while (mainTable.next()){
                hospital_name.addAll(mainTable.getString("hospital_name"));
            }
            connectDB.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        hospital_name_comboBox.setItems(hospital_name);

    }

    public void packgeOnClick(ActionEvent event) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB =databaseConnection.getConnection();
        String quary="SELECT packge_name,packge_detail,packge_include,packge_price FROM package_information where packge_for_hospital='"+hospitalselectedname+"' AND packge_name='"+packgeselected+"'";
        Statement statement=connectDB.createStatement();
        ResultSet mainTable=statement.executeQuery(quary);
        while (mainTable.next()){
            IteamCartList iteamCartList=new IteamCartList();
            iteamCartList.setIteam_name(mainTable.getString("packge_name"));
            iteamCartList.setIteam_details(mainTable.getString("packge_detail"));
            iteamCartList.setIteam_include(mainTable.getString("packge_include"));
            iteamCartList.setIteam_cost(mainTable.getString("packge_price"));
            cost_info.addAll(iteamCartList);
        }
        connectDB.close();
        iteam_name_col.setCellValueFactory(new PropertyValueFactory<>("iteam_name"));
        iteam_details_col.setCellValueFactory(new PropertyValueFactory<>("iteam_details"));
        iteam_include_col.setCellValueFactory(new PropertyValueFactory<>("iteam_include"));
        iteam_cost_col.setCellValueFactory(new PropertyValueFactory<>("iteam_cost"));



        costTable.setItems(cost_info);

    }

    public void testOnClick(ActionEvent event) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB =databaseConnection.getConnection();
        String quary="SELECT test_name,test_type,test_requarment,test_rate from test_information where test_hospital_name='"+hospitalselectedname+"' AND test_name='"+testselected+"'";
        Statement statement=connectDB.createStatement();
        ResultSet mainTable=statement.executeQuery(quary);
        while (mainTable.next()){
            IteamCartList iteamCartList=new IteamCartList();
            iteamCartList.setIteam_name(mainTable.getString("test_name"));
            iteamCartList.setIteam_details(mainTable.getString("test_type"));
            iteamCartList.setIteam_include(mainTable.getString("test_requarment"));
            iteamCartList.setIteam_cost(mainTable.getString("test_rate"));
            cost_info.addAll(iteamCartList);
        }
        connectDB.close();
        iteam_name_col.setCellValueFactory(new PropertyValueFactory<>("iteam_name"));
        iteam_details_col.setCellValueFactory(new PropertyValueFactory<>("iteam_details"));
        iteam_include_col.setCellValueFactory(new PropertyValueFactory<>("iteam_include"));
        iteam_cost_col.setCellValueFactory(new PropertyValueFactory<>("iteam_cost"));

        costTable.setItems(cost_info);


    }

    public void accomodetionOnclick(ActionEvent event) throws IOException, SQLException {
        String accomodetion_name=accomodetion_name_choicebox.getSelectionModel().getSelectedItem().toString();
        String accomodetion_Time=total_day_textField.getText();
        Integer accomodetionCost=0;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectDB =databaseConnection.getConnection();
        String quary="SELECT icu_rate,ccu_rate,acCabin_rate,noneAcCabinDouble_rate,noneAcCabineSingle_rate,localBed_rate FROM accomodetion_information where accomodetion_hospital='"+hospitalselectedname+ "'";
        Statement statement=connectDB.createStatement();
        ResultSet mainTable=statement.executeQuery(quary);
        if(total_day_textField.getText().isEmpty()) return;
            IteamCartList iteamCartList = new IteamCartList();
            if (accomodetion_name.equals("Not Use")) {
                return;
            }
            iteamCartList.setIteam_name(accomodetion_name);
            iteamCartList.setIteam_details(total_day_textField.getText().toString() +" days staying");
            iteamCartList.setIteam_include("All facility without medicine");
            String accomodetiontype ="";
            while (mainTable.next()) {
                if (accomodetion_name.equals("ICU")) {
                    accomodetiontype= mainTable.getString("icu_rate");
                    System.out.println(accomodetiontype);
                } else if (accomodetion_name.equals("CCU")) {
                    accomodetiontype= mainTable.getString("ccu_rate");
                } else if (accomodetion_name.equals("AC Cabin")) {
                    accomodetiontype= mainTable.getString("acCabin_rate");
                } else if (accomodetion_name.equals("None Ac Double Cabin")) {
                    accomodetiontype= mainTable.getString("noneAcCabineSingle_rate");
                } else if (accomodetion_name.equals("None AC Single Cabin")) {
                    accomodetiontype= mainTable.getString("noneAcCabinDouble_rate");
                } else if (accomodetion_name.equals("Local Bed")) {
                    accomodetiontype= mainTable.getString("localBed_rate");
                }

            }
            connectDB.close();
            accomodetionCost= Integer.parseInt(accomodetiontype)*Integer.parseInt(accomodetion_Time);
             iteamCartList.setIteam_cost(accomodetionCost.toString());
            cost_info.addAll(iteamCartList);

            iteam_name_col.setCellValueFactory(new PropertyValueFactory<>("iteam_name"));
            iteam_details_col.setCellValueFactory(new PropertyValueFactory<>("iteam_details"));
            iteam_include_col.setCellValueFactory(new PropertyValueFactory<>("iteam_include"));
            iteam_cost_col.setCellValueFactory(new PropertyValueFactory<>("iteam_cost"));

            costTable.setItems(cost_info);


    }

    public void removeOnClick(ActionEvent event) {
       if(costTable.getSelectionModel().isEmpty())return;

        costTable.getItems().removeAll(costTable.getSelectionModel().getSelectedItem());
        total_cost_view_textField.clear();

    }

    public void hospitalCombo(ActionEvent event) {
        if(hospital_name_comboBox.getSelectionModel().isEmpty()) return;
        hospitalselectedname = hospital_name_comboBox.getSelectionModel().getSelectedItem().toString();
        packgeview();
        testlist();
    }

    public void packgeSelected(ActionEvent event) {
       packgeselected=packge_name_comboBox.getSelectionModel().getSelectedItem().toString();
    }

    public void testSelect(ActionEvent event) {
       testselected=test_name_comboBox.getSelectionModel().getSelectedItem().toString();
    }
}
