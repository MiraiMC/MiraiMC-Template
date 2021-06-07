package com.example.demo;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.listener.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.listener.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

    private MiraiBot mirai;

    @Override // 加载插件
    public void onLoad() { }

    @Override // 启用插件
    public void onEnable() {
        this.mirai=new MiraiBot();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override // 禁用插件
    public void onDisable() { }

    @EventHandler
    public void onFriendMessageReceive(MiraiFriendMessageEvent e){
        getLogger().info("接收到好友"+e.getSenderID()+"的消息: "+e.getMessage());
        mirai.sendFriendMessage(e.getBotID(),e.getSenderID(),"你发送了一条消息："+e.getMessage());
    }

    @EventHandler
    public void onGroupMessageReceive(MiraiGroupMessageEvent e){
        getLogger().info("接收到群聊"+e.getGroupID()+"的消息: "+e.getMessage());
        mirai.sendFriendMessage(e.getBotID(),e.getSenderID(),mirai.at(e.getSenderID())+" 你发送了一条消息："+e.getMessage());
    }


}
