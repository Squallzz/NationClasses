package com.squallz.nationclasses.managers;

import com.squallz.nationclasses.enums.ClassType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStackManager {

    public Map<ClassType, List<ItemStack>> itemStackList = new HashMap<>();

    public void addItemStack(ClassType classType, ItemStack itemStack) {
        List<ItemStack> itemStacks = itemStackList.get(classType);
        itemStacks.add(itemStack);

        itemStackList.put(classType, itemStacks);
    }

    public void removeItemStack(ClassType classType, ItemStack itemStack) {
        List<ItemStack> itemStacks = itemStackList.get(classType);
        if(itemStacks.contains(itemStack)) {
            itemStacks.remove(itemStack);
        }
    }

    public List<ItemStack> getItemStackList(ClassType classType) {
        return itemStackList.get(classType);
    }
}
