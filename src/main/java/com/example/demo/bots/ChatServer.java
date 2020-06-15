package com.example.demo.bots;

import com.example.demo.service.Status;
import com.example.demo.service.WordsService;
import org.glassfish.tyrus.server.Server;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ServerEndpoint(value = "/chat")
public class ChatServer {

    public static WordsService wordsService;
    public static TestComp testComp;
    private static List<Session> sessions = new ArrayList<>();

    public static void main(String[] args, WordsService ws) {
        wordsService = ws;
        ChatServer server = new ChatServer();
    }

    public ChatServer() {
    }

    public void startBot() {
        Server server = new Server("127.0.0.1", 8080, "", null, this.getClass());

        try {
            server.start();
            new Scanner(System.in).nextLine();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            server.stop();
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        sessions.remove(session);
        System.out.println("A Client " + session.getId() + " disconnected with reason " + closeReason.getReasonPhrase() + ", code " + closeReason.getCloseCode().getCode() + ".");
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Got new connection: " + session.getId());
        try {
            sessions.add(session);
            System.out.println("sessions: " + sessions.size());
            session.getBasicRemote().sendText("Hi! You session id is " + session.getId() + ", protocol version is " + session.getProtocolVersion() + ".");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("An error occured: " + session.getId() + " - " + throwable.getMessage());
    }

    @OnMessage
    public String onMessage(String message, Session session) throws IOException {
        System.out.println("message " + message);
        Status status = wordsService.addWord(message);
        System.out.println(status.getMessage());
        if (status.status) {
            for (int i = 0; i < sessions.size(); i++) {
                if (sessions.get(i) != session) {
                    sessions.get(i).getBasicRemote().sendText(status.getAllMessage());
                }
            }
            try {
                testComp.main1.cl.notifyAll(status.getAllMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status.getMessage();
    }

    public void notifyAll(String mess) throws IOException {
        System.out.println("sessions: " + sessions.size());
        for (int i = 0; i < sessions.size(); i++) {
            sessions.get(i).getBasicRemote().sendText(mess);
        }
    }
}
