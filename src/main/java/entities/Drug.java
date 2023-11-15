package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "drug")
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int DrugID;

    @Column(name = "name")
    private String DrugName;

    @Column(name = "description")
    private String Description;

    @ManyToMany
    @JoinTable(name = "patient_has_drug",
            joinColumns = @JoinColumn(name = "DrugID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PatientID", referencedColumnName = "id"))
    private List<Patient> patients;

}
