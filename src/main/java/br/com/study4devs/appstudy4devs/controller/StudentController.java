package br.com.study4devs.appstudy4devs.controller;

import br.com.study4devs.appstudy4devs.Repository.StudentRepository;
import br.com.study4devs.appstudy4devs.model.Category;
import br.com.study4devs.appstudy4devs.model.Student;
import org.hibernate.cache.spi.CacheTransactionSynchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Student s){
        if( studentRepository.findByEmail(s.getEmail()) != null){
            return new ResponseEntity<>("email já cadastrado", HttpStatus.IM_USED); //226
        }
        if( studentRepository.findByLogin(s.getLogin()) != null){
            return new ResponseEntity<>("login já cadastrado", HttpStatus.BAD_REQUEST); //400
        }
        studentRepository.save(s);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<?> findLogin(@RequestParam("username") final String login,
                             @RequestParam("password") final String password){
        Student s = new Student();
        if(studentRepository.findByLogin(login) != null){
            s = studentRepository.findByLogin(login);
            if( s.getPassword().equals(password)){
                return new ResponseEntity<>(s, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Favor verificar os campos",HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("Favor verificar os campos", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/change-categorys",method = RequestMethod.POST)
    public ResponseEntity<?> changeCategorys(@RequestBody final List<Category> jsonString,
                                             @RequestParam("studentId") final Long id){

        Student s = studentRepository.findById(id).get();
        s.changeCategory(jsonString);
        studentRepository.save(s);
        return new ResponseEntity<>(s.getCategory(), HttpStatus.OK);
    }

}
