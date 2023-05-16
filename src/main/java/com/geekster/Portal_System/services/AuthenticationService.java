package com.geekster.Portal_System.services;

import com.geekster.Portal_System.models.AuthenticationToken;
import com.geekster.Portal_System.models.Student;
import com.geekster.Portal_System.repositories.IAuthenticationRepo;
import jakarta.transaction.Transactional;
import org.apache.el.parser.ELParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo tokenRepo;

    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public AuthenticationToken findTokenByStudent(Student student) {
        return tokenRepo.getByStudent(student);
    }

    @Transactional
    public void deleteTokenByStudent(Student student) {
        tokenRepo.deleteByStudent(student);
    }

    @Transactional
    public AuthenticationToken findToken(String token) {
        return tokenRepo.getByToken(token);
    }
}
