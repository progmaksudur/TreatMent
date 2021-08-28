package sample.conostructor;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Hospital {
        private String userid;
        private String hospital_name;
        private String hospital_address;
        private String hospital_numbers;
        private String hospital_emails;
        private String hospital_website;
        private String hospital_type;

    public Hospital(String userid, String hospital_name, String hospital_address, String hospital_numbers, String hospital_emails, String hospital_website, String hospital_type) {
        this.userid = userid;
        this.hospital_name = hospital_name;
        this.hospital_address = hospital_address;
        this.hospital_numbers = hospital_numbers;
        this.hospital_emails = hospital_emails;
        this.hospital_website = hospital_website;
        this.hospital_type = hospital_type;
    }

    public Hospital() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getHospital_address() {
        return hospital_address;
    }

    public void setHospital_address(String hospital_address) {
        this.hospital_address = hospital_address;
    }

    public String getHospital_numbers() {
        return hospital_numbers;
    }

    public void setHospital_numbers(String hospital_numbers) {
        this.hospital_numbers = hospital_numbers;
    }

    public String getHospital_emails() {
        return hospital_emails;
    }

    public void setHospital_emails(String hospital_emails) {
        this.hospital_emails = hospital_emails;
    }

    public String getHospital_website() {
        return hospital_website;
    }

    public void setHospital_website(String hospital_website) {
        this.hospital_website = hospital_website;
    }

    public String getHospital_type() {
        return hospital_type;
    }

    public void setHospital_type(String hospital_type) {
        this.hospital_type = hospital_type;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "userid='" + userid + '\'' +
                ", hospital_name='" + hospital_name + '\'' +
                ", hospital_address='" + hospital_address + '\'' +
                ", hospital_numbers='" + hospital_numbers + '\'' +
                ", hospital_emails='" + hospital_emails + '\'' +
                ", hospital_website='" + hospital_website + '\'' +
                ", hospital_type='" + hospital_type + '\'' +
                '}';
    }
}
