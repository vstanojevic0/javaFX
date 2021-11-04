package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    //Table
    @FXML
    private TableView<Customer> tableView;

    //Columns
    @FXML
    private TableColumn<Customer , String> FNameColumn;

    @FXML
    private TableColumn<Customer , String> LNameColumn;

    @FXML
    private TableColumn<Customer , String> AddressColumn;

    @FXML
    private TableColumn<Customer , String> speedMBsColumn;

    @FXML
    private TableColumn<Customer , String> BandwidthColumn;

    @FXML
    private TableColumn<Customer , String> DurationColumn;

    //Inputs
    @FXML
    private TextField firstNameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField addressInput;

    @FXML
    private ToggleGroup speedMbsInput;

    @FXML
    private ToggleGroup bandwidthInput;

    @FXML
    private ToggleGroup durationInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        FNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        LNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        speedMBsColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("speedMBs"));
        BandwidthColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("bandwidth"));
        DurationColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("duration"));
    }

    @FXML
    void submit(ActionEvent event){
        ToggleButton selectedSpeed = (ToggleButton) speedMbsInput.getSelectedToggle();
        ToggleButton selectedBandwidth = (ToggleButton)  bandwidthInput.getSelectedToggle();
        ToggleButton selectedDuration = (ToggleButton)  durationInput.getSelectedToggle();
        Customer customer = new Customer(firstNameInput.getText(), lastNameInput.getText(), addressInput.getText()
                ,selectedSpeed.getText(), selectedBandwidth.getText(),selectedDuration.getText());
        ObservableList<Customer> customers = tableView.getItems();
        customers.add(customer);
        tableView.setItems(customers);
    }

    @FXML
    void removeCustomer(ActionEvent event){
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    @FXML
    void clearForm (ActionEvent event){
        tableView.getItems().clear();
    }

}
