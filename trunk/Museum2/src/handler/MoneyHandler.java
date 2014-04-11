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
public class MoneyHandler {
    private CashRegister cashRegister;
    private ArrayList<CashRegister> cashRegistersList;
    private StoreHandler storeHandler;

    public MoneyHandler(StoreHandler storeHandler) throws SQLException {
        this.storeHandler = storeHandler;
        cashRegistersList = new ArrayList<>();
        getCashDatabase();
    }
    
    public void getCashDatabase()throws SQLException {
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = db.getResult("SELECT * FROM cashregistercontent");
            while (rs.next()) {
                    for (Employee employeeList : storeHandler.getEmployeesList()) {
                    if (employeeList.getCpr() == rs.getInt("starting_employee_cpr")) {
                        CashRegister cashRegister = new CashRegister(rs.getString("starting_date"), rs.getDouble("starting_amount_dk"), rs.getDouble("starting_amount_euro"), employeeList );
                        cashRegistersList.add(cashRegister);
                    }
                }
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(Museum2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public ArrayList<CashRegister> getCashRegistersList() {
        return cashRegistersList;
    }

    public void setCashRegistersList(CashRegister cashRegisters) {
        cashRegistersList.add(cashRegisters);
    }
   
    
}
