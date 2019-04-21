package me.sargunvohra.mcmods.autoconfig.example;

import me.sargunvohra.mcmods.autoconfig.api.AutoConfig;
import me.sargunvohra.mcmods.autoconfig.api.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class ExampleInit implements ModInitializer {
    static final String CONFIG = "autoconfig_example";

    @Override
    public void onInitialize() {
        AutoConfig.register(CONFIG, ExampleConfig.class, JanksonConfigSerializer::new);

        //noinspection unused
        ExampleConfig config = AutoConfig.<ExampleConfig>getConfigHolder(CONFIG).getConfig();
    }
}