public class User {

    public String login;
    public String email;

    public User() {}
    public User(String login, String email) {
        this.login = login.length() >= 5 ? login : "error";
        this.email = (email.contains("@") && email.contains(".")) ? email : "error";
    }

}
