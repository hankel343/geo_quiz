package com.example;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ChatServerTest {

    private WebSocketContainer container;
    private Session session;

    @Before
    public void setUp() throws Exception {
        container = ContainerProvider.getWebSocketContainer();
    }

    @Test
    public void testOnOpen() throws Exception {

    }

    @Test
    public void testOnMessage() throws Exception {
        session.getBasicRemote().sendText("Hello, world!");

    }

    @Test
    public void testOnClose() throws Exception {
        session.close();

    }

    @Test
    public void testOnError() throws Exception {

    }
}

