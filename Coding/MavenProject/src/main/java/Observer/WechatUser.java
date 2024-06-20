package Observer;

public class WechatUser implements Observer {

    private String username;

    public WechatUser(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println(username + ": " + message);
    }
}
