package po;

/**
 * Created by Vigo on 16/3/30.
 */
public class User {

    private String user_name;
    private int user_id;
    private String email;
    private String password;

    public User(String user_name, int user_id, String email, String password) {
        this.user_name = user_name;
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [user_name=" + user_name + ", user_id=" + user_id
                + ", password=" + password + ", email=" + email + "]";
    }

}