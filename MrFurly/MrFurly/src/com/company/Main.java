package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        String buildingInfo[] = readBuildingCode();
        String buildingCode = buildingInfo[0];
        String buildingName = buildingInfo[1];

        Integer unitCode = Integer.parseInt(readUnitCode());
        Integer tenantCount = Integer.parseInt(readTenantCount());

        Double rateInfo[] = setRateInfo(unitCode,tenantCount);
        double baseRate = rateInfo[0];
        double tenantCharge = rateInfo[1];

        double rentDue = baseRate + tenantCharge;

        double premiumFeeAmount = setPremiumFee(buildingCode, unitCode, rentDue);

        double governmentDiscountAmount = setGovernmentDiscount(buildingCode, rentDue);

        rentDue += premiumFeeAmount + governmentDiscountAmount;

        String rentFlag = setRentFlag(rentDue);

        System.out.println("");
        System.out.println("Total Rent Due = " + rentDue + " " + rentFlag);
    }

    public static String[] readBuildingCode(){
        String input;
        String buildingName;
        do {
            System.out.println("Please enter Building Code");
            input = myScanner.next().toUpperCase();
            if (!validateBuildingCode(input)){
                System.out.println("Invalid building code, please try again");
            }
        } while (!validateBuildingCode(input));

        buildingName = setBuildingName(input);

        return new String[] {input,buildingName};
    }

    public static boolean validateBuildingCode(String input) {
        return input.matches("^(AA|GG|PP|IA|HH|R7|GM|BP|GA|JK|UN|YD|YT|CP|NZ|VV|CT|YS|ME|MS)$");
    }

    public static String setBuildingName(String key) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("AA","Palace Place");
        map.put("GG","Georgia");
        map.put("PP","Park Place");
        map.put("IA","Iowa Condo");
        map.put("MS","Market Street");
        map.put("HH","High Tower");
        map.put("R7","Uptown Condos");
        map.put("GM","Gander Mountain");
        map.put("BP","Benton Place");
        map.put("GA","Grand Avenue");
        map.put("JK","Jack's Place");
        map.put("UN","Underground Sam");
        map.put("YD","Yankee Doodle");
        map.put("YT","Yahtzee Ave");
        map.put("CP","Court Place");
        map.put("NZ","New Zoo");
        map.put("VV","Vermont");
        map.put("CT","China Town");
        map.put("YS","Yorkshire");
        map.put("ME","Maine Apt");

        String buildingName;
        buildingName = map.getOrDefault(key, "Error: building name not found");

        return buildingName;
    }

    public static String readUnitCode(){
        String input;

        do {
            System.out.println("Please enter Unit Code");
            input = myScanner.next();
            if (!validateUnitCode(input)){
                System.out.println("Invalid unit code, please try again");
            }
        } while (!validateUnitCode(input));
        return input;
    }

    public static boolean validateUnitCode(String input) {
    return input.matches("^([1-9]|1[0-9]|2[0-5])$");
    }

    public static String readTenantCount(){
        String input;

        do {
            System.out.println("Please enter number of tenants");
            input = myScanner.next();
            if (!validateTenants(input)){
                System.out.println("Invalid number of tenants, please try again");
            }
        } while (!validateTenants(input));
        return input;
    }

    public static boolean validateTenants(String input) {
        return input.matches("^([1-9]{1,2})$");
    }

    public static Double[] setRateInfo (Integer unitNumber,Integer tenantCount){
        Double baseRate;
        Double tenantCharge = 0.00;
        Double rouTenantCharge; // rouTenantCharge is used to help get the rounded value of tenantCharge


        if (unitNumber >= 1 && unitNumber <= 8){
            baseRate = 650.00;
            if (tenantCount > 1 && tenantCount < 4){
                rouTenantCharge = 25.00 * tenantCount;
                tenantCharge = Math.round(rouTenantCharge * 100.0) / 100.0;
            }
            else if (tenantCount >= 4) {
                tenantCharge = 83.45;
            }
        }
        else if (unitNumber >= 9 && unitNumber <= 16){
            baseRate = 700.00;
            if (tenantCount > 1 && tenantCount < 4){
                rouTenantCharge = 35.55 * tenantCount;
                tenantCharge = Math.round(rouTenantCharge * 100.0) / 100.0;

            }
            else if (tenantCount >= 4) {
                tenantCharge = 135.00;
            }
        }
        else if (unitNumber >= 17 && unitNumber <= 25){
            baseRate = 825.00;
            if (tenantCount > 1 && tenantCount < 4){
                rouTenantCharge = 50.00 * tenantCount;
                tenantCharge = Math.round(rouTenantCharge * 100.0) / 100.0;
            }
            else if (tenantCount >= 4) {
                tenantCharge = 185.60;
            }
        }
        else {
            //default, invalid unit number
            baseRate = 0.00;
            tenantCharge = 0.00;
        }
        return new Double[] {baseRate, tenantCharge};
    }

    public static double setPremiumFee (String buildingCode, Integer unitCode, double rentDue){
        double premiumFee = 0;

        if ((buildingCode.equals("R7") || buildingCode.equals("YT") || buildingCode.equals("PP")) && (unitCode == 23 || unitCode == 25)){
            premiumFee = rentDue * .12;
        }

        return  premiumFee;
    }

    public static double setGovernmentDiscount (String buildingCode, double rentDue){
        double discountAmnt = 0;

        if (buildingCode.equals("BP") || buildingCode.equals("CP")){
            discountAmnt += rentDue * 1.33; // should be +=
        }

        return  discountAmnt;
    }

    public static String setRentFlag (double rentDue){
        String rentFlag = " ";
        if (rentDue > 750){
            rentFlag = "****";
        }

        return  rentFlag;
    }
}
