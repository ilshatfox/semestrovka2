package com.example.demo.dto;

import com.example.demo.models.Logs;
import com.example.demo.validator.MyAnnot;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Repository
public class LogsImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @MyAnnot
    @Transactional
    public Logs saveLogs(Logs user){
        entityManager.persist(user);
//        System.out.println(1/0);
        entityManager.flush();
        return user;
    }



    public Logs findLogs(Long id){
        return (Logs) entityManager.find(Logs.class, id);
    }

    public void deleteLogs(Logs user){
        entityManager.remove(user);
    }

    public void updateLogs(Logs user){
        entityManager.merge(user);
    }
}
