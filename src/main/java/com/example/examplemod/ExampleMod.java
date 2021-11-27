package com.example.examplemod;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.event.AntimatterProvidersEvent;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.AntimatterMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.ID)
public class ExampleMod extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "examplemod", NAME = "Example Mod";

    public ExampleMod() {
        AntimatterDynamics.addProvider(ID, g -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates", g));
        AntimatterDynamics.addProvider(ID, g -> new AntimatterItemModelProvider(ID, NAME + " Item Models", g));
    }
    
    @Override
    public void onRegistrationEvent(RegistrationEvent event, Dist side) {
        switch (event) {
            case DATA_INIT:
                ExampleData.init();
                break;
        }        
    }

    @Override
    public String getId() {
        return "example";
    }
}
