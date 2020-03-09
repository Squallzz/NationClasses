package com.squallz.nationclasses.utils;

import com.squallz.nationclasses.ClassesMain;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    ClassesMain instance = ClassesMain.getInstance();

    File itemsFile = new File(instance.getDataFolder(), "items.yml");
    FileConfiguration itemsConfig = YamlConfiguration.loadConfiguration(itemsFile);

    public void saveItemStacks() {

    }

    public void loadItemStacks(){

    }

    public void createDefault() {
        ItemStack knightSword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta knightSwordMeta = knightSword.getItemMeta();
        knightSwordMeta.setCustomModelData(1);
        knightSwordMeta.setDisplayName(ChatColor.DARK_PURPLE + "Knight Sword");
        List<String> knightSwordLore = new ArrayList<>();
        knightSwordLore.add("");
        knightSwordLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Forged with the blood of the Knight's");
        knightSwordLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "enemies...");
        knightSwordMeta.setLore(knightSwordLore);
        knightSword.setItemMeta(knightSwordMeta);

        itemsConfig.set("knight.items.mainhand", knightSword);

        try {
            itemsConfig.save(itemsFile);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
