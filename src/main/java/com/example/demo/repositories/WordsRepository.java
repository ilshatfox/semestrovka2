package com.example.demo.repositories;

//import com.example.demo.models.User;
import com.example.demo.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WordsRepository extends JpaRepository<Word, Long> {
}

