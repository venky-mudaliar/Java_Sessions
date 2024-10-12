package services;

//Abstract class representing a notification service
public abstract class NotificationServiceAbstractClass {
 protected String message;

 public NotificationServiceAbstractClass(String message) {
     this.message = message;
 }

 // Abstract method to send notifications
 public abstract void sendNotification();
}
