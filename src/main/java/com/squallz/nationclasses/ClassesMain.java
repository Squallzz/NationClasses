package com.squallz.nationclasses;

import com.squallz.nationclasses.listeners.JoinListener;
import com.squallz.nationclasses.utils.NPCUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ClassesMain extends JavaPlugin {

    public NPCUtils npcUtils;
    private static ClassesMain instance;

    public void onEnable() {
        npcUtils = new NPCUtils();
        instance = this;

        npcUtils.spawnNPCs();

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
    }

    public void onDisable() {

    }

    public static ClassesMain getInstance(){
        return instance;
    }
}
