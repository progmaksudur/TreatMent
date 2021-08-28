package sample.conostructor;

public class IteamCartList {
    private String iteam_name;
    private String iteam_details;
    private String iteam_include;
    private String iteam_cost;

    public IteamCartList(String iteam_name, String iteam_details, String iteam_include, String iteam_cost) {
        this.iteam_name = iteam_name;
        this.iteam_details = iteam_details;
        this.iteam_include = iteam_include;
        this.iteam_cost = iteam_cost;
    }

    public IteamCartList() {
    }

    public String getIteam_name() {
        return iteam_name;
    }

    public void setIteam_name(String iteam_name) {
        this.iteam_name = iteam_name;
    }

    public String getIteam_details() {
        return iteam_details;
    }

    public void setIteam_details(String iteam_details) {
        this.iteam_details = iteam_details;
    }

    public String getIteam_include() {
        return iteam_include;
    }

    public void setIteam_include(String iteam_include) {
        this.iteam_include = iteam_include;
    }

    public String getIteam_cost() {
        return iteam_cost;
    }

    public void setIteam_cost(String iteam_cost) {
        this.iteam_cost = iteam_cost;
    }

    @Override
    public String toString() {
        return "IteamCartList{" +
                "iteam_name='" + iteam_name + '\'' +
                ", iteam_details='" + iteam_details + '\'' +
                ", iteam_include='" + iteam_include + '\'' +
                ", iteam_cost='" + iteam_cost + '\'' +
                '}';
    }
}
