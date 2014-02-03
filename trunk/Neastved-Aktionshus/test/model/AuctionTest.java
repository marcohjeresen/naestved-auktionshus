/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author markh_000
 */
public class AuctionTest {

    private Auction ac;
    private User user;

    public AuctionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 02, 20, 16, 30);
        user = new User("Test3", "parkvej", 23232323);
        Furniture f = new Furniture("jern", "1*2", "møbel", "ikke særlig pæn", 2000, "");
        ac = new Auction(f, user, 1000, cal.getTime());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLatestBid method, of class Auction.
     */
    @Test
    public void testGetLatestBid() {
        System.out.println("getLatestBid");
        Auction instance = ac;
        double expResult = 1000.0;
        double result = instance.getLatestBid();
        assertEquals("get.latesbid retunere ikke korrekt", expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetLatestBid1() {

        user = new User("palle", "birkevej", 45454545);
        ArrayList<Bid> ab = new ArrayList<>();
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1500);
        System.out.println("getLatestBid");
        ab.add(bid);
        ac.setBidingHistory(ab);
        Auction instance = ac;
        double expResult = 1500.0;
        double result = instance.getLatestBid();
        assertEquals("get.latesbid retunere ikke korrekt", expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setLatesBid method, of class Auction.
     */
    @Test
    public void testSetLatesBid() throws Exception {
        System.out.println("setLatesBid");
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1700);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("sælger må ikke kunne byde på egen vare");

        } catch (Exception ex) {
        }
    }

    @Test
    public void testSetLatesBid1() throws Exception {
        System.out.println("setLatesBid");
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 02, 21, 11, 00);
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, cal.getTime(), 1700);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("man må ikke byde på auctioner der er slut");

        } catch (Exception ex) {
        }
    }

    @Test
    public void testSetLatesBid2() throws Exception {
        System.out.println("setLatesBid");
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1700);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);

        } catch (Exception ex) {
            fail("Buddet skal være højere end startbuddet.");
        }
    }

    @Test
    public void testSetLatesBid3() throws Exception {
        System.out.println("setLatesBid");
        user = new User("palle", "birkevej", 45454545);
        ArrayList<Bid> ab = new ArrayList<>();
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1500);
        ab.add(bid);
        user = new User("puol", "røvvej", 25252525);
        Bid bid1 = new Bid(user, Calendar.getInstance().getTime(), 1700);
        ac.setBidingHistory(ab);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid1);

        } catch (Exception ex) {
            fail("Buddet skal være højere end startbuddet.");
        }
    }

    @Test
    public void testSetLatesBid4() throws Exception {
        System.out.println("setLatesBid");
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), -170000);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("Buddet skal være højere end startbuddet.");

        } catch (Exception ex) {

        }
    }
}
