package com.example.demo;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bukkit.BukkitPlugin;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.logging.Logger;

public class RepeatMessageExample implements Listener {

    Logger logger;

    private RepeatMessageExample(BukkitPlugin plugin) {
        logger = plugin.getLogger();
    }

    /**
     * 复读消息
     * @param e 被动收到私聊消息事件
     */
    @EventHandler
    public void onFriendMessageReceive(MiraiFriendMessageEvent e){
        logger.info("接收到好友"+e.getSenderID()+"的消息: "+e.getMessage());
        MiraiBot.getBot(e.getBotID()).getFriend(e.getSenderID()).sendMessage("你发送了一条消息："+e.getMessage());
    }

    /**
     * 复读消息
     * @param e 被动收到群聊消息事件
     */
    @EventHandler
    public void onGroupMessageReceive(MiraiGroupMessageEvent e){
        logger.info("接收到群聊"+e.getGroupID()+"的消息: "+e.getMessage());
        MiraiBot.getBot(e.getBotID()).getGroup(e.getGroupID()).sendMessageMirai("[mirai:at:"+e.getSenderID()+"] 你发送了一条消息："+e.getMessage());
    }

}
