package in.Strikes.repository;

import in.Strikes.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByIdAndDeletedIsFalse(Long id);

        //we are able to give data from here to database with this method but we will not use it ok
//        Student s1 = new Student();
//        s1.setName("Nisha");
//        s1.setAge(19);
 //       return s1;
    
}
