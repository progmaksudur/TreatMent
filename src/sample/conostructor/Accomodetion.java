package sample.conostructor;

public class Accomodetion {
        private  String accomodetion_hospital;
        private  String icu_rate;
        private  String ccu_rate;
        private  String acCabin_rate;
        private  String noneAcCabinDouble_rate;
        private  String noneAcCabineSingle_rate;
        private  String localBed_rate;

    public Accomodetion(String accomodetion_hospital, String icu_rate, String ccu_rate, String acCabin_rate, String noneAcCabinDouble_rate, String noneAcCabineSingle_rate, String localBed_rate) {
        this.accomodetion_hospital = accomodetion_hospital;
        this.icu_rate = icu_rate;
        this.ccu_rate = ccu_rate;
        this.acCabin_rate = acCabin_rate;
        this.noneAcCabinDouble_rate = noneAcCabinDouble_rate;
        this.noneAcCabineSingle_rate = noneAcCabineSingle_rate;
        this.localBed_rate = localBed_rate;
    }

    public Accomodetion() {
    }

    public String getAccomodetion_hospital() {
        return accomodetion_hospital;
    }

    public void setAccomodetion_hospital(String accomodetion_hospital) {
        this.accomodetion_hospital = accomodetion_hospital;
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

    @Override
    public String toString() {
        return "Accomodetion{" +
                "accomodetion_hospital='" + accomodetion_hospital + '\'' +
                ", icu_rate='" + icu_rate + '\'' +
                ", ccu_rate='" + ccu_rate + '\'' +
                ", acCabin_rate='" + acCabin_rate + '\'' +
                ", noneAcCabinDouble_rate='" + noneAcCabinDouble_rate + '\'' +
                ", noneAcCabineSingle_rate='" + noneAcCabineSingle_rate + '\'' +
                ", localBed_rate='" + localBed_rate + '\'' +
                '}';
    }
}
