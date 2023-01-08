package com.example.demo;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override // 加载插件
    public void onLoad() { }

    @Override // 启用插件
    public void onEnable() {
        // 注册事件
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new CommandExample(), this);
    }

    @Override // 禁用插件
    public void onDisable() { }

}
