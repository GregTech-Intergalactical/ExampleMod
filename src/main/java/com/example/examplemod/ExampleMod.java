package com.example.examplemod;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.AntimatterMod;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.ID)
public class ExampleMod extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "examplemod", NAME = "Example Mod";

    public ExampleMod() {
        AntimatterAPI.addProvider(ID, g -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates", g));
        AntimatterAPI.addProvider(ID, g -> new AntimatterItemModelProvider(ID, NAME + " Item Models", g));
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event) {
        switch (event) {
            case DATA_INIT:
                ExampleData.init();
                break;
        }
    }
}
