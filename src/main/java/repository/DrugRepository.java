package repository;

import entities.Drug;
import entities.Patient;
import org.example.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrugRepository {
    Session session=null;
    public List<Drug> getAllNameOfDrugToDoctor(int doctorId)
    {
        try {
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List<Patient> patientList=session.createQuery("from Patient", Patient.class).getResultList();
            List <Drug> drugList=patientList.stream()
                    .filter(patient -> patient.getDoctor().getDoctorId()==doctorId)
                    .flatMap(patient -> patient.getDrugs().stream())
                    .collect(Collectors.toList());
            session.getTransaction().commit();
            return drugList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }

}
