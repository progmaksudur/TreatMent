package sample.conostructor;

public class AdminTest {
    private String test_hospital_name;
    private String test_name;
    private String test_place;
    private String test_type;
    private String test_requarment;
    private String test_time;
    private String test_day;
    private String test_rate;

    public AdminTest(String test_hospital_name, String test_name, String test_place, String test_type, String test_requarment, String test_time, String test_day, String test_rate) {
        this.test_hospital_name = test_hospital_name;
        this.test_name = test_name;
        this.test_place = test_place;
        this.test_type = test_type;
        this.test_requarment = test_requarment;
        this.test_time = test_time;
        this.test_day = test_day;
        this.test_rate = test_rate;
    }

    public AdminTest() {
    }

    public String getTest_hospital_name() {
        return test_hospital_name;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTest_place() {
        return test_place;
    }

    public void setTest_place(String test_place) {
        this.test_place = test_place;
    }

    public String getTest_type() {
        return test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getTest_requarment() {
        return test_requarment;
    }

    public void setTest_requarment(String test_requarment) {
        this.test_requarment = test_requarment;
    }

    public String getTest_time() {
        return test_time;
    }

    public void setTest_time(String test_time) {
        this.test_time = test_time;
    }

    public String getTest_day() {
        return test_day;
    }

    public void setTest_day(String test_day) {
        this.test_day = test_day;
    }

    public String getTest_rate() {
        return test_rate;
    }

    public void setTest_rate(String test_rate) {
        this.test_rate = test_rate;
    }

    public void setTest_hospital_name(String test_hospital_name) {
        this.test_hospital_name = test_hospital_name;
    }

    @Override
    public String toString() {
        return "AdminTest{" +
                "test_hospital_name='" + test_hospital_name + '\'' +
                ", test_name='" + test_name + '\'' +
                ", test_place='" + test_place + '\'' +
                ", test_type='" + test_type + '\'' +
                ", test_requarment='" + test_requarment + '\'' +
                ", test_time='" + test_time + '\'' +
                ", test_day='" + test_day + '\'' +
                ", test_rate='" + test_rate + '\'' +
                '}';
    }
}
