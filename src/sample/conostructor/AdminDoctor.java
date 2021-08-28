package sample.conostructor;

public class AdminDoctor {
    private String doctor_Hospital_Name;
    private String doctor_name;
    private String doctor_email;
    private String doctor_phone;
    private String doctor_chamber;
    private String doctor_specialist;
    private String doctor_visit_time;
    private String doctor_visit_day;
    private String doctor_visit_fees;
    private String doctor_degree;

    public AdminDoctor(String doctor_Hospital_Name, String doctor_name, String doctor_email, String doctor_phone, String doctor_chamber, String doctor_specialist, String doctor_visit_time, String doctor_visit_day, String doctor_visit_fees, String doctor_degree) {
        this.doctor_Hospital_Name = doctor_Hospital_Name;
        this.doctor_name = doctor_name;
        this.doctor_email = doctor_email;
        this.doctor_phone = doctor_phone;
        this.doctor_chamber = doctor_chamber;
        this.doctor_specialist = doctor_specialist;
        this.doctor_visit_time = doctor_visit_time;
        this.doctor_visit_day = doctor_visit_day;
        this.doctor_visit_fees = doctor_visit_fees;
        this.doctor_degree = doctor_degree;
    }

    public AdminDoctor() {
    }

    public String getDoctor_Hospital_Name() {
        return doctor_Hospital_Name;
    }

    public void setDoctor_Hospital_Name(String doctor_Hospital_Name) {
        this.doctor_Hospital_Name = doctor_Hospital_Name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public String getDoctor_chamber() {
        return doctor_chamber;
    }

    public void setDoctor_chamber(String doctor_chamber) {
        this.doctor_chamber = doctor_chamber;
    }

    public String getDoctor_specialist() {
        return doctor_specialist;
    }

    public void setDoctor_specialist(String doctor_specialist) {
        this.doctor_specialist = doctor_specialist;
    }

    public String getDoctor_visit_time() {
        return doctor_visit_time;
    }

    public void setDoctor_visit_time(String doctor_visit_time) {
        this.doctor_visit_time = doctor_visit_time;
    }

    public String getDoctor_visit_day() {
        return doctor_visit_day;
    }

    public void setDoctor_visit_day(String doctor_visit_day) {
        this.doctor_visit_day = doctor_visit_day;
    }

    public String getDoctor_visit_fees() {
        return doctor_visit_fees;
    }

    public void setDoctor_visit_fees(String doctor_visit_fees) {
        this.doctor_visit_fees = doctor_visit_fees;
    }

    public String getDoctor_degree() {
        return doctor_degree;
    }

    public void setDoctor_degree(String doctor_degree) {
        this.doctor_degree = doctor_degree;
    }

    @Override
    public String toString() {
        return "AdminDoctor{" +
                "doctor_Hospital_Name='" + doctor_Hospital_Name + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_email='" + doctor_email + '\'' +
                ", doctor_phone='" + doctor_phone + '\'' +
                ", doctor_chamber='" + doctor_chamber + '\'' +
                ", doctor_specialist='" + doctor_specialist + '\'' +
                ", doctor_visit_time='" + doctor_visit_time + '\'' +
                ", doctor_visit_day='" + doctor_visit_day + '\'' +
                ", doctor_visit_fees='" + doctor_visit_fees + '\'' +
                ", doctor_degree='" + doctor_degree + '\'' +
                '}';
    }
}
