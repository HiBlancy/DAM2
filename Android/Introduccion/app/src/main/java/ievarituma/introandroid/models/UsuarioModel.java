package ievarituma.introandroid.models;

public class UsuarioModel {
    private String email;
    private String password;

    public UsuarioModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
