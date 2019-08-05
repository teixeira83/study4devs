package br.com.study4devs.appstudy4devs.controller;

import br.com.study4devs.appstudy4devs.Repository.QuestionRepository;
import br.com.study4devs.appstudy4devs.Repository.StudentRepository;
import br.com.study4devs.appstudy4devs.model.Category;
import br.com.study4devs.appstudy4devs.model.Question;
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
        int categoryRandom = random.nextInt( s.getCategory().size() );
        Category category = s.getCategory().get(categoryRandom);

        //return all questions about the random category
        List<Question> questionList = questionRepository.findByCategory(category);

        List<Question> questionsDone = s.getQuestion();
        int aux = 0;
        int randomQuestion;
        do{
            randomQuestion = random.nextInt( questionList.size() );
            aux = questionList.size();
            for( int v = 0; v < questionsDone.size(); v++){
                if(questionList.get(randomQuestion).equals(questionsDone.get(v))){
                    questionList.remove(randomQuestion);
                    break;
                }
            }
        }while( aux != questionList.size());



//        System.out.println(questionList.get(0).getTitle());
//        List<Student> studentList = new ArrayList<>();
//        studentList = questionList.get(0).getStudent();
//        studentList.add(s);
//        questionList.get(0).setStudent(studentList);
//        System.out.println(s.getId());
//        System.out.println(s.getQuestion());
//        System.out.println(questionList.get(0).getId());
//        System.out.println(questionList.get(0).getStudent());
//        List<Question> questList = new ArrayList<>();
//        questList = s.getQuestion();
//        questList.add(questionRepository.findById(4L).get());
//        s.setQuestion(questList);
//
//        studentRepository.save(s);
//        for( int i = 0; i < questionList.size(); i++ ){
//            Long idQuestion = questionList.get(i).getId();
//        }
        return new ResponseEntity<Question>(questionList.get(randomQuestion), HttpStatus.OK);
    }

}
