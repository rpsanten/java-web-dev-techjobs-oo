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
    String[] array;
//    String str2;

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
        assertTrue(array[0].substring(0,3).equals("ID: "));
        assertTrue(array[1].substring(0,5).equals("Name: "));
        assertTrue(array[2].substring(0,9).equals("Employer: "));
        assertTrue(array[3].substring(0,9).equals("Location: "));
        assertTrue(array[4].substring(0,14).equals("Position Type: "));
        assertTrue(array[5].substring(0,16).equals("Core Competency: "));

        assertTrue(array[0].substring(4,array[0].length()-1).equals(tJF.getId()));
        assertTrue(array[1].substring(6,array[1].length()-1).equals(tJF.getName()));
        assertTrue(array[2].substring(10,array[2].length()-1).equals(tJF.getEmployer()));
        assertTrue(array[3].substring(10,array[3].length()-1).equals(tJF.getLocation()));
        assertTrue(array[4].substring(15,array[4].length()-1).equals(tJF.getPositionType()));
        assertTrue(array[5].substring(17,array[5].length()-1).equals(tJF.getCoreCompetency()));

    }
}
