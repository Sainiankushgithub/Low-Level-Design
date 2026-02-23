interface Notification{
    void send();
}
class EmailNotification implements Notification{

    @Override
    public void send() {
        System.out.println("EMAIL");
    }
}
class SmsNotification implements Notification{

    @Override
    public void send() {
        System.out.println("SMS");
    }
}
interface NotificationFactory{
    Notification sendNotification();
}
class EmailNotificationFactory implements NotificationFactory{

    @Override
    public Notification sendNotification() {
        return new EmailNotification();
    }
}
class SmsNotificationFactory implements NotificationFactory{

    @Override
    public Notification sendNotification() {
        return new SmsNotification();
    }
}
public class FactoryMethodNotification {
    public static void main(String[] args) {
        EmailNotificationFactory emailNotificationFactory = new EmailNotificationFactory();
        Notification notification = emailNotificationFactory.sendNotification();
        notification.send();
    }
}
