package com.geekster.Portal_System.repositories;

import com.geekster.Portal_System.models.AuthenticationToken;
import com.geekster.Portal_System.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken getByStudent(Student student);

    @Modifying
    @Query(value = "DELETE FROM authentication_token WHERE student= :student",nativeQuery = true)
    void deleteByStudent(Student student);

    AuthenticationToken getByToken(String token);
}
