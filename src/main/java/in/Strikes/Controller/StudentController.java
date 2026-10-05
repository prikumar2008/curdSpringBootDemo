package in.Strikes.Controller;

import in.Strikes.Service.StudentService;
import in.Strikes.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent); //we can use it for changing status code if we do not remember code number
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam long id) {
        Student studentResp = studentService.getStudent(id);
        return ResponseEntity.ok(studentResp);

    }
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam long id , @RequestBody Student student) {
        Student studentResp = studentService.updateStudent(id , student);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam long id , @RequestBody Student student) {
        Boolean isdeleted = studentService.deleteStudent(id);
        if(!isdeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }
    @PatchMapping("/delete-soft")//yaha pe hume id na deni pade uske liya hum pathvariable ki jagah requestparam use karenge ok
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam long id ) {
        Boolean isDeleted =  studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Student>> getAllStudents() {
//        List<Student> studentList = studentService.getAllStudent();
//        if(studentList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(studentList);
//}

}
        //  return  createdStudent;
       // return ResponseEntity.status(201).body(createdStudent);//when we have remember the code number ok

//        System.out.println(student.getName());
//        System.out.println(student.getEmail());

