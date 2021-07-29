package com.ifpe.veterinario.Enums;

public enum Raca {

    PASTOR("Pastor-alemão"),
    BULDOG("Buldog"),
    POODLE("Poodle"),
    LABRADOR("Labrador");

    private String pet;

    private Raca(String pet){
        this.pet = pet;
    }

    public String getPet() {
        return pet;
    }
}
