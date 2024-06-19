package Publisher_subscriber;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪无能"));
        subject.attach(new WeiXinUser("沙悟净"));
        subject.notify("传智黑马的专栏更新了！");
    }
}