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

    @OnMessage
    public void onMessage(Session session, String msg) throws IOException {

        // retrieve username by session
        String username = sessionUsernameMap.get(session);

        // server side log
        logger.info("[onMessage] " + username + ": " + msg);

        // send messages to user using format "@username <msg>"
        if (msg.startsWith("@")) {

            // split by space
            String[] split_msg = msg.split("\\s+");

            // combine the rest of the msg
            StringBuilder actualMessageBuilder = new StringBuilder();
            for (int i = 1; i < split_msg.length; i++) {
                actualMessageBuilder.append(split_msg[i]).append(" ");
            }

            String destUserName = split_msg[0].substring(1);
            String actualMessage = actualMessageBuilder.toString();
            sendMessageToUser(destUserName, "[DM from " + username + "]: " + actualMessage);
            sendMessageToUser(username, "[DM from " + username + "]: " + actualMessage);
        } else {    // broadcast message
            sendBroadcast(username + ": " + msg);
        }
    }


    @OnClose
    public void onClose(Session session) throws IOException {
        // get the username from session-username mapping
        String username = sessionUsernameMap.get(session);

        // server side log
        logger.info("[OnClose] " + username);

        // remove user from maps
        sessionUsernameMap.remove(session);
        usernameSessionMap.remove(username);

        // send a message to the chat
        sendBroadcast(username + " disconnected");
    }

    @OnError
    public void OnError(Session session, Throwable throwable) {
        // get the username from the session-username mapping
        String username = sessionUsernameMap.get(session);

        logger.info("[OnError]" + username + ": " + throwable.getMessage());
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
