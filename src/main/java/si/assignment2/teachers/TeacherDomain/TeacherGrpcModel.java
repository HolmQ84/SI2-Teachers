package si.assignment2.teachers.TeacherDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TeacherGrpcModel {

    @Id
    private Long teacherId;
    private String name;
    private int age;
    private String mail;
    private String subject;
}
