package services;

//Concrete class for email notifications
public class EmailNotification extends NotificationServiceAbstractClass {

 private String email;

 public EmailNotification(String email, String message) {
     super(message);
     this.email = email;
 }

 @Override
 public void sendNotification() {
     System.out.println("Sending email to " + email + ": " + message);
 }
}
