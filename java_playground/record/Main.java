package java_playground.record;

public class Main {
    public static void main(String[] args) {
        String firstName = "Ashish";
        String lastName = "Singh";

        Person person = new Person(firstName, lastName);
        PersonRecord person1 = new PersonRecord(firstName, lastName);

        System.out.println(person1.firstName());
        System.out.println(person1.lastName());
        System.out.println(person1.toString());
        System.out.println(person1.hashCode());
    }
}
