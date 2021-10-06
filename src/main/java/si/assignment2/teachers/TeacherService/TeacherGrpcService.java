package si.assignment2.teachers.TeacherService;

import com.teacherGrpcService.stubs.teacher.TeacherGRpcServiceGrpc;
import com.teacherGrpcService.stubs.teacher.Teacher;
import com.teacherGrpcService.stubs.teacher.TeacherID;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import si.assignment2.teachers.TeacherDao.TeacherGrpcDao;
import si.assignment2.teachers.TeacherDomain.TeacherGrpcModel;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherGrpcService extends TeacherGRpcServiceGrpc.TeacherGRpcServiceImplBase {

    private static final Logger logger = Logger.getLogger(TeacherGrpcService.class.getName());

    private TeacherGrpcDao teacherGrpcDao = new TeacherGrpcDao();

    @Override
    public void getTeacherInfo(TeacherID request, StreamObserver<Teacher> responseObserver) {
        int teacherId = (int) request.getTeacherId();

        try{
            TeacherGrpcModel teacherGrpcModel = teacherGrpcDao.findById(teacherId);


            Teacher teacherGRpcResponse = Teacher.newBuilder()
                    .setTeacherId(teacherId)
                    .setName(teacherGrpcModel.getName()) //Using Getters from target folder
                    .setAge(teacherGrpcModel.getAge()) //Using Getters from target folder
                    .setMail(teacherGrpcModel.getMail()) //Using Getters from target folder
                    .setSubject(teacherGrpcModel.getSubject()) //Using Getters from target folder
                    .build();

            //System.out.println("Student repsone object: \n"+ studentGRpcResponse);

            responseObserver.onNext(teacherGRpcResponse); // This send the data to port 8081 so bloom can fetch the data
            responseObserver.onCompleted();
        }catch (NoSuchElementException e){
            logger.log(Level.SEVERE, "NO STUDENT FOUND WITH THE STUDENT ID: "+teacherId);

            // If some error occurs with status not_found
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
    }
}