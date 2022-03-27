package top.shellwe.bip.system.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.shellwe.bip.system.entity.User;
import top.shellwe.bip.system.mapper.UserMapper;
import top.shellwe.bip.util.ApplicationContextUtil;
import top.shellwe.bip.util.MessageDisplay;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Web socket server controller.
 */
@Slf4j
@Component
@ServerEndpoint("/chatting/{sid}/{userId}")
public class WebSocketServerController {

    /**
     * 房间号 - 组成员信息
     */
    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();
    /**
     * 房间号 - 在线人数
     */
    private static ConcurrentHashMap<String, Set<Integer>> onlineUserMap = new ConcurrentHashMap<>();

    /**
     * 收到消息调用的方法，群成员发送消息
     *
     * @param sid     :房间号
     * @param id      ：用户id
     * @param message ：发送消息
     */
    @OnMessage
    public void onMessage(@PathParam("sid") String sid, @PathParam("userId") int id, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        Set<Integer> onlineUserList = onlineUserMap.get(sid);
        // 先一个群组内的成员发送消息
        sessionList.forEach(item -> {
            try {
                // json字符串转对象
                MessageDisplay md = JSONObject.parseObject(message, MessageDisplay.class);
                md.setCount(onlineUserList.size());
                // json对象转字符串
                String text = JSONObject.toJSONString(md);
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session the session
     * @param sid     the sid
     * @param userId  the user id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid, @PathParam("id") Integer userId) {
        List<Session> sessionList = groupMemberInfoMap.computeIfAbsent(sid, k -> new ArrayList<>());
        Set<Integer> onlineUserList = onlineUserMap.computeIfAbsent(sid, k -> new HashSet<>());
        onlineUserList.add(userId);
        sessionList.add(session);
        // 发送上线通知
        sendInfo(sid, userId, onlineUserList.size(), "已登录");
    }


    /**
     * Send info.
     *
     * @param sid       the sid
     * @param id        the id
     * @param onlineSum the online sum
     * @param info      the info
     */
    public void sendInfo(String sid, int id, Integer onlineSum, String info) {
        // 获取该连接用户信息
        User user = ApplicationContextUtil.getApplicationContext().getBean(UserMapper.class).selectById(id);
        // 发送通知
        MessageDisplay md = new MessageDisplay();
        md.setCount(onlineSum);
        md.setUserId(id);
        md.setAvatar(user.getAvatarID());
        md.setMsg(user.getUserName() + info);
        // json对象转字符串
        String text = JSONObject.toJSONString(md);
        onMessage(sid, id, text);
    }

    /**
     * 关闭连接调用的方法，群成员退出
     *
     * @param session the session
     * @param sid     the sid
     * @param userId  the user id
     */
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid, @PathParam("id") Integer userId) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        sessionList.remove(session);
        Set<Integer> onlineUserList = onlineUserMap.get(sid);
        onlineUserList.remove(userId);
        // 发送离线通知
        sendInfo(sid, userId, onlineUserList.size(), "已登出");
    }

    /**
     * 传输消息错误调用的方法
     *
     * @param error the error
     */
    @OnError
    public void OnError(Throwable error) {
        log.info("Connection error");
    }

}
