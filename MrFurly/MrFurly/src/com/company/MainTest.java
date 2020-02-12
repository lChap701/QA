package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void exampleTests() {
        //BP should be a valid building code
        assertTrue(Main.validateBuildingCode("BP"));

        //BP should return the name Benton Place
        assertEquals("Benton Place", Main.setBuildingName("BP"));

        //ZZ shouldn't be a valid building code
        assertFalse(Main.validateBuildingCode("ZZ"));

        //ZZ shouldn't have an associated building name
        assertEquals("Error: building name not found", Main.setBuildingName("ZZ"));

        Double[] expectedOutput;

        //we should expect 650.00 base rate with 0.00 tenant charge for unit number 1 with 1 tenant
        expectedOutput = new Double[]{650.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(1, 1));

        //expecting 650.00 base rate and 83.45 family rate for unit 5 with 8 tenants
        expectedOutput = new Double[]{650.00, 83.45};
        assertArrayEquals(expectedOutput, Main.setRateInfo(5, 8));


        //following code works, you could test each tenant number 1 - 8 one at a time but what would be a quicker way?
        //  HINT: think with a loop
        assertTrue(Main.validateTenants("1"));

        //True since 24 should be a good unit code
        assertTrue(Main.validateUnitCode("24"));

        //False since 9999 shouldn't be a good unit code
        assertFalse(Main.validateUnitCode("9999"));

        //expecting a premium fee of $0 since AA doesn't get charged the extra .12 %
        assertEquals(0, Main.setPremiumFee("AA", 1, 650));

        //expecting 12 dollar fee since R7 does get charged premium and we passed in 100 dollar rent due amount (100 * .12 = 12)
        assertEquals(12, Main.setPremiumFee("R7", 25, 100));

        //AA shouldn't get a government discount of 33%
        assertEquals(0, Main.setGovernmentDiscount("AA", 100));

        //Should return rent flag due to amount being over 1000
        assertEquals("****", Main.setRentFlag(1500.00));

        //Should not return anything since amount is under 1000
        assertEquals(" ", Main.setRentFlag(10.00));
    }

    @Test
        //copy and rename method as needed.  You can lump all tests in here but would be cleaner to make multiple methods.
        //  I.E make a method testing valid building codes, another method for rates, etc
    void yourTestsBug1() {
        assertTrue(Main.validateBuildingCode("AA"));
        assertEquals("Palace Place", Main.setBuildingName("AA")); // Park Palace was used instead of Palace Place
    }

    @Test
    void yourTestsFixed1() {
        assertTrue(Main.validateBuildingCode("AA"));
        assertEquals("Palace Place", Main.setBuildingName("AA")); // Park Palace was used instead of Palace Place
    }

    @Test
    void yourTestsBug2() {
        assertTrue(Main.validateBuildingCode("PP"));
        assertEquals("Park Place", Main.setBuildingName("PP")); // Park Place was misspelled
    }

    @Test
    void yourTestsFix2() {
        assertTrue(Main.validateBuildingCode("PP"));
        assertEquals("Park Place", Main.setBuildingName("PP")); // Park Place was misspelled
    }

    @Test
    void yourTestsBug3() {
        assertTrue(Main.validateBuildingCode("IA")); // IA was spelled IAHH
        assertEquals("Iowa Condo", Main.setBuildingName("IA"));
    }

    @Test
    void yourTestsFix3() {
        assertTrue(Main.validateBuildingCode("IA")); // IA was spelled IAHH
        assertEquals("Iowa Condo", Main.setBuildingName("IA"));
    }

    @Test
    void yourTestsBug4() {
        assertTrue(Main.validateBuildingCode("MS")); //MS didn't exist
        assertEquals("Market Street", Main.setBuildingName("MS"));
    }

    @Test
    void yourTestsFix4() {
        assertTrue(Main.validateBuildingCode("MS")); //MS didn't exist
        assertEquals("Market Street", Main.setBuildingName("MS"));
    }

    @Test
    void yourTestsBug5() {
        assertFalse(Main.validateBuildingCode("XX")); // XX shouldn't have existed
        assertEquals("Error: building name not found", Main.setBuildingName("XX"));
    }

    @Test
    void yourTestsFix5() {
        assertFalse(Main.validateBuildingCode("XX")); // XX shouldn't have existed
        assertEquals("Error: building name not found", Main.setBuildingName("XX"));
    }

    @Test
    void yourTestsBug6() {
        assertTrue(Main.validateBuildingCode("HH")); // HH didn't exist
        assertEquals("High Tower", Main.setBuildingName("HH"));
    }

    @Test
    void yourTestsFix6() {
        assertTrue(Main.validateBuildingCode("HH")); // HH didn't exist
        assertEquals("High Tower", Main.setBuildingName("HH"));
    }

    @Test
    void yourTestsBug7() {
        assertTrue(Main.validateBuildingCode("JK"));
        assertEquals("Jack's Place", Main.setBuildingName("JK")); //JK was never used to set condo to Jack's Place
    }

    @Test
    void yourTestsFix7() {
        assertTrue(Main.validateBuildingCode("JK"));
        assertEquals("Jack's Place", Main.setBuildingName("JK")); //JK was never used to set condo to Jack's Place
    }

    @Test
    void yourTestsBugs8() {
        assertTrue(Main.validateBuildingCode("YD"));
        assertEquals("Yankee Doodle", Main.setBuildingName("YD")); // wrote Yankee Doodle Dandy
    }

    @Test
    void yourTestsFix8() {
        assertTrue(Main.validateBuildingCode("YD"));
        assertEquals("Yankee Doodle", Main.setBuildingName("YD")); // wrote Yankee Doodle Dandy
    }

    @Test
    void yourTestsBugs9() {
        assertTrue(Main.validateBuildingCode("YD"));
        assertEquals("Yankee Doodle", Main.setBuildingName("YD")); // wrote Yankee Doodle Dandy instead of Yankee Doodle
    }

    @Test
    void yourTestsFix9() {
        assertTrue(Main.validateBuildingCode("YD"));
        assertEquals("Yankee Doodle", Main.setBuildingName("YD")); // wrote Yankee Doodle Dandy instead of Yankee Doodle
    }

    @Test
    void yourTestsBugs10() {
        assertTrue(Main.validateBuildingCode("YT"));
        assertEquals("Yahtzee Ave", Main.setBuildingName("YT")); // wrote Yahoo Ave instead of Yahtzee Ave
    }

    @Test
    void yourTestsFix10() {
        assertTrue(Main.validateBuildingCode("YT"));
        assertEquals("Yahtzee Ave", Main.setBuildingName("YT")); // wrote Yankee Doodle Dandy
    }

    @Test
    void yourTestsBugs11() {
        assertTrue(Main.validateBuildingCode("NZ"));
        assertEquals("New Zoo", Main.setBuildingName("NZ")); // wrote Zoo New instead of New Zoo
    }

    @Test
    void yourTestsFix11() {
        assertTrue(Main.validateBuildingCode("NZ"));
        assertEquals("New Zoo", Main.setBuildingName("NZ")); // wrote Zoo New instead of New Zoo
    }

    @Test
    void yourTestsNoBugs(){
        assertTrue(Main.validateBuildingCode("GG"));
        assertEquals("Georgia", Main.setBuildingName("GG"));

        assertTrue(Main.validateBuildingCode("R7"));
        assertEquals("Uptown Condos", Main.setBuildingName("R7"));

        assertTrue(Main.validateBuildingCode("GM"));
        assertEquals("Gander Mountain", Main.setBuildingName("GM"));

        assertTrue(Main.validateBuildingCode("GA"));
        assertEquals("Grand Avenue", Main.setBuildingName("GA"));

        assertTrue(Main.validateBuildingCode("ME"));
        assertEquals("Maine Apt", Main.setBuildingName("ME"));

        assertTrue(Main.validateBuildingCode("UN"));
        assertEquals("Underground Sam", Main.setBuildingName("UN"));

        assertTrue(Main.validateBuildingCode("CP"));
        assertEquals("Court Place", Main.setBuildingName("CP"));

        assertTrue(Main.validateBuildingCode("VV"));
        assertEquals("Vermont", Main.setBuildingName("VV"));

        assertTrue(Main.validateBuildingCode("CT"));
        assertEquals("China Town", Main.setBuildingName("CT"));

        assertTrue(Main.validateBuildingCode("YS"));
        assertEquals("Yorkshire", Main.setBuildingName("YS"));

        assertTrue(Main.validateBuildingCode("ME"));
        assertEquals("Maine Apt", Main.setBuildingName("ME"));
    }

    @Test
    void yourTestsArrayNoBugs() {
        Double[] expectedOutput;

        //we should expect 650.00 base rate with 75.00 tenant charge for unit number 2 with 3 tenant
        expectedOutput = new Double[]{650.00, 75.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(2, 3));

        //we should expect 650.00 base rate with 50.00 tenant charge for unit number 3 with 2 tenant
        expectedOutput = new Double[]{650.00, 50.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(3, 2));

        //we should expect 650.00 base rate with 0.00 tenant charge for unit number 4 with 1 tenant
        expectedOutput = new Double[]{650.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(4, 1));

        //we should expect 650.00 base rate with 75.00 tenant charge for unit number 6 with 3 tenant
        expectedOutput = new Double[]{650.00, 75.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(6, 3));

        //we should expect 650.00 base rate with 50.00 tenant charge for unit number 7 with 2 tenant
        expectedOutput = new Double[]{650.00, 50.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(7, 2));

        //we should expect 700.00 base rate with 0.00 tenant charge for unit number 9 with 1 tenant
        expectedOutput = new Double[]{700.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(9, 1));

        //we should expect 700.00 base rate with 0.00 tenant charge for unit number 12 with 1 tenant
        expectedOutput = new Double[]{700.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(12, 1));

        //we should expect 700.00 base rate with 135.00 tenant charge for unit number 13 with 4 tenant
        expectedOutput = new Double[]{700.00, 135.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(13, 4));

        //we should expect 700.00 base rate with 135.00 tenant charge for unit number 13 with 5 tenant
        expectedOutput = new Double[]{700.00, 135.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(14, 5));

        //we should expect 700.00 base rate with 0.00 tenant charge for unit number 15 with 1 tenant
        expectedOutput = new Double[]{700.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(15, 1));

        //we should expect 700.00 base rate with 71.10 tenant charge for unit number 16 with 2 tenant
        expectedOutput = new Double[]{700.00, 71.10};
        assertArrayEquals(expectedOutput, Main.setRateInfo(16, 2));

        //we should expect 825.00 base rate with 100.00 tenant charge for unit number 17 with 1 tenant
        expectedOutput = new Double[]{825.00, 100.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(17, 2));

        //we should expect 825.00 base rate with 150.00 tenant charge for unit number 18 with 3 tenant
        expectedOutput = new Double[]{825.00, 150.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(18, 3));

        //we should expect 825.00 base rate with 185.60 tenant charge for unit number 19 with 4 tenant
        expectedOutput = new Double[]{825.00, 185.60};
        assertArrayEquals(expectedOutput, Main.setRateInfo(19, 4));

        //we should expect 825.00 base rate with 185.60 tenant charge for unit number 21 with 5 tenant
        expectedOutput = new Double[]{825.00, 185.60};
        assertArrayEquals(expectedOutput, Main.setRateInfo(21, 5));

        //we should expect 825.00 base rate with 0.00 tenant charge for unit number 22 with 1 tenant
        expectedOutput = new Double[]{825.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(22, 1));

        //we should expect 825.00 base rate with 100.00 tenant charge for unit number 23 with 2 tenant
        expectedOutput = new Double[]{825.00, 100.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(23, 2));

        //we should expect 825.00 base rate with 150.00 tenant charge for unit number 24 with 3 tenant
        expectedOutput = new Double[]{825.00, 150.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(24, 3));

        //we should expect 825.00 base rate with 185.60 tenant charge for unit number 25 with 4 tenant
        expectedOutput = new Double[]{825.00, 185.60};
        assertArrayEquals(expectedOutput, Main.setRateInfo(25, 4));

        //we should expect 0.00 base rate with 0.00 tenant charge for unit number 26 with 99 tenant
        expectedOutput = new Double[]{0.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(26, 99));

        //we should expect 0.00 base rate with 0.00 tenant charge for unit number 26 with 99 tenant
        expectedOutput = new Double[]{0.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(0, 99));
    }

    @Test
    void yourTestsArrayBugs1() {
        Double[] expectedOutput;

        //we should expect 825.00 base rate with 0.00 tenant charge for unit number 25 with 1 tenant
        expectedOutput = new Double[]{825.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(25, 1));
        // Was set to tenantCount >= 1 instead of tenantCount > 1
        // Was set to unitNumber < 25 instead of unitNumber <= 25
    }

    @Test
    void yourTestsArrayFix1() {
        Double[] expectedOutput;

        //we should expect 825.00 base rate with 0.00 tenant charge for unit number 25 with 1 tenant
        expectedOutput = new Double[]{825.00, 0.00};
        assertArrayEquals(expectedOutput, Main.setRateInfo(25, 1));
        // Was set to tenantCount >= 1 instead of tenantCount > 1
        // Was set to unitNumber < 25 instead of unitNumber <= 25
    }

    @Test
    void yourTestsArrayBugs2() {
        Double[] expectedOutput;

        //we should expect 825.00 base rate with 185.60 tenant charge for unit number 20 with 5 tenant
        expectedOutput = new Double[]{825.00, 185.60};
        assertArrayEquals(expectedOutput, Main.setRateInfo(20, 5));
        //tenantCharge was set to 185.66 instead of 185.60
    }

    @Test
    void yourTestsArrayFix2() {
        Double[] expectedOutput;

        //we should expect 825.00 base rate with 185.60 tenant charge for unit number 20 with 5 tenant
        expectedOutput = new Double[]{825.00, 185.60};
        assertArrayEquals(expectedOutput, Main.setRateInfo(20, 5));
        //tenantCharge was set to 185.66 instead of 185.60
    }

    @Test
    void yourTestsArrayBugs3() {
        Double[] expectedOutput;

        //we should expect 700.00 base rate with 35.55 tenant charge for unit number 10 with 2 tenant
        expectedOutput = new Double[]{700.00, 71.10};
        assertArrayEquals(expectedOutput, Main.setRateInfo(10, 2));
        //tenantCharge was set to 135.55 instead of 35.55
    }

    @Test
    void yourTestsArrayFix3() {
        Double[] expectedOutput;

        //we should expect 700.00 base rate with 35.55 tenant charge for unit number 10 with 2 tenant
        expectedOutput = new Double[]{700.00, 71.10};
        assertArrayEquals(expectedOutput, Main.setRateInfo(10, 2));
        //tenantCharge was set to 135.55 instead of 35.55
    }

    @Test
    void yourTestsArrayBugs4(){
        Double[] expectedOutput;

        //we should expect 700.00 base rate with 35.55 tenant charge for unit number 11 with 3 tenant
        expectedOutput = new Double[]{700.00, 106.65};
        assertArrayEquals(expectedOutput, Main.setRateInfo(11, 3));
        // Tenant charge wasn't rounded
    }

    @Test
    void yourTestsArrayFix4(){
        Double[] expectedOutput;

        //we should expect 700.00 base rate with 35.55 tenant charge for unit number 11 with 3 tenant
        expectedOutput = new Double[]{700.00, 106.65};
        assertArrayEquals(expectedOutput, Main.setRateInfo(11, 3));
        // Tenant charge wasn't rounded
    }

    @Test
    void unitCode() {
        int i;
        for (i = 1; i < 26; i++) {
            String str = Integer.toString(i);
            assertTrue(Main.validateUnitCode(str)); // was missing regex pattern for 13, 14, 15, 16, 17, 18, and 19
        }
        for (i = 26; i < 99; i++) {
            String str = Integer.toString(i);
            assertFalse(Main.validateUnitCode(str));
        }
    }

    @Test
    void unitCodeFixed() {
        int i;
        for (i = 1; i < 26; i++) {
            String str = Integer.toString(i);
            assertTrue(Main.validateUnitCode(str)); // was missing regex pattern for 13, 14, 15, 16, 17, 18, and 19
        }

        for (i = 26; i < 99; i++) {
            String str = Integer.toString(i);
            assertFalse(Main.validateUnitCode(str));
        }
    }

    @Test
    void tenantsNum() {
        int i;
        for (i = 1; i < 10; i++) {
            String str = Integer.toString(i);
            assertTrue(Main.validateTenants(str));
        }
        assertFalse(Main.validateTenants("0"));
        assertFalse(Main.validateTenants("10"));
    }

    @Test
    void premiumFee(){
        //expecting a premium fee of $0 since Unit 16 doesn't get charged the extra .12 %
        assertEquals(0, Main.setPremiumFee("R7", 16, 700));
        //wrote unitCode >= 23 && unitCode <= 25 instead of unitCode == 23 || unitCode == 25

        //expecting 12 dollar fee since Y7 does get charged premium and we passed in 100 dollar rent due amount (100 * .12 = 12)
        assertEquals(12, Main.setPremiumFee("YT", 23, 100));
        // wrote TY instead of YT

        //expecting 1.20 dollar fee since PP does get charged premium and we passed in 100dollar rent due amount (10 * .12 = 1.20)
        assertEquals(1.20, Main.setPremiumFee("PP", 25, 10));
    }

    @Test
    void premiumFeeFixed(){
        //expecting a premium fee of $0 since Unit 16 doesn't get charged the extra .12 %
        assertEquals(0, Main.setPremiumFee("R7", 1, 650));
        //wrote unitCode >= 23 && unitCode <= 25 instead of unitCode == 23 || unitCode == 25

        //expecting 12 dollar fee since Y7 does get charged premium and we passed in 100 dollar rent due amount (100 * .12 = 12)
        assertEquals(12, Main.setPremiumFee("YT", 23, 100));
        // wrote TY instead of YT
    }

    @Test
    void governmentDiscount(){
        //BP should get a government discount of 33%
        assertEquals(133.00, Main.setGovernmentDiscount("BP", 100));

        //CP should get a government discount of 33%
        assertEquals(1330.00, Main.setGovernmentDiscount("CP", 1000));
        // wrote CT instead of CP
    }

    @Test
    void governmentDiscountFixed(){
        //CP should get a government discount of 33%
        assertEquals(1330.00, Main.setGovernmentDiscount("CP", 1000));
        // wrote CT instead of CP
    }

    @Test
    void flag(){
        //Should return rent flag due to amount being over 1000
        assertEquals("****", Main.setRentFlag(1000.01));

        //Should return rent flag due to amount being over 1000
        assertEquals(" ", Main.setRentFlag(99.99));
    }
}
