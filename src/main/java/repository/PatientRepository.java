package repository;



import org.hibernate.Session;
import entities.Patient;
import org.example.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepository {
    Session session=null;

    public List<Patient> getAllPatientNameForDoctor(int doctorId)
    {
        try {
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            // Use HQL to retrieve patients associated with the specified doctor
//            String link="SELECT p FROM Patient p"+
//                    "WHERE p.doctor.doctorId = : doctorId";
//            List<Patient>patients=session.createQuery(link, Patient.class)
//                    .setParameter("doctorId",doctorId)
//                    .getResultList();

            List<Patient> patientList=session.createQuery("from Patient",Patient.class).getResultList();
            patientList=patientList
                    .stream()
                    .filter(patient -> patient.getDoctor().getDoctorId()==doctorId)
                    .collect(Collectors.toList());
            session.getTransaction().commit();
            return patientList;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return new ArrayList<Patient>();
    }
}
