package me.github.reportcardsmc.skriptworlds;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class SkriptWorlds extends JavaPlugin {


    public static MultiverseCore mvCore;
    public static SkriptWorlds instance;
    public static SkriptAddon addon;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        if (Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core") == null) {
            getLogger().severe("Multiverse is not loaded.");
            return;
        }
        mvCore = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        getLogger().info("MV-Core found and loaded, enabling Skript Addon");
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("me.github.reportcardsmc.skriptworlds", "skript");
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLogger().info("Addon has been enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
