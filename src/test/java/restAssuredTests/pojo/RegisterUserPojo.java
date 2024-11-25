package restAssuredTests.pojo;

public class RegisterUserPojo {
    private String email;
    private String password;

    public RegisterUserPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}