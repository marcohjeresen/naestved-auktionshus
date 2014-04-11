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
public class StoreHandler {

    private ProductGroup productGroup;
    private Product product;
    private ArrayList<ProductGroup> productGroupList;
    private ArrayList<Product> productsList;

    private TicketType ticketType;
    private ArrayList<TicketType> ticketTypesList;

    private EventType eventType;
    private ArrayList<EventType> eventTypesList;

    private Employee employee;
    private ArrayList<Employee> employeesList;

    public StoreHandler() throws SQLException {
        productGroupList = new ArrayList<>();
        productsList = new ArrayList<>();
        ticketTypesList = new ArrayList<>();
        eventTypesList = new ArrayList<>();
        employeesList = new ArrayList<>();
        getProductData();
        getTicketData();
        getEventData();
        getEmployeeData();

    }

    public void getProductData() throws SQLException {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM productgroup");
            while (rs.next()) {
                ProductGroup productGroup = new ProductGroup(rs.getInt("productgroup_id"), rs.getString("productgroup_type"));
                productGroupList.add(productGroup);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rse = db.getResult("SELECT * FROM product");
            while (rse.next()) {
                for (ProductGroup group : productGroupList) {
                    if (group.getGroupId() == rse.getInt("product_groupid")) {
                        Product pr = new Product(rse.getInt("product_numberid"), rse.getString("product_name"), group, rse.getString("product_supplier"),
                                rse.getDouble("product_buyprice"), rse.getDouble("product_saleprice_dk"), rse.getDouble("product_saleprice_euro"),
                                rse.getDouble("product_discount"), rse.getInt("product_quantities"));
                        productsList.add(pr);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close();
    }

    public void getTicketData() throws SQLException  {

        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM tickettype");
            while (rs.next()) {
                TicketType ticketType = new TicketType(rs.getInt("tickettype_id"), rs.getString("tickettype_type"), rs.getDouble("tickettype_pricedk"), rs.getDouble("tickettype_priceeuro"));
                ticketTypesList.add(ticketType);
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEventData() throws SQLException  {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM eventtype");
            while (rs.next()) {
                EventType eventType = new EventType(rs.getInt("eventtype_id"), rs.getString("eventtype_type"), rs.getInt("eventtype_pricedk"),
                        rs.getInt("eventtype_priceeuro"), rs.getTime("eventtype_time"));
                eventTypesList.add(eventType);
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getEmployeeData() throws SQLException  {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM employee");
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("employee_cpr"), rs.getString("employee_name"), rs.getString("employee_adresse"),
                        rs.getInt("employee_postzip"), rs.getString("employee_city"), rs.getString("employee_username"), rs.getInt("employee_password"));
                employeesList.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rse = db.getResult("SELECT * FROM employeephone");
            while (rse.next()) {
                for (Employee employee : employeesList) {
                    if (employee.getCpr() == rse.getInt("employeephone_cpr")) {
                        employee.setPhoneList(rse.getInt("employeephone_phone"));
                    }
                }
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<ProductGroup> getProductGroupList() {
        return productGroupList;
    }

    public void setProductGroupList(ProductGroup productGroup1) {
        productGroupList.add(productGroup1);
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(Product products1) {
        productsList.add(products1);
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public ArrayList<TicketType> getTicketTypesList() {
        return ticketTypesList;
    }

    public void setTicketTypesList(TicketType ticketType1) {
        ticketTypesList.add(ticketType1);
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public ArrayList<EventType> getEventTypesList() {
        return eventTypesList;
    }

    public void setEventTypesList(EventType eventTypes1) {
        eventTypesList.add(eventTypes1);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(Employee employees1) {
        employeesList.add(employees1);
    }
    
//    public void setViewGroupList(String type){
//        switch (type) {
//            case "Product":
//                for (Product product : productsList) {
//                    if (product.getGroupNumber().getGroupType().equals(type)) {
//                        
//                    }
//                }
//                break;
//            case "Event":
//                break;
//            case "Ticket":
//                break;
//            default:
//                throw new AssertionError();
//        }
//    public void setSpecProductList(ProductGroup group) {
//        specList.removeAll(specList);
//        
//        for (Product product : productList) {
//            if (product.getGroupNumber() == group) {
//                specList.add(product);
//            }
//        }
//        listners.notifyListeners("Update view");
//    }
//}
    
    

}
