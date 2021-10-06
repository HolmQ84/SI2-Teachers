package si.assignment2.teachers;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.assignment2.teachers.TeacherClient.TeacherGrpcClient;

@SpringBootApplication
public class TeachersApplication {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8082")
                .usePlaintext()
                .build();
        TeacherGrpcClient teacherGrpcClient = new TeacherGrpcClient(channel);
        System.out.println(teacherGrpcClient.getResults(0).get(1));
    }

}
