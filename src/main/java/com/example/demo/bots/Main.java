package com.example.demo.bots;

import com.example.demo.service.WordsService;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public CommandListener cl;

    public void startBot(WordsService wordsService, TestComp testComp) throws LoginException, RateLimitedException {
        System.out.println("sdfsdg21344d");
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NzEwMDQwNzUyOTY0NjMyNjM4.XsbUGw.7PWlodLA4m6OczBp_nIRrqQUWrk";
        builder.setToken(token);
        CommandListener commandListener = new CommandListener();
        cl = commandListener;
        commandListener.wordsService = wordsService;
        commandListener.testComp = testComp;
        builder.addEventListener(commandListener);
        builder.buildAsync();
    }
}
