package com.example.demo;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandExample extends JavaPlugin implements Listener {

    @Override // 加载插件
    public void onLoad() { }

    @Override // 启用插件
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override // 禁用插件
    public void onDisable() { }

    /**
     * 私聊消息命令示例
     * MiraiMC不提供任何命令解析器，请自行处理
     * @param e 被动收到私聊消息事件
     */
    @EventHandler
    public void onFriendMessageReceive(MiraiFriendMessageEvent e){
        if(e.getMessage().equals("在线人数")) {
            int limit = Bukkit.getServer().getOnlinePlayers().size();
            MiraiBot.getBot(e.getBotID()).getFriend(e.getSenderID()).sendMessage("当前在线人数：" + limit +"人");
        }
    }

    /**
     * 私聊消息命令示例
     * MiraiMC不提供任何命令解析器，请自行处理
     * @param e 被动收到群聊消息事件
     */
    @EventHandler
    public void onGroupMessageReceive(MiraiGroupMessageEvent e){
        if(e.getMessage().equals("在线人数")) {
            int limit = Bukkit.getServer().getOnlinePlayers().size();
            MiraiBot.getBot(e.getBotID()).getFriend(e.getSenderID()).sendMessage("当前在线人数：" + limit +"人");
        }
    }
}
