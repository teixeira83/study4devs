package br.com.study4devs.appstudy4devs.Repository;

import br.com.study4devs.appstudy4devs.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
    Student findByLogin(String login);
}
