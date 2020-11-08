package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.junit.Test;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.CoreCompetency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {
    Job testJob1;
    Job testJob2;

    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        testJob2 = new Job();
        str2 = testJob1.toString();
        testArray = str2.split("\n");
    }

    @Test
    public void testSettingJobId(){
//        testJob1 = new Job();
//        testJob2 = new Job();
        assertEquals(testJob2.getId(),testJob1.getId()+1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        //tJF abb. testJobFields
        Job tJF=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(tJF.getName(),"Product tester");
        assertEquals(tJF.getEmployer().toString(),"ACME");
        assertEquals(tJF.getLocation().toString(),"Desert");
        assertEquals(tJF.getPositionType().toString(),"Quality control");
        assertEquals(tJF.getCoreCompetency().toString(),"Persistence");

        assertTrue(tJF.getName() instanceof String);
        assertTrue(tJF.getEmployer() instanceof Employer);
        assertTrue(tJF.getLocation() instanceof Location);
        assertTrue(tJF.getPositionType() instanceof PositionType);
        assertTrue(tJF.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job tJF1=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job tJF2=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(tJF1.equals(tJF2));
    }

    Job tJF;
    String str1;
    String str2;
    String[] array;
    String[] testArray;

    @Before
    public void createStrings() {
        tJF=new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        str1 = tJF.toString();
        array = str1.split("\n");

    }

    @Test
    public void testToStringCon1() {
        char case1 = str1.charAt(0);
        char case2 = str1.charAt(str1.length()-1);
        assertTrue(case1=='\n'&& case2=='\n');
    }

//    @Before
//    public void createArray() {
//        str2 = tJF.toString()
//    }

    @Test
    public void testToStringCon2() {
        assertTrue(array[1].substring(0,4).equals("ID: "));
        assertTrue(array[2].substring(0,6).equals("Name: "));
        assertTrue(array[3].substring(0,10).equals("Employer: "));
        assertTrue(array[4].substring(0,10).equals("Location: "));
        assertTrue(array[5].substring(0,15).equals("Position Type: "));
        assertTrue(array[6].substring(0,17).equals("Core Competency: "));

        assertTrue(array[1].substring(4).equals(String.valueOf(tJF.getId())));
        assertTrue(array[2].substring(6).equals(tJF.getName()));
        assertTrue(array[3].substring(10).equals(tJF.getEmployer().getValue()));
        assertTrue(array[4].substring(10).equals(tJF.getLocation().getValue()));
        assertTrue(array[5].substring(15).equals(tJF.getPositionType().getValue()));
        assertTrue(array[6].substring(17).equals(tJF.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringCon3() {
        assertTrue(testArray[2].substring(6).equals("Data not available"));
        assertTrue(testArray[3].substring(10).equals("Data not available"));
        assertTrue(testArray[4].substring(10).equals("Data not available"));
        assertTrue(testArray[5].substring(15).equals("Data not available"));
        assertTrue(testArray[6].substring(17).equals("Data not available"));
    }
}
