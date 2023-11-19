package com.arquimentor.platform.arquimentor.interfaces.rest;


import com.arquimentor.platform.arquimentor.application.internal.commandServices.StudentCommandServiceImpl;
import com.arquimentor.platform.arquimentor.application.internal.queryservices.StudentQueryServiceImpl;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByIdQuery;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.StudentResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentsController {
    private final StudentQueryServiceImpl studentQueryServiceImpl;
    private final StudentCommandServiceImpl studentCommandServiceImpl;

    public StudentsController(StudentQueryServiceImpl studentQueryServiceImpl, StudentCommandServiceImpl studentCommandServiceImpl) {
        this.studentQueryServiceImpl = studentQueryServiceImpl;
        this.studentCommandServiceImpl = studentCommandServiceImpl;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandServiceImpl.handle(createStudentCommand);
        if (studentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryServiceImpl.handle(getStudentByIdQuery);

        if (student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResource> getStudentById(@PathVariable Long studentId) {
        var student = studentQueryServiceImpl.porId(studentId);
        if (student.isEmpty()) return ResponseEntity.badRequest().build();
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }
    @GetMapping
    public ResponseEntity<List<StudentResource>> getStudents() {
        var listStudents=studentQueryServiceImpl.findAll();
        List<StudentResource> studentResources = listStudents.stream()
                .map(StudentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentResources);
    }
}
