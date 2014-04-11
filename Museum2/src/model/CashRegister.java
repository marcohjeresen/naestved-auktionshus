/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author markh_000
 */
public class CashRegister {
    private String date;
    private double amountDk;
    private double amountEuro;
    private Employee employee;

    public CashRegister(String date, double amountDk, double amountEuro, Employee employee) {
        this.date = date;
        this.amountDk = amountDk;
        this.amountEuro = amountEuro;
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmountDk() {
        return amountDk;
    }

    public void setAmountDk(double amountDk) {
        this.amountDk = amountDk;
    }

    public double getAmountEuro() {
        return amountEuro;
    }

    public void setAmountEuro(double amountEuro) {
        this.amountEuro = amountEuro;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "date: " + date + " amountDk: " + amountDk + " amountEuro: " + amountEuro + " employee: " + employee.getName();
    }
    
}
