package br.com.study4devs.appstudy4devs.Repository;

import br.com.study4devs.appstudy4devs.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
