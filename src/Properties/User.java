package Properties;

/**
 * @author Java_sabah
 */
public class User {

    private String uid, uUserName, uPassword, uFirstname, uLastname, uEmail, uAddress, status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getuUserName() {
        return uUserName;
    }

    public void setuUserName(String uUserName) {
        this.uUserName = uUserName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuFirstname() {
        return uFirstname;
    }

    public void setuFirstname(String uFirstname) {
        this.uFirstname = uFirstname;
    }

    public String getuLastname() {
        return uLastname;
    }

    public void setuLastname(String uLastname) {
        this.uLastname = uLastname;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

}
