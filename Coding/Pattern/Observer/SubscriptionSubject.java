package Pattern.Observer;
import java.util.List;
import java.util.ArrayList;

public class SubscriptionSubject implements Subject {

    private List<Observer> weixinUserList = new ArrayList<Observer>();


    public void attach(Observer observer){
        weixinUserList.add(observer);
    }
    public void detach(Observer observer){
        weixinUserList.add(observer);
    }
    public void notify(String message){
        for(Observer observer1:weixinUserList){
            observer1.update(message);
        }
    }


}
