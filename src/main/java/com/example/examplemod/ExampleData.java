package com.example.examplemod;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.material.Element;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.TextureSet;

public class ExampleData {

    public static TextureSet SET_DULL = new TextureSet(ExampleMod.ID, "dull");

    public static Material ALUMINIUM = AntimatterAPI.register(Material.class, new Material(ExampleMod.ID, "aluminium", 0x80c8f0, SET_DULL, Element.Al).asMetal(933, 1700));

    public static ItemBasic<?> IRIDIUM_ALLOY_INGOT = new ItemBasic<>(ExampleMod.ID, "iridium_alloy_ingot");

    public static void init() {

    }
}
