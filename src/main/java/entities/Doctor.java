package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name="doctor")
@Data
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int doctorId;

   @Column(name = "name")
   private String doctorName;


   @ManyToOne
    @JoinColumn(name = "hospitalID",referencedColumnName = "id")
    private Hospital hospital;



}
