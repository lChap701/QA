package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    static PopSale mySale = new PopSale();
    static List<PopSale> allSales = new ArrayList<PopSale>();


    //make work based on array or console input
    public static void main(String[] args) {
        String[] methodNames = {"setLastName", "setFirstName", "setAddress", "setCity", "setState", "setZip", "setPopType", "setQuantity", "setTeamCode"};

        do {
            for (String methodName : methodNames) {
                callMethod(methodName);
            }
            allSales.add(mySale);
        }while (userContinue());


        Map<Character, Double> teamTotals = setupTeamTotals();
        Map<Integer, Double> popTotals = setupPopTotals();
        for (PopSale thisSale : allSales){
            Double saleAmnt = Math.round(thisSale.getSaleAmnt(thisSale.getQuantity()) * 100.0) / 100.0;
            System.out.println("Team = "+ thisSale.getTeamCode() +
                                "  Pop Type = " + PopSale.getPopName(thisSale.getPopType()) +
                                "  Deposit amnt = " + thisSale.getDepositAmnt(thisSale.getState(),thisSale.getQuantity()) +
                                "  Quantity = " + thisSale.getQuantity() +
                                "  Total sale amnt = " + saleAmnt);

            teamTotals.put(thisSale.getTeamCode(), teamTotals.getOrDefault(thisSale.getTeamCode(), 0.0) + saleAmnt);
            popTotals.put(thisSale.getPopType(), popTotals.getOrDefault(thisSale.getPopType(), 0.0) + saleAmnt);
        }

        printTeamTotals(teamTotals);
        printPopTotals(popTotals);
    }

    public static void printTeamTotals (Map<Character,Double> teamTotals){
        for (Map.Entry<Character, Double> entry : teamTotals.entrySet()) {
            Character key = entry.getKey();
            Double value = entry.getValue();
            System.out.println("Total for team "+ key + " was " + value);
        }
    }

    public static void printPopTotals (Map<Integer,Double> popTotals){
        for (Map.Entry<Integer, Double> entry : popTotals.entrySet()) {
            Double value = entry.getValue();
            String popName = PopSale.getPopName(entry.getKey());
            System.out.println("Total for " + popName + " was " + value);
        }
    }

    public static boolean userContinue (){
        System.out.println("Press Y to enter another sale, Press N to quit");
        String input = myScanner.nextLine().toUpperCase();

        boolean userContinue = false;
        if (input.equals("Y")){
            userContinue = true;
        }

        return userContinue;
    }

    public static void callMethod(String methodName){
        Method myMethod = setMethod(methodName);
        String input = getInput(methodName);

        if (myMethod != null){
            try {
                myMethod.invoke(mySale,input);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                printDefaultMethodError(methodName);
            }
        }
    }


    public static Method setMethod(String methodName) {
        Method myMethod = null;
//        boolean methodFound = false;
        try {
            //trys to a method in PopSales calls, method called depends on passed on string
//            this is "reflection" not advised to use much and rather slow/
            myMethod = mySale.getClass().getMethod(methodName, String.class);
        }
        //catching invalid String that were passed in
        catch (NoSuchMethodException e) {
            printDefaultMethodError(methodName);
        }
        //snafu - "should" never happen
        catch (Exception e){

        }
        return myMethod;
    }

    public static String getInput (String methodName){
        String defaultPlease = "Please input ";
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

        System.out.println(map.getOrDefault(methodName, "Error: method name not found"));
        String input = myScanner.nextLine();

        return input;
    }

    public static void printDefaultMethodError (String methodName){
        System.out.println("PopSale." + methodName + " does not exist");
    }

    public static Map<Character, Double> setupTeamTotals () {
        Map<Character, Double> teamTotals = new HashMap<Character, Double>();
        teamTotals.put('A', 0.0);
        teamTotals.put('B', 0.0);
        teamTotals.put('C', 0.0);
        teamTotals.put('D', 0.0);
        teamTotals.put('E', 0.0);

        return teamTotals;
    }

    public static Map<Integer, Double> setupPopTotals () {
        Map<Integer, Double> popTotals = new HashMap<Integer, Double>();
        popTotals.put(1, 0.0);
        popTotals.put(2, 0.0);
        popTotals.put(3, 0.0);
        popTotals.put(4, 0.0);
        popTotals.put(5, 0.0);
        popTotals.put(6, 0.0);

        return popTotals;
    }
}
