package sample.conostructor;

public class Packge {
    private  String packge_for_hospital;
    private  String packge_name;
    private  String packge_detail;
    private  String packge_include;
    private  String packge_price;

    public Packge(String packge_for_hospital, String packge_name, String packge_detail, String packge_include, String packge_price) {
        this.packge_for_hospital = packge_for_hospital;
        this.packge_name = packge_name;
        this.packge_detail = packge_detail;
        this.packge_include = packge_include;
        this.packge_price = packge_price;
    }

    public Packge() {
    }

    public String getPackge_for_hospital() {
        return packge_for_hospital;
    }

    public void setPackge_for_hospital(String packge_for_hospital) {
        this.packge_for_hospital = packge_for_hospital;
    }

    public String getPackge_name() {
        return packge_name;
    }

    public void setPackge_name(String packge_name) {
        this.packge_name = packge_name;
    }

    public String getPackge_detail() {
        return packge_detail;
    }

    public void setPackge_detail(String packge_detail) {
        this.packge_detail = packge_detail;
    }

    public String getPackge_include() {
        return packge_include;
    }

    public void setPackge_include(String packge_include) {
        this.packge_include = packge_include;
    }

    public String getPackge_price() {
        return packge_price;
    }

    public void setPackge_price(String packge_price) {
        this.packge_price = packge_price;
    }

    @Override
    public String toString() {
        return "Packge{" +
                "packge_for_hospital='" + packge_for_hospital + '\'' +
                ", packge_name='" + packge_name + '\'' +
                ", packge_detail='" + packge_detail + '\'' +
                ", packge_include='" + packge_include + '\'' +
                ", packge_price='" + packge_price + '\'' +
                '}';
    }
}
