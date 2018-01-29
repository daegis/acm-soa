package cn.aegisa.acm.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Enumeration;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Using IntelliJ IDEA.
 *
 * @author HNAyd.xian
 * @date 2018/1/29 23:10
 */
@ServerEndpoint("/socket/{userId}")
@Controller
@Slf4j
public class TestWebSocket {

    private static int onlineCount = 0;
    public static ConcurrentHashMap<String, Session> mapUS = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Session, String> mapSU = new ConcurrentHashMap<>();

    /**
     * 连接成功调用本方法
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        mapUS.put(userId, session);
        mapSU.put(session, userId);
        //上线通知由客户端自主发起
        onlineCount++;
        System.out.println("用户id" + userId + "进入webSocket！当前在线人数为" + onlineCount);
    }

    /**
     * 连接关闭调用本方法
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        String userId = mapSU.get(session);
        if (userId != null && !Objects.equals(userId, "")) {
            //下线通知
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", 3);
            jsonObject.put("userId", userId);
            jsonObject.put("contentType", "offline");
            jsonObject.put("to", "all");
            String jsonString = jsonObject.toString();
            for (Session s : session.getOpenSessions()) {//循环发给所有在线的人
                s.getAsyncRemote().sendText(jsonString);
            }
            onlineCount--;
            System.out.println("用户id" + userId + "退出webSocket！当前在线人数为" + onlineCount);
            mapUS.remove(userId);
            mapSU.remove(session);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:" + message);
        String userId = mapSU.get(session);
//        JSONObject jsonObject = JSON.parseObject(message);
//        String to = jsonObject.getString("to");
//        jsonObject.remove("to");
//        LocalDateTime now = LocalDateTime.now();
//        String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        jsonObject.put("time", time);
//        Session session_to = mapUS.get(to);
//        if (session_to != null) {
//            session_to.getAsyncRemote().sendText(jsonObject.toString());
//            //System.out.println("发给"+to+"："+jsonObject.toString());
//        }
        Enumeration<Session> keys = mapSU.keys();
        while (keys.hasMoreElements()) {
            Session nextSession = keys.nextElement();
            nextSession.getAsyncRemote().sendText(userId + "说:" + message);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        String userId = mapSU.get(session);
        System.out.println(userId + "异常断开连接");
        error.printStackTrace();
    }
}
