package sample.conostructor;

import javafx.fxml.FXML;

public class ShowDoctor {

    private String doctor_name;
    private String doctor_specialist;
    private String doctor_degree;
    private String doctor_visit_day;
    private String doctor_visit_time;
    private String doctor_chamber;
    private String doctor_visit_fees;
    private String doctor_Hospital_Name;

    public ShowDoctor(String doctor_name, String doctor_specialist, String doctor_degree, String doctor_visit_day, String doctor_visit_time, String doctor_chamber, String doctor_visit_fees, String doctor_Hospital_Name) {
        this.doctor_name = doctor_name;
        this.doctor_specialist = doctor_specialist;
        this.doctor_degree = doctor_degree;
        this.doctor_visit_day = doctor_visit_day;
        this.doctor_visit_time = doctor_visit_time;
        this.doctor_chamber = doctor_chamber;
        this.doctor_visit_fees = doctor_visit_fees;
        this.doctor_Hospital_Name = doctor_Hospital_Name;
    }

    public ShowDoctor() {
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_specialist() {
        return doctor_specialist;
    }

    public void setDoctor_specialist(String doctor_specialist) {
        this.doctor_specialist = doctor_specialist;
    }

    public String getDoctor_degree() {
        return doctor_degree;
    }

    public void setDoctor_degree(String doctor_degree) {
        this.doctor_degree = doctor_degree;
    }

    public String getDoctor_visit_day() {
        return doctor_visit_day;
    }

    public void setDoctor_visit_day(String doctor_visit_day) {
        this.doctor_visit_day = doctor_visit_day;
    }

    public String getDoctor_visit_time() {
        return doctor_visit_time;
    }

    public void setDoctor_visit_time(String doctor_visit_time) {
        this.doctor_visit_time = doctor_visit_time;
    }

    public String getDoctor_chamber() {
        return doctor_chamber;
    }

    public void setDoctor_chamber(String doctor_chamber) {
        this.doctor_chamber = doctor_chamber;
    }

    public String getDoctor_visit_fees() {
        return doctor_visit_fees;
    }

    public void setDoctor_visit_fees(String doctor_visit_fees) {
        this.doctor_visit_fees = doctor_visit_fees;
    }

    public String getDoctor_Hospital_Name() {
        return doctor_Hospital_Name;
    }

    public void setDoctor_Hospital_Name(String doctor_Hospital_Name) {
        this.doctor_Hospital_Name = doctor_Hospital_Name;
    }

    @Override
    public String toString() {
        return "ShowDoctor{" +
                "doctor_name='" + doctor_name + '\'' +
                ", doctor_specialist='" + doctor_specialist + '\'' +
                ", doctor_degree='" + doctor_degree + '\'' +
                ", doctor_visit_day='" + doctor_visit_day + '\'' +
                ", doctor_visit_time='" + doctor_visit_time + '\'' +
                ", doctor_chamber='" + doctor_chamber + '\'' +
                ", doctor_visit_fees='" + doctor_visit_fees + '\'' +
                ", doctor_Hospital_Name='" + doctor_Hospital_Name + '\'' +
                '}';
    }
}
