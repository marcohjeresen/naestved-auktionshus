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
     * Tester at getLatestBid returnere startbuddet, når der ikke er afgivet
     * andre bud.
     */
    @Test
    public void testGetLatestBid() {
        System.out.println("getLatestBid");
        Auction instance = ac;
        double expResult = 1000.0;
        double result = instance.getLatestBid();
        assertEquals("get.latesbid retunere ikke korrekt", expResult, result, 0.0);
    }

    /**
     * Tester at getLatestBid returnere det seneste bud og ikke startbuddet, når
     * der er afgivet andre bud.
     */
    @Test
    public void testGetLatestBid1() {
        System.out.println("getLatestBid1");
        user = new User("palle", "birkevej", 45454545);
        ArrayList<Bid> ab = new ArrayList<>();
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1500);
        ab.add(bid);
        ac.setBidingHistory(ab);
        Auction instance = ac;
        double expResult = 1500.0;
        double result = instance.getLatestBid();
        assertEquals("get.latesbid retunere ikke korrekt", expResult, result, 0.0);
    }

    /**
     * Tester at sælgeren ikke kan byde på sin egen vare for at presse buddet op
     */
    @Test
    public void testSetLatesBid() {
        System.out.println("setLatesBid");
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1700);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("sælger må ikke kunne byde på egen vare");
        } catch (Exception ex) {
            // Testen består hvis den fanger en exception.
        }
    }

    /**
     * Tester at man ikke kan byde på en auktion der er slut.
     */
    @Test
    public void testSetLatesBid1() {
        System.out.println("setLatesBid1");
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 02, 21, 11, 00);
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, cal.getTime(), 1700);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("man må ikke byde på auctioner der er slut");
        } catch (Exception ex) {
            // Testen består hvis den fanger en exception.
        }
    }

    /**
     * Tester at man kan byde over startbuddet.
     */
    @Test
    public void testSetLatesBid2() {
        System.out.println("setLatesBid2");
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1700);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
        } catch (Exception ex) {
            fail("Buddet skal være højere end startbuddet.");
        }
    }

    /**
     * Tester at man kan byde over det seneste bud.
     */
    @Test
    public void testSetLatesBid3() {
        System.out.println("setLatesBid3");
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

    /**
     * Tester at man ikke kan byde med et negativt beløb.
     */
    @Test
    public void testSetLatesBid4() {
        System.out.println("setLatesBid4");
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), -170000);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("Buddet skal være højere end startbuddet.");
        } catch (Exception ex) {
            // Testen består hvis den fanger en exception.
        }
    }

    /**
     * Tester at man ikke kan byde under startbuddet.
     */
    @Test
    public void testSetLatesBid5() {
        System.out.println("setLatesBid5");
        user = new User("puol", "røvvej", 25252525);
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 500);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid);
            fail("Buddet skal være højere end startbuddet.");
        } catch (Exception ex) {
            // Testen består hvis den fanger en exception.
        }
    }

    /**
     * Tester at man ikke kan byde under det seneste bud.
     */
    @Test
    public void testSetLatesBid6() {
        System.out.println("setLatesBid6");
        user = new User("palle", "birkevej", 45454545);
        ArrayList<Bid> ab = new ArrayList<>();
        Bid bid = new Bid(user, Calendar.getInstance().getTime(), 1500);
        ab.add(bid);
        user = new User("puol", "røvvej", 25252525);
        Bid bid1 = new Bid(user, Calendar.getInstance().getTime(), 1250);
        ac.setBidingHistory(ab);
        Auction instance = ac;
        try {
            instance.setLatesBid(bid1);
            fail("Buddet skal være højere end det seneste bud.");
        } catch (Exception ex) {
            // Testen består hvis den fanger en exception.
        }
    }
}
