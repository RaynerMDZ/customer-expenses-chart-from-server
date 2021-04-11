package edu.citytech.cst.s23253396.customerChart.controllers;

import com.google.gson.Gson;
import edu.citytech.cst.s23253396.customerChart.models.CustomerPurchase;
import edu.citytech.cst.s23253396.customerChart.services.CustomerPurchaseService;
import edu.citytech.cst.s23253396.customerChart.services.implementations.CustomerPurchaseServiceImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerPurchaseController implements Initializable {

    private final CustomerPurchaseService customerPurchaseService = new CustomerPurchaseServiceImpl();

    @FXML
    private TableView<CustomerPurchase> tvCustomerPurchases;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<CustomerPurchase> customerPurchases = this.tvCustomerPurchases.getItems();

        final Gson gson = new Gson();

        for (Object row : this.customerPurchaseService.getAllCustomerPurchases()) {
            customerPurchases.add(gson.fromJson(row.toString(), CustomerPurchase.class));
        }
    }
}
