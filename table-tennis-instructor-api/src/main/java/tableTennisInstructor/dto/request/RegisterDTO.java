package tableTennisInstructor.dto.request;

import tableTennisInstructor.model.User;

import javax.validation.constraints.NotNull;

public class RegisterDTO {

    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Surname is required")
    private String surname;
    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String password;

    public RegisterDTO(){super();}

    public RegisterDTO(@NotNull(message = "Name is required") String name, @NotNull(message = "Surname is required") String surname, @NotNull(message = "Email is required") String email, @NotNull(message = "Username is required") String username, @NotNull(message = "Password is required") String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User mapToUser() {
        User user = new User();
        user.setPassword(this.getPassword());
        user.setEmail(this.getEmail());
        user.setFirstName(this.getName());
        user.setLastName(this.getSurname());
        user.setUsername(this.getUsername());
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
