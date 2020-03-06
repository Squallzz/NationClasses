package com.squallz.nationclasses.objects;

public class CPlayer {

    private transient PlayerClass playerClass;

    public CPlayer (PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public PlayerClass getPlayerClass() {
        return this.playerClass;
    }
}
