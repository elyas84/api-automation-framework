package modules;


public class User {

    /**
     * {
     * "id": 1,
     * "email": "george.bluth@reqres.in",
     * "first_name": "George",
     * "last_name": "Bluth",
     * "avatar": "https://reqres.in/img/faces/1-image.jpg"
     * },
     */
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public User() {

    }
}


