package me.github.reportcardsmc.skriptworlds;

import com.onarandombox.MultiverseCore.MultiverseCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkriptWorlds extends JavaPlugin {


    public static MultiverseCore mvCore;
    public static SkriptWorlds instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        if (Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core") == null) {
            getLogger().severe("Multiverse is not loaded.");
            return;
        }
        mvCore = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
