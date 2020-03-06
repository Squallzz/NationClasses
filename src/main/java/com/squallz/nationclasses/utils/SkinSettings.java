package com.squallz.nationclasses.utils;

public class SkinSettings {

    byte settings = 0;

    public SkinSettings() {
    }


    public void set(Key skinPart, boolean active) {
        if (active) {
            settings |= skinPart.value;
        } else {
            settings |= ~skinPart.value;
        }
    }

    public byte getSettings() {
        return settings;
    }

    public enum Key {
        CAPE((byte) 0x01),
        JACKET((byte) 0x02),
        LEFT_SLEVE((byte) 0x04),
        RIGHT_SLEVE((byte) 0x08),
        LEFT_PANTS_LEG((byte) 0x10),
        RIGHT_PANTS_LEG((byte) 0x20),
        HAT((byte) 0x40);

        public final byte value;

        Key(byte b) {
            this.value = b;
        }
    }
}

