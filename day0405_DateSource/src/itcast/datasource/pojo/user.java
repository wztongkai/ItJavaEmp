package itcast.datasource.pojo;

public class user {
    private Integer id;
    private String username;
    private String passsword;

    public user() {
    }

    public user(Integer id, String username, String passsword) {
        this.id = id;
        this.username = username;
        this.passsword = passsword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passsword='" + passsword + '\'' +
                '}';
    }
}
