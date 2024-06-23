
class Publisher {
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();
    public void subscribe(String topic, Subscriber subscriber) {
        List<Subscriber> subscriberList = subscribers.get(topic);
        if (subscriberList == null) {
            subscriberList = new ArrayList<>();
            subscribers.put(topic, subscriberList);
        }
        subscriberList.add(subscriber);
    }
 
    public void unsubscribe(String topic, Subscriber subscriber) {
        List<Subscriber> subscriberList = subscribers.get(topic);
        if (subscriberList != null) {
            subscriberList.remove(subscriber);
        }
    }
 
    public void publish(String topic, String message) {
        List<Subscriber> subscriberList = subscribers.get(topic);
        if (subscriberList != null) {
            for (Subscriber subscriber : subscriberList) {
                subscriber.update(message);
            }
        }
    }
}