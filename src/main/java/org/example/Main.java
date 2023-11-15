package org.example;

import entities.Doctor;
import entities.Drug;
import entities.Patient;
import repository.DoctorRepository;
import repository.DrugRepository;
import repository.PatientRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /////////////////////////////// Doctor///////////////////
        DoctorRepository doctorRepository = new DoctorRepository();
        List<String> doctors = doctorRepository.getAllDoctorsName();
        for (String doctor : doctors){
            System.out.println(doctor);
        }

        List<Doctor> doctors1=doctorRepository.getDoctorsInHospitals(2);
        for (var doctor:doctors1)
        {
            System.out.println(doctor.getDoctorName());
        }
        ////////////////////////////Patient///////////////////////////////////////////////
        PatientRepository patientRepository=new PatientRepository();
        List<Patient> patients=patientRepository.getAllPatientNameForDoctor(1);
        for (var patient : patients)
        {
            System.out.println(patient.getPatientName());
        }

        //////////////////////////////Drug///////////////////////////////////////////////////

        DrugRepository drugRepository=new DrugRepository();
        List<Drug> drugs=drugRepository.getAllNameOfDrugToDoctor(1);
        for (var drug : drugs)
        {
            System.out.println(drug.getDrugName());
        }
    }
}