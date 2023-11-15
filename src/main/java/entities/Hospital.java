package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hospital")
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hospitalID;

    @Column(name = "name")
    private String hospitalName;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor>doctors;

    @OneToMany(mappedBy = "hospital")
    private List<Patient>patients;
}
