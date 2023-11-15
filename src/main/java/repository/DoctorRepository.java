package repository;


import org.example.HibernateUtil;
import entities.Doctor;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class DoctorRepository {
    Session session = null;
    public List<String> getAllDoctorsName(){
        try {
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List<Doctor> doctorList=session.createQuery("FROM Doctor").getResultList();
            List<String> doctorName=doctorList.stream().map(Doctor::getDoctorName).toList();
            session.getTransaction().commit();
            return doctorName;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return Collections.emptyList();
    }
    public List<Doctor> getDoctorsInHospitals(int hospitalId) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List<Doctor> doctors = (List<Doctor>) session.createQuery("From Doctor").getResultList();
            doctors = doctors.stream().filter(doctor -> doctor.getHospital()
                    .getHospitalID() == hospitalId).collect(Collectors.toList());
            session.getTransaction().commit();
            session.close();
            return doctors;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return Collections.emptyList();
    }

}
