package si.assignment2.teachers.TeacherServer;

import si.assignment2.teachers.TeacherService.TeacherGrpcService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TeacherGrpcServer {
    private static final Logger logger = Logger.getLogger(TeacherGrpcService.class.getName());


    public static void main(String[] args) {
        //Starter server på angivet port
        int port = 8082;
        Server server = ServerBuilder.forPort(port) // Starts server on port 8079
                .addService(new TeacherGrpcService())
                .build();
        try {
            server.start();
            logger.log(Level.INFO, "TEACHER SERVER started on PORT: "+port);
            server.awaitTermination();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "TEACHER SERVER didn't start due to a IO Exception");
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "TEACHER SERVER startup was interrupted");
        }
    }
}