package Pattern.Observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WeiXinUser("tom"));
        subject.attach(new WeiXinUser("cat"));
        subject.attach(new WeiXinUser("dog"));

        subject.notify("new update");
    }
}
