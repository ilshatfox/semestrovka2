package com.example.demo.service;

import com.example.demo.dto.LogsDto;
import com.example.demo.dto.LogsImpl;
import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.UserDaoImpl;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import com.example.demo.dto.*;

@Component
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsImpl userDao;
//    private UsersRepository usersRepository;


    @Override
    public void signUp(LogsDto form) {

//        User user = new User(form.getLogin(), )

//         usersRepository.save(user);
//        userDao.saveLogs(user);
    }
}

