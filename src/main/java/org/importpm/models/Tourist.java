package org.importpm.models;

public class Tourist {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String allergies;
    private String medicalNotes;

    private TravelInsurance travelInsurance;

    public Tourist(String name, String phoneNumber, String email, String allergies, String medicalNotes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.allergies = allergies;
        this.medicalNotes = medicalNotes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public TravelInsurance getTravelInsurance() {
        return travelInsurance;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public void setTravelInsurance(TravelInsurance travelInsurance) {
        this.travelInsurance = travelInsurance;
    }

    public void setId(int id) {
        this.id = id;
    }

}
