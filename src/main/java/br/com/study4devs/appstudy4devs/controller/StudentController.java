package br.com.study4devs.appstudy4devs.controller;

import br.com.study4devs.appstudy4devs.Repository.QuestionRepository;
import br.com.study4devs.appstudy4devs.Repository.StudentRepository;
import br.com.study4devs.appstudy4devs.model.Category;
import br.com.study4devs.appstudy4devs.model.Question;
import br.com.study4devs.appstudy4devs.model.Student;
import br.com.study4devs.appstudy4devs.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    QuestionRepository questionRepository;

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
                return new ResponseEntity<>(s.transformToDTO(), HttpStatus.OK);
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

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public ResponseEntity<?> addAnswer(@RequestParam("studentId") final Long studentId,
                                       @RequestParam("questionId") final Long questionId,
                                       @RequestParam("answer") int answer){


        Student s = studentRepository.findById(studentId).get();
        Question q = questionRepository.findById(questionId).get();

        s.increaseAnswered();
        studentRepository.save(s);
        if( q.getRightAnswer() == answer){
            s.increaseRightAnswered();
            s.increasePoints();
            List<Question> questions = new ArrayList<>();
            questions = s.getQuestion();
            questions.add(q);
            s.setQuestion(questions);
            studentRepository.save(s);
            return new ResponseEntity<>("Resposta Correta", HttpStatus.OK);
        }

        return new ResponseEntity<>("Resposta Errada", HttpStatus.EXPECTATION_FAILED);
    }


    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<?> refreshStudent(@RequestParam("studentId") Long id){
        Student s = studentRepository.findById(id).get();
        StudentDTO sDTO = s.transformToDTO();
        return new ResponseEntity<>(sDTO, HttpStatus.OK);
    }

}
