public class NameOfWorker {
    String lastName;
    String firstName;
    String secondName;

    public NameOfWorker(String lastName, String firstName, String secondName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + secondName;
    }
}
