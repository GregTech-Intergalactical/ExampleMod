package com.example.examplemod;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.AntimatterDynamics;
import muramasa.antimatter.datagen.providers.AntimatterBlockStateProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.event.AntimatterProvidersEvent;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.cover.ICover;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Ref;

// The value here should match an entry in the META-INF/mods.toml file

public class ExampleMod extends AntimatterMod {

    public static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger.
    public static final String ID = "examplemod", NAME = "Example Mod";

    @Override
    public void onRegistrarInit() {
        super.onRegistrarInit();
        AntimatterDynamics.addProvider(ID, g -> new AntimatterBlockStateProvider(ID, NAME + " BlockStates", g));
        AntimatterDynamics.addProvider(ID, g -> new AntimatterItemModelProvider(ID, NAME + " Item Models", g));
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {
        switch (event) {
            case DATA_INIT -> {
                ExampleData.init();
                //todo until I fix antimatter
                ICover test = ICover.empty;
            }
        }
    }

    @Override
    public String getId() {
        return "example";
    }

    @Override
    public void onMaterialEvent(MaterialEvent event) {
        event.setMaterial(ExampleData.ALUMINIUM).asMetal(933, 1700);
    }
}
