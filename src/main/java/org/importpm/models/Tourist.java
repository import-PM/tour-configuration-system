package org.importpm.models;

public class Tourist {
    private int id;
    private String name;
    private String citizenId;
    private String allergies;
    private String medicalNotes;

    public Tourist(int id, String name, String citizenId, String allergies, String medicalNotes) {
        this.id = id;
        this.name = name;
        this.citizenId = citizenId;
        this.allergies = allergies;
        this.medicalNotes = medicalNotes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }
}
