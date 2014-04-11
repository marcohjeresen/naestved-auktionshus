/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package museum2;
import handler.*;
import model.*;
import java.sql.SQLException;
import view.MainView;
/**
 *
 * @author markh_000
 */
public class Museum2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       Listeners listeners = new Listeners();
       StoreHandler storeHandler = new StoreHandler();
       MoneyHandler moneyHandler = new MoneyHandler(storeHandler);
       SaleHandler saleHandler = new SaleHandler(storeHandler, moneyHandler);
       
       MainView mainView = new MainView(moneyHandler, saleHandler, storeHandler, listeners);
       mainView.setVisible(true);
    }
    
}
