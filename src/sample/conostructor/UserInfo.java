package sample.conostructor;

public class UserInfo {

    private String userName;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userType;
    public UserInfo(String userName,String userPassword,String userPhone,String userEmail,String userType){
        this.userName=userName;
        this.userPassword=userPassword;
        this.userPhone=userPhone;
        this.userEmail=userEmail;
        this.userType=userType;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
