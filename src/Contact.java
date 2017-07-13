/**
 * Created by emma on 7/12/17.
 */
public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
    }

    public Contact() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printDetails() {

        System.out.println(getFirstName() + " " + getLastName() + ": ");
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email Address: " + getEmailAddress());
        System.out.println();

    }

    public String detailsToString() {

        return getFirstName() + "\t" + getLastName() + "\t" + getPhoneNumber() + "\t" + getEmailAddress();

    }

    public String reverseName() {

        return getLastName() + " " + getFirstName();

    }

    public String fullName() {
        return getFirstName() + " " + getLastName();
    }

}
