package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    //example testing team total print
    void printTeamTotals() {
        //setting up so assert equal can read println from method
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //setting up total for test
        Map<Character, Double> teamTotals = new HashMap<Character, Double>();
        teamTotals.put('A', 123.0);

        Main.printTeamTotals(teamTotals);

        //asserting passed in map prints correct message
        //  \r\n needed to ignore line endings that were causing false negatives
        assertEquals("Total for team A was 123.0\r\n", outContent.toString());
    }

    @Test
    void printPopTotals() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // setting up pop total for test
        Map<Integer, Double> popTotals = new HashMap<Integer, Double>();
        popTotals.put(1, 123.0);

        // finds pop name
        String popName = PopSale.getPopName(1);

        Main.printPopTotals(popTotals);

        assertEquals("Total for " + popName + " was 123.0\r\n", outContent.toString());
    }

    @Test
    void userContinue() {
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // works like System.in

        assertTrue(Main.userContinue()); // returns boolean rather than String
    }


    //this may not be possible to assertEquals
//    @Test
//    void callMethod() {
//    }

    @Test
    void setMethod() throws NoSuchMethodException {
        //passing in the name of a method in PopSale class
        //result is full method name that can be called later
        Method myMethod = new PopSale().getClass().getMethod("setFirstName",String.class);
        assertEquals(myMethod, Main.setMethod("setFirstName"));

    }

    @Test
    void getInput() {
        String defaultPlease = "Please input ";
        String input = "setFirstName";
        String methodNames = "setFirstName";


        Map<String,String> map = new HashMap<String,String>();
        map.put("setLastName",defaultPlease + "last name");
        map.put("setFirstName",defaultPlease + "first name");
        map.put("setAddress",defaultPlease + "address");
        map.put("setCity",defaultPlease + "city");
        map.put("setState",defaultPlease + "state");
        map.put("setZip",defaultPlease + "zip code");
        map.put("setQuantity",defaultPlease + "quantity sold");
        map.put("setPopType",defaultPlease + "pop type");
        map.put("setTeamCode",defaultPlease + "team letter");

        System.out.println(map.getOrDefault(methodNames, "Error: method name not found"));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // works like System.in

        assertEquals("setFirstName", Main.getInput(methodNames));
    }

    @Test
    void printDefaultMethodError() {
        //setting up so assert equal can read println from method
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.printDefaultMethodError("setBlahBlahBlah");
        //  \r\n needed to ignore line endings that were causing false negatives
        assertEquals("PopSale.setBlahBlahBlah does not exist\r\n", outContent.toString());
    }

    @Test
    void setupTeamTotals() {
        Main.setupTeamTotals().put('A', 0.0);
        Main.setupTeamTotals().put('B', 0.0);
        Main.setupTeamTotals().put('C', 0.0);
        Main.setupTeamTotals().put('D', 0.0);
        Main.setupTeamTotals().put('E', 0.0);
    }

    @Test
    void setupPopTotals() {
        Main.setupPopTotals().put(1, 0.0);
        Main.setupPopTotals().put(2, 0.0);
        Main.setupPopTotals().put(3, 0.0);
        Main.setupPopTotals().put(4, 0.0);
        Main.setupPopTotals().put(5, 0.0);
        Main.setupPopTotals().put(6, 0.0);
    }

    @Test
    void getPopName(){

    }
}