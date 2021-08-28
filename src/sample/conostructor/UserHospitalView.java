package sample.conostructor;

public class UserHospitalView {
    private String hospital_name;
    private String hospital_address;
    private String hospital_numbers;
    private String hospital_website;
    private  String icu_rate;
    private  String ccu_rate;
    private  String acCabin_rate;
    private  String noneAcCabinDouble_rate;
    private  String noneAcCabineSingle_rate;
    private  String localBed_rate;
    private String hospital_type;

    public UserHospitalView(String hospital_name, String hospital_address, String hospital_numbers, String hospital_website, String icu_rate, String ccu_rate, String acCabin_rate, String noneAcCabinDouble_rate, String noneAcCabineSingle_rate, String localBed_rate, String hospital_type) {
        this.hospital_name = hospital_name;
        this.hospital_address = hospital_address;
        this.hospital_numbers = hospital_numbers;
        this.hospital_website = hospital_website;
        this.icu_rate = icu_rate;
        this.ccu_rate = ccu_rate;
        this.acCabin_rate = acCabin_rate;
        this.noneAcCabinDouble_rate = noneAcCabinDouble_rate;
        this.noneAcCabineSingle_rate = noneAcCabineSingle_rate;
        this.localBed_rate = localBed_rate;
        this.hospital_type = hospital_type;
    }

    public UserHospitalView() {
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

    public String getHospital_website() {
        return hospital_website;
    }

    public void setHospital_website(String hospital_website) {
        this.hospital_website = hospital_website;
    }

    public String getIcu_rate() {
        return icu_rate;
    }

    public void setIcu_rate(String icu_rate) {
        this.icu_rate = icu_rate;
    }

    public String getCcu_rate() {
        return ccu_rate;
    }

    public void setCcu_rate(String ccu_rate) {
        this.ccu_rate = ccu_rate;
    }

    public String getAcCabin_rate() {
        return acCabin_rate;
    }

    public void setAcCabin_rate(String acCabin_rate) {
        this.acCabin_rate = acCabin_rate;
    }

    public String getNoneAcCabinDouble_rate() {
        return noneAcCabinDouble_rate;
    }

    public void setNoneAcCabinDouble_rate(String noneAcCabinDouble_rate) {
        this.noneAcCabinDouble_rate = noneAcCabinDouble_rate;
    }

    public String getNoneAcCabineSingle_rate() {
        return noneAcCabineSingle_rate;
    }

    public void setNoneAcCabineSingle_rate(String noneAcCabineSingle_rate) {
        this.noneAcCabineSingle_rate = noneAcCabineSingle_rate;
    }

    public String getLocalBed_rate() {
        return localBed_rate;
    }

    public void setLocalBed_rate(String localBed_rate) {
        this.localBed_rate = localBed_rate;
    }

    public String getHospital_type() {
        return hospital_type;
    }

    public void setHospital_type(String hospital_type) {
        this.hospital_type = hospital_type;
    }

    @Override
    public String toString() {
        return "UserHospitalView{" +
                "hospital_name='" + hospital_name + '\'' +
                ", hospital_address='" + hospital_address + '\'' +
                ", hospital_numbers='" + hospital_numbers + '\'' +
                ", hospital_website='" + hospital_website + '\'' +
                ", icu_rate='" + icu_rate + '\'' +
                ", ccu_rate='" + ccu_rate + '\'' +
                ", acCabin_rate='" + acCabin_rate + '\'' +
                ", noneAcCabinDouble_rate='" + noneAcCabinDouble_rate + '\'' +
                ", noneAcCabineSingle_rate='" + noneAcCabineSingle_rate + '\'' +
                ", localBed_rate='" + localBed_rate + '\'' +
                ", hospital_type='" + hospital_type + '\'' +
                '}';
    }
}
