package com.gabsthecreator.fullstackspringbootreact.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final String corsOriginPath = "*";

    @GetMapping
    @CrossOrigin(origins = corsOriginPath)
    public List<Student> getAllStudents() {
        //throw new IllegalStateException("vish");
        return studentService.getAllStudents();
    }

    @PostMapping
    @CrossOrigin(origins = corsOriginPath)
    public void addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    @CrossOrigin(origins = corsOriginPath)
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        // check if user exists later!
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    @CrossOrigin(origins = corsOriginPath)
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Gender gender
    ) {

        studentService.updateStudent(studentId, name, email, gender);

    }
}
