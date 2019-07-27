package br.com.study4devs.appstudy4devs.controller;

import br.com.study4devs.appstudy4devs.Repository.QuestionRepository;
import br.com.study4devs.appstudy4devs.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @RequestMapping(value = "/all-questions", method = RequestMethod.GET)
    public List<Question> showAll(){
        return questionRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@RequestParam("code") Long id) {
        Optional<Question> q = questionRepository.findById(id);
        if(q.isPresent()){
            return new ResponseEntity<>(q, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Questão não encontrada", HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Question> add(@RequestBody Question q){
        questionRepository.save(q);
        return new ResponseEntity<>(q, HttpStatus.CREATED);
    }

}
