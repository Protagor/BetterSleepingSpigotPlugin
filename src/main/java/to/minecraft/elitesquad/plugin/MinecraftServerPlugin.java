package to.minecraft.elitesquad.plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import to.minecraft.elitesquad.listener.EventListener;

public class MinecraftServerPlugin extends JavaPlugin {

    public static MinecraftServerPlugin minecraftServerPlugin;

    private SimplePluginManager pluginManager = (SimplePluginManager) Bukkit.getPluginManager();

    private EventListener eventListener = new EventListener();

    @Override
    public void onEnable() {
        minecraftServerPlugin = this;

        pluginManager.registerEvents(eventListener, this);
    }
}
