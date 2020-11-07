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
}
