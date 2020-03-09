package com.squallz.nationclasses;

import com.squallz.nationclasses.listeners.JoinListener;
import com.squallz.nationclasses.utils.FileUtils;
import com.squallz.nationclasses.utils.NPCUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.FileUtil;

public class ClassesMain extends JavaPlugin {

    public NPCUtils npcUtils;
    private static ClassesMain instance;
    private FileUtils fileUtils;

    public void onEnable() {
        instance = this;

        npcUtils = new NPCUtils();
        fileUtils = new FileUtils();

        fileUtils.createDefault();

        npcUtils.spawnNPCs();

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
    }

    public void onDisable() {

    }

    public static ClassesMain getInstance(){
        return instance;
    }
}
