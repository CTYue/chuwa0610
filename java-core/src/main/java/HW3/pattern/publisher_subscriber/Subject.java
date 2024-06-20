package HW3.pattern.publisher_subscriber;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}
