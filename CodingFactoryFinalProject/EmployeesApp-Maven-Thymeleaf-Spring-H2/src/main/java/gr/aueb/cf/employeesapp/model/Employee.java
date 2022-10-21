package gr.aueb.cf.employeesapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="FIRSTNAME", length=512, nullable=false)
    private String firstname;

    @Column(name="LASTNAME", nullable=false)
    private String lastname;

    public Employee() {}

    public Employee(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
