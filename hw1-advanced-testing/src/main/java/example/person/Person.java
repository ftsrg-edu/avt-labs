package example.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    private String homeLatitude;
    private String homeLongitude;

    protected Person() {}

    public Person(String firstName, String lastName, String homeLatitude, String homeLongitude) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeLatitude = homeLatitude;
        this.homeLongitude = homeLongitude;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeLatitude() { return homeLatitude; }

    public String getHomeLongitude() { return homeLongitude; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(homeLatitude, person.homeLatitude) &&
                Objects.equals(homeLongitude, person.homeLongitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, homeLatitude, homeLongitude);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeLatitude='" + homeLatitude + '\'' +
                ", homeLongitude='" + homeLongitude + '\'' +
                '}';
    }
}
