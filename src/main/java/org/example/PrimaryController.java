package org.example;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.utill.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PrimaryController implements Initializable {

    //Table
    @FXML
    private TableView<Customer> tableView;

    //Columns
    @FXML
    private TableColumn<Customer , Integer> IDColumn;

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

    //Hibernate
    Session session;
    Transaction tx = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        IDColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        FNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
        LNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        speedMBsColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("speedMBs"));
        BandwidthColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("bandwidth"));
        DurationColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("duration"));
        tableView.setItems(getCustomers());

    }


    public ObservableList<Customer> getCustomers(){

        ObservableList<Customer> customerList = FXCollections.observableArrayList();

        session = HibernateUtil.createSessionFactory().openSession();

        List<Customer> cList = session.createCriteria(Customer.class).list();

        for (Customer customer : cList){
            customerList.add(customer);
        }
        return customerList;

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

        try{
            session = HibernateUtil.createSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }finally {
            HibernateUtil.close();
        }


    }

    @FXML
    void removeCustomer(ActionEvent event){
        Customer customer = tableView.getSelectionModel().getSelectedItem();
        System.out.println(customer);

        try{
            session = HibernateUtil.createSessionFactory().openSession();
            tx = session.beginTransaction();

            session.delete(customer);

            tx.commit();


        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        }finally {
            HibernateUtil.close();
        }
        tableView.getItems().remove(customer);
    }

    @FXML
    void clearForm (ActionEvent event){
        tableView.getItems().clear();
        try{
            session = HibernateUtil.createSessionFactory().openSession();
            tx = session.beginTransaction();
            session.createSQLQuery("truncate table customer").executeUpdate();
            tx.commit();

        }catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            HibernateUtil.close();
        }
    }
}

