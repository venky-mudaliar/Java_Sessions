package AbstractClasses;

//Concrete class that extends AccountType
public class StandardAccountType extends AccountType {

 // Implementing the abstract method
 @Override
 public void getAccountBenefits() {
     System.out.println("Benefits of a Standard Account: Low fees, Basic features, Limited services.");
 }
}