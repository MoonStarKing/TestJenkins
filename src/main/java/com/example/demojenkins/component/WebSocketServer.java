package com.example.demojenkins.component;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
@ServerEndpoint("call/{uid}")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) throws IOException {
        session.getBasicRemote().sendText("你嘎哈呢" + uid);
    }
}
