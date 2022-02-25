package com.azoraqua.minecraftdevtools;

public enum MinecraftVersion {

    R_1_17("1.17"),
    R_1_17_1("1.17.1"),
    R_1_18("1.18"),
    R_1_18_1("1.18.1");

    private final String name;

    MinecraftVersion(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
