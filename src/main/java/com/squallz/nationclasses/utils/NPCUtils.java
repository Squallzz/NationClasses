package com.squallz.nationclasses.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.squallz.nationclasses.ClassesMain;
import com.squallz.nationclasses.enums.ClassType;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.CraftServer;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NPCUtils {

    private Location knightNPCLocation = new Location(Bukkit.getServer().getWorld("newnations"), 20, 69, 48, (float) 90.144, (float) 3.149);

    private EntityPlayer knightNPC;

    private Map<EntityPlayer, ClassType> npcList = new HashMap<>();

    public void spawnNPCs() {
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) knightNPCLocation.getWorld()).getHandle();

        GameProfile gameProfile = new GameProfile(UUID.fromString("7ac7b66a-1ea0-4eb7-84af-3cbd0d6f5737"), ChatColor.RED + "Knight");

        knightNPC = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
        knightNPCLocation.add(0.5, 0, 0.5);
        knightNPCLocation.setYaw((float) 90.144);
        knightNPCLocation.setPitch((float) 3.149);

        for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            show(all);
        }

        knightNPC.setLocation(knightNPCLocation.getX(), knightNPCLocation.getY(), knightNPCLocation.getZ(), knightNPCLocation.getYaw(), knightNPCLocation.getPitch());

        String texture;
        String signature;

        gameProfile.getProperties().put("textures", new Property("textures", texture, signature));
    }

    public void show(Player target){
        ItemStack test = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta testMeta = test.getItemMeta();
        testMeta.setUnbreakable(true);
        testMeta.setCustomModelData(1);
        testMeta.setDisplayName(ChatColor.DARK_PURPLE + "Knight Sword");
        test.setItemMeta(testMeta);

        final PlayerConnection connection = ((CraftPlayer) target).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, knightNPC));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(knightNPC));
        connection.sendPacket(new PacketPlayOutEntityEquipment(knightNPC.getId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(test)));

        Bukkit.getScheduler().scheduleSyncDelayedTask(ClassesMain.getInstance(), new Runnable() {
            public void run(){
                connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, knightNPC));
            }
        }, 20);
    }

    public void killNPCs() {

    }

    private byte toAngle(float v) {
        return (byte) ((int) (v * 256.0F / 360.0F));
    }

    public void npcFollowPlayers() {

    }
}
