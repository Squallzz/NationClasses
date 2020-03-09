package com.squallz.nationclasses.objects;

import com.squallz.nationclasses.ClassesMain;
import com.squallz.nationclasses.enums.ClassType;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NPC {

    private String npcName;
    private ClassType npcClassType;
    private String npcSkinTexture;
    private String npcSkinSignature;
    private Location npcLocation;
    private EntityPlayer npc;
    private ItemStack mainhandItem;
    private ItemStack offhandItem;
    private ItemStack helmetItem;
    private ItemStack chestItem;
    private ItemStack legItem;
    private ItemStack shoeItem;

    public NPC (String npcName, ClassType npcClassType, String npcSkinTexture, String npcSkinSignature, Location npcLocation, EntityPlayer npc) {
        this.npcName = npcName;
        this.npcClassType = npcClassType;
        this.npcSkinTexture = npcSkinTexture;
        this.npcSkinSignature = npcSkinSignature;
        this.npcLocation = npcLocation;
        this.npc = npc;
    }

    public String getName() {
        return npcName;
    }

    public ClassType getClassType() {
        return npcClassType;
    }

    public String getSkinTexture(){
        return npcSkinTexture;
    }

    public String getSkinSignature() {
        return npcSkinSignature;
    }

    public Location getNPCLocation(){
        return npcLocation;
    }

    public EntityPlayer getNPC(){
        return npc;
    }

    public void show(Player player) {
        final PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        // connection.sendPacket(new PacketPlayOutEntityEquipment(npc.getId(), EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(test)));

        Bukkit.getScheduler().scheduleSyncDelayedTask(ClassesMain.getInstance(), new Runnable() {
            public void run(){
                connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
            }
        }, 20);
    }

    public void hide(Player player) {
        final PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutEntityDestroy(npc.getId()));
    }
}
