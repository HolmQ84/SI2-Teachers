package si.assignment2.teachers.TeacherDao;

import si.assignment2.teachers.TeacherDomain.TeacherGrpcModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.NoSuchElementException;

public class TeacherGrpcDao {

    public TeacherGrpcModel findById(int teacherId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teacher-grpc");
        EntityManager em = emf.createEntityManager();
        TeacherGrpcModel teacher = em.find(TeacherGrpcModel.class, teacherId);

        if(teacher == null){
            throw new NoSuchElementException("404 - No data found with Id: "+teacherId);
        }

        return teacher;
    }
}
