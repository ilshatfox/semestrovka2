package com.example.demo.bots;

import com.example.demo.service.WordsService;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;


@Component
public class TestComp {

    @Autowired
    public WordsService wordsService;

    public Main main1;
    public ChatServer chatServer;

    @EventListener
    public void testRun(ContextRefreshedEvent cre) {
        System.out.println("ffff12341123");
        try {
            Main obj = new Main();
            main1 = obj;
            obj.startBot(wordsService, this);
        } catch (LoginException | RateLimitedException e) {
            e.printStackTrace();
        }
    }

    @EventListener
    public void testRun2(ContextRefreshedEvent cre) {
        System.out.println("ffff12341123");
        ChatServer obj = new ChatServer();
        chatServer = obj;
        ChatServer.wordsService = wordsService;
        ChatServer.testComp = this;
        System.out.println("sdfgewr214we");
        obj.startBot();
    }

}