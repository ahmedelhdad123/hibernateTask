package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int PatientID;

    @Column(name = "name")
    private String PatientName;

    @Column(name = "gender")
    private String Gender;

    @ManyToOne
    @JoinColumn(name = "hospitalID", referencedColumnName = "id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToMany
    @JoinTable(name = "patient_has_drug",
            joinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "id"))
    private List<Drug> drugs;
}
