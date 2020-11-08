package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        this.id=nextId;
        nextId++;
    }

    public Job(String name,Employer employer,Location location,PositionType positionType,CoreCompetency coreCompetency){
        this();
        this.name=name;
        this.employer=employer;
        this.location=location;
        this.positionType=positionType;
        this.coreCompetency=coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String thisName;
        String thisEmployer;
        String thisLocation;
        String thisPositionType;
        String thisCoreCompetency;

        if(this.getName()==null){thisName="Data not available";}
        else{
            thisName=this.getName();
            thisName=thisName.trim();
            if(thisName==""){thisName="Data not available";}
        }

        if(this.getEmployer()==null){thisEmployer="Data not available";}
        else{
            thisEmployer=this.getEmployer().getValue();
            thisEmployer=thisEmployer.trim();
            if(thisEmployer==""){thisEmployer="Data not available";}
        }

        if(this.getLocation()==null){thisLocation="Data not available";}
        else{
            thisLocation=this.getLocation().getValue();
            thisLocation=thisLocation.trim();
            if(thisLocation==""){thisLocation="Data not available";}
        }

        if(this.getPositionType()==null){thisPositionType="Data not available";}
        else{
            thisPositionType=this.getPositionType().getValue();
            thisPositionType=thisPositionType.trim();
            if(thisPositionType==""){thisPositionType="Data not available";}
        }

        if(this.getCoreCompetency()==null){thisCoreCompetency="Data not available";}
        else{
            thisCoreCompetency=this.getCoreCompetency().getValue();
            thisCoreCompetency=thisCoreCompetency.trim();
            if(thisCoreCompetency==""){thisCoreCompetency="Data not available";}
        }


        return "\nID: "+String.valueOf(this.getId())+"\n" +
                "Name: "+thisName+"\n" +
                "Employer: "+thisEmployer+"\n" +
                "Location: "+thisLocation+"\n" +
                "Position Type: "+thisPositionType+"\n" +
                "Core Competency: "+thisCoreCompetency+"\n";
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
