package Observer;

public class Client {
    public static void main(String[] args) {

        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WechatUser("user1"));
        subject.attach(new WechatUser("user2"));
        subject.attach(new WechatUser("user3"));

        subject.notify("There's an update!");
    }
}
