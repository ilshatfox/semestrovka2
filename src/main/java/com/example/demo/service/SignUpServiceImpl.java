package com.example.demo.service;

import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.UserDaoImpl;
import com.example.demo.models.User;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import com.example.demo.dto.*;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserDaoImpl userDao;
//    private UsersRepository usersRepository;


    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .login(form.getLogin())
                .password(form.getPassword())
                .passwordRepeat(form.getPasswordRepeat())
                .build();

//        User user = new User(form.getLogin(), )

//         usersRepository.save(user);
        userDao.saveUser(user);
    }
}

