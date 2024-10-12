package services;

//Concrete class for SMS notifications
public class SMSNotification extends NotificationServiceAbstractClass {

 private String phoneNumber;

 public SMSNotification(String phoneNumber, String message) {
     super(message);
     this.phoneNumber = phoneNumber;
 }

 @Override
 public void sendNotification() {
     System.out.println("Sending SMS to " + phoneNumber + ": " + message);
 }
}

