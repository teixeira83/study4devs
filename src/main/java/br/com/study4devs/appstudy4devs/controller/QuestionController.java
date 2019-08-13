package br.com.study4devs.appstudy4devs.controller;

import br.com.study4devs.appstudy4devs.Repository.QuestionRepository;
import br.com.study4devs.appstudy4devs.Repository.StudentRepository;
import br.com.study4devs.appstudy4devs.model.Category;
import br.com.study4devs.appstudy4devs.model.Question;
import br.com.study4devs.appstudy4devs.model.QuestionDTO;
import br.com.study4devs.appstudy4devs.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    StudentRepository studentRepository;

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

    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
    public List<String> getAllCategorys(){
        List<Category> list = Arrays.asList(Category.values());
        List<String> listString = new ArrayList<String>();
        for( int i = 0; i < list.size(); i++){
            listString.add(String.valueOf(list.get(i)));
        }
        return listString;
    }

    @RequestMapping(value = "/one-question", method = RequestMethod.GET)
    public ResponseEntity<?> oneQuestion(@RequestParam("studentId") Long id){

        Student s = studentRepository.findById(id).get();
        Random random = new Random();

        //criar listas com parametros do student
        List<Category> studentCategorys = s.getCategory(); //recebe lista de category do student
        List<Question> questionsDone = s.getQuestion(); // recebe lista de questões feitas pelo student

        do{
            Collections.shuffle(studentCategorys);
            List<Question> questionList = questionRepository.findByCategory(studentCategorys.get(0)); //cria lista de questões da categoria random escolhida
            Collections.shuffle(questionList); //embaralhar lista
            if(questionsDone.size() == 0){
                QuestionDTO questionDTO = questionList.get(0).transformToDTO();
                return new ResponseEntity<QuestionDTO>(questionDTO, HttpStatus.OK);
            }

            for(int i = 0; i < questionList.size(); i++){
                if(questionsDone.contains(questionList.get(i))){
                    continue;
                }else{
                    QuestionDTO questionDTO = questionList.get(i).transformToDTO();
                    return new ResponseEntity<QuestionDTO>(questionDTO, HttpStatus.OK);
                }
            }
            studentCategorys.remove(0);
        }while (studentCategorys.size() > 0 );

        return new ResponseEntity<>("Você já respondeu todas as perguntas dos interesses selecionados.", HttpStatus.BAD_REQUEST);
    }

}
