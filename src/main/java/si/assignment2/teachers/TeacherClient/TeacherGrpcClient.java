package si.assignment2.teachers.TeacherClient;

import com.teacherGrpcService.stubs.teacher.Teacher;
import com.teacherGrpcService.stubs.teacher.TeacherGRpcServiceGrpc;
import com.teacherGrpcService.stubs.teacher.TeacherID;
import io.grpc.Channel;

import java.util.ArrayList;
import java.util.List;

public class TeacherGrpcClient {
    private TeacherGRpcServiceGrpc.TeacherGRpcServiceBlockingStub teacherGRpcServiceBlockingStub;

    public TeacherGrpcClient(Channel channel) {
        teacherGRpcServiceBlockingStub = TeacherGRpcServiceGrpc.newBlockingStub(channel);
    }

    public List<String> getResults(long teacherId) {
        TeacherID id = TeacherID.newBuilder().setTeacherId(teacherId).build();
        System.out.println("Teacher ID: "+id);
        Teacher teacher = teacherGRpcServiceBlockingStub.getTeacherInfo(id);

        List<String> results = new ArrayList<>();

        results.add(teacher.getName());
        results.add(Integer.toString(teacher.getAge()));
        results.add(teacher.getMail());
        results.add(teacher.getSubject());

        return results;
    }
}
