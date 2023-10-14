package com.example.geoquizbackend.WebSocket;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ServerEndpoint("/chat/{username}")
@Component
public class ChatServer {

    // store all usernames associated with a given session
    private static Map<Session, String> sessionUsernameMap = new Hashtable<Session, String>();

    // store all sessions a username is associated with
    private static Map<String, Session> usernameSessionMap = new Hashtable<String, Session>();

    // server side logger
    private final Logger logger =LoggerFactory.getLogger(ChatServer.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException {

        // server side log
        logger.info("[onOpen] " + username);

        // Handle duplicate usernames
        if (usernameSessionMap.containsKey(username)) {
            session.getBasicRemote().sendText("Username already exists");
            session.close();
        } else {
            // map current session with username
            sessionUsernameMap.put(session, username);

            // map current username with session
            usernameSessionMap.put(username, session);

            // send a welcome message to the joining username
            sendMessageToUser(username, "Welcome to the chat, " + username);

            // send to everyone in the chat
            sendBroadcast("User " + username + " has joined the chat.");
        }
    }

    private void sendMessageToUser(String username, String message) {
        try {
            usernameSessionMap.get(username).getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.info("[DM Exception] " + e.getMessage());
        }
    }

    private void sendBroadcast(String msg) {
        sessionUsernameMap.forEach((session, username) -> {
            try {
                session.getBasicRemote().sendText(msg);
            } catch(IOException e) {
                logger.info("[Broadcast exception] " + e.getMessage());
            }
        });
    }

}
