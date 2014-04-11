/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import db.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import museum2.Museum2;

/**
 *
 * @author markh_000
 */
public class SaleHandler {

    private PaymentType paymentType;
    private ArrayList<PaymentType> paymentTypesList;

    private Sale sale;
    private ArrayList<Sale> salesList;
    private ReturnProduct returnProduct;
    private ArrayList<ReturnProduct> returnProductsList;

    private InvoiceStatus invoiceStatus;
    private ArrayList<InvoiceStatus> invoiceStatusesList;
    private Invoice invoice;
    private ArrayList<Invoice> invoicesList;
    private Customer customer;
    private ArrayList<Customer> customersList;

    private ArrayList<ProductLine> productLinesList;
    private ArrayList<EventLine> eventLinesList;
    private ArrayList<TicketLine> ticketLinesList;

    private StoreHandler storeHandler;
    private MoneyHandler moneyHandler;

    public SaleHandler(StoreHandler storeHandler1, MoneyHandler moneyHandler1) throws SQLException {
        this.storeHandler = storeHandler1;
        this.moneyHandler = moneyHandler1;
        paymentTypesList = new ArrayList<>();
        salesList = new ArrayList<>();
        returnProductsList = new ArrayList<>();
        invoiceStatusesList = new ArrayList<>();
        invoicesList = new ArrayList<>();
        customersList = new ArrayList<>();
        productLinesList = new ArrayList<>();
        eventLinesList = new ArrayList<>();
        ticketLinesList = new ArrayList<>();
        getPaymentData();
        getSaleData();
        getInvoiceData();
        getProductLineData();
        getEventLineData();
        getTicketLineData();
        
    }

    public void getPaymentData() throws SQLException {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM paymenttype");
            while (rs.next()) {
                PaymentType paymentType = new PaymentType(rs.getInt("paymenttype_id"), rs.getString("paymenttype_type"), rs.getDouble("paymenttype_fee"));
                paymentTypesList.add(paymentType);
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSaleData() throws SQLException {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM sale");
            while (rs.next()) {

                for (PaymentType payment : paymentTypesList) {
                    if (payment.getId() == rs.getInt("sale_paymenttype_id")) {
                        for (Employee employee : storeHandler.getEmployeesList()) {
                            if (employee.getCpr() == rs.getInt("sale_employee_cpr")) {
                                Sale sale = new Sale(rs.getInt("sale_id"), payment, employee, rs.getString("sale_date"));
                                salesList.add(sale);
                            }
                        }
                    }
                }
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getInvoiceData() throws SQLException {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM invoicestatus");
            while (rs.next()) {
                InvoiceStatus invoiceStatus = new InvoiceStatus(rs.getInt("invoicestatus_id"), rs.getString("invoicestatus_type"));
                invoiceStatusesList.add(invoiceStatus);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rse = db.getResult("SELECT * FROM invoice");
            while (rse.next()) {
                for (Sale sale : salesList) {
                    if (sale.getId() == rse.getInt("invoice_sale_id")) {
                        for (InvoiceStatus invoiceStatus : invoiceStatusesList) {
                            if (invoiceStatus.getId() == rse.getInt("invoice_invoicestatus_id")) {
                                Invoice invoice = new Invoice(rse.getInt("invoice_id"), sale, rse.getString("invoice_date"), rse.getDouble("invoice_pricedk"),
                                        rse.getDouble("invoice_priceeuro"), invoiceStatus);
                                invoicesList.add(invoice);
                            }
                        }
                    }
                }
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getProductLineData() throws SQLException {
        DBConnection db = new DBConnection();
        try {
            ResultSet rse = db.getResult("SELECT * FROM productline");
            while (rse.next()) {
                for (Sale sale : salesList) {
                    if (sale.getId() == rse.getInt("productline_sale_id")) {

                        for (Product product : storeHandler.getProductsList()) {
                            if (product.getProductNumber() == rse.getInt("productline_product_id")) {
                                ProductLine productLine = new ProductLine(rse.getInt("productline_id"), sale, product, rse.getInt("productline_quantities"));

                                productLinesList.add(productLine);

                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        addProductLineToSale();
    }

    public void getTicketLineData() throws SQLException {

        DBConnection db = new DBConnection();
        try {
            ResultSet rse = db.getResult("SELECT * FROM ticketline");
            while (rse.next()) {
                for (Sale sale : salesList) {
                    if (sale.getId() == rse.getInt("ticketline_sale_id")) {

                        for (TicketType ticketType : storeHandler.getTicketTypesList()) {
                            if (ticketType.getId() == rse.getInt("ticketline_tickettype_id")) {

                                TicketLine ticketLine = new TicketLine(rse.getInt("ticketline_id"), sale, rse.getInt("ticketline_quantities"), rse.getString("ticketline_date"), ticketType);

                                ticketLinesList.add(ticketLine);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        addTicketLineToSale();
    }

    public void getEventLineData() throws SQLException {
        DBConnection db = new DBConnection();

        try {
            ResultSet rse = db.getResult("SELECT * FROM eventline");
            while (rse.next()) {
                for (EventType eventtype : storeHandler.getEventTypesList()) {
                    if (eventtype.getId() == rse.getInt("eventline_eventtype_id")) {
                        for (Sale sale : salesList) {
                            if (sale.getId() == rse.getInt("eventline_sale_id")) {

                                
                                    EventLine eventLine = new EventLine(rse.getInt("eventline_id"), eventtype, sale, rse.getInt("eventline_quantities"), rse.getString("eventline_date"), rse.getInt("eventline_customer_phone"), rse.getString("eventLine_place"));

                                    eventLinesList.add(eventLine);
                                

                            }
                        }

                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        addEventLineToSale();
    }
    public void addTicketLineToSale() {
        for (Sale sale : salesList) {
            for (TicketLine ticketLine : ticketLinesList) {
                if (sale == ticketLine.getSale()) {
                    sale.setTl(ticketLine);
                }
            }
        }
    }
    
    public void addEventLineToSale() {
        for (Sale sale : salesList) {
            for (EventLine eventLine : eventLinesList) {
                if (sale == eventLine.getSale()) {
                    sale.setEl(eventLine);
                }
            }
        }
    }
    
    public void addProductLineToSale() {
        for (Sale sale : salesList) {
            for (ProductLine productLine : productLinesList) {
                if (sale == productLine.getSale()) {
                    
                    sale.setPl(productLine);
                }
            }
        }
    }

    public ArrayList<PaymentType> getPaymentTypesList() {
        return paymentTypesList;
    }

    public void addToPaymentTypesList(PaymentType paymentTypes) {
        paymentTypesList.add(paymentTypes);
    }

    public ArrayList<Sale> getSalesList() {
        return salesList;
    }

    public void addToSalesList(Sale sale) {
        salesList.add(sale);
    }

    public ArrayList<ReturnProduct> getReturnProductsList() {
        return returnProductsList;
    }

    public void addToReturnProductsList(ReturnProduct returnProduct) {
        returnProductsList.add(returnProduct);
    }

    public ArrayList<InvoiceStatus> getInvoiceStatusesList() {
        return invoiceStatusesList;
    }

    public void addToInvoiceStatusesList(InvoiceStatus invoiceStatuses) {
        invoiceStatusesList.add(invoiceStatuses);
    }

    public ArrayList<Invoice> getInvoicesList() {
        return invoicesList;
    }

    public void addToInvoicesList(Invoice invoice) {
        invoicesList.add(invoice);
    }

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public void addToCustomersList(Customer customers) {
        customersList.add(customers);
    }

}
