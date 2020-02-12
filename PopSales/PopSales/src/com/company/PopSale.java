package com.company;

import com.company.IllegalCharacterException;
import com.company.OutofRangeException;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to create objects containing user id and password.
 */
public class PopSale {
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private Integer zip;
    private Integer popType;
    private Integer quantity;
    private Character teamCode;

    public PopSale() {
        lastName = null;
        firstName = null;
        address = null;
        city = null;
        state = null;
        zip = null;
        popType = null;
        quantity = null;
        teamCode = null;
    }

    public PopSale(
            String lastName,
            String firstName,
            String address,
            String city,
            String state,
            Integer zip,
            Integer popType,
            Integer quantity,
            Character teamCode
    ) throws IllegalCharacterException, OutofRangeException {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setAddress(address);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
        this.setPopType(popType);
        this.setQuantity(quantity);
        this.setTeamCode(teamCode);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalCharacterException {
        if (!Common.isNullOrEmpty(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalCharacterException("Input is requried");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
//            throws IllegalCharacterException {
//        if (!firstName.matches("[^#&<>\"~;$^%{}?]$")) {
            this.firstName = firstName;
//        } else {
//            throw new IllegalCharacterException("Illegal Character in String");
//        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
//        throws IllegalCharacterException {
//        if (address.matches("^\\d+\\s[A-z]+\\s[A-z]{1,15}$")) {
            this.address = address;
//        } else {
//            throw new IllegalCharacterException("Illegal Character in String");
//        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
//        throws IllegalCharacterException {
//        if (city.matches("[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,15}$")) {
            this.city = city;
//        } else {
//            throw new IllegalCharacterException("Illegal Character in String");
//        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) throws IllegalCharacterException {
//        if (state.matches("^(IA|IL|MI|MO|NE|WI)$")) {
            this.state = state;
//        }
        //could be expanded to be illegal character vs unsupported state
//        else {
//            throw new IllegalCharacterException("Illegal Character in String");
//        }
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public void setZip(String zip) {
        this.zip = Integer.parseInt(zip);
    }

    public Integer getPopType() {
        return popType;
    }

    public void setPopType(Integer popType) throws OutofRangeException {
        validatePopType(popType);
        this.popType = popType;
    }

    public void setPopType(String strPopType) throws OutofRangeException {
        Integer intPopType = Integer.parseInt(strPopType);
        validatePopType(intPopType);
        this.popType = intPopType;
    }

    public void validatePopType(Integer popType) throws OutofRangeException {
        if (popType >= 1 && popType <= 6) {
        }
        else {
            throw new OutofRangeException("Pop type must be between 1-6");
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }

    public Character getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(Character teamCode) throws OutofRangeException {
        teamCode = Character.toUpperCase(teamCode);
        validateTeamCode(teamCode);
        this.teamCode = teamCode;
    }

    public void setTeamCode(String strTeamCode) throws OutofRangeException {
        strTeamCode = strTeamCode.toUpperCase();
        Character chrTeamCode = strTeamCode.charAt(0);
        validateTeamCode(chrTeamCode);
        this.teamCode = chrTeamCode;
    }

    public void validateTeamCode (Character teamCode) throws OutofRangeException {
        if (teamCode >= 'A' && teamCode <= 'E') {

        } else {
            throw new OutofRangeException("Team code must be between A-E");
        }
    }

    static Double getDepositAmnt(String state, Integer quantity) {
        double depositPerCan = 0;
        double cansPerCase = 24;
        switch (state) {
            case "IA":
            case "NE":
            case "WI":
                depositPerCan = 0.5;
                break;
            case "MI":
                depositPerCan = .1;
                break;
        }

        return (depositPerCan * cansPerCase * quantity);
    }

    static Double getSaleAmnt(Integer quantity) {
        double pricePerCase = 18.71;
        return (pricePerCase * quantity);
    }

    static String getPopName(Integer popNum) {
        Map<Integer, String> popNames = new HashMap<Integer, String>();
        popNames.put(1, "Coke");
        popNames.put(2, "Diet Coke");
        popNames.put(3, "Mello Yello");
        popNames.put(4, "Cherry Coke");
        popNames.put(5, "Diet Cherry Coke");
        popNames.put(6, "Sprite");

        return (popNames.getOrDefault(popNum, "Error: pop type not found"));
    }
}