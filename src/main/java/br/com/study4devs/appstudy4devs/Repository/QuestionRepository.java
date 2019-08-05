package br.com.study4devs.appstudy4devs.Repository;

import br.com.study4devs.appstudy4devs.model.Category;
import br.com.study4devs.appstudy4devs.model.Question;
import br.com.study4devs.appstudy4devs.model.Student;
import br.com.study4devs.appstudy4devs.model.StudentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q from Question q where q.category = :#{#categoryString}")
    List<Question> findByCategory(@Param("categoryString") Category categoryString);

}
