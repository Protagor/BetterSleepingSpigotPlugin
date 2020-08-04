package to.minecraft.elitesquad.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import to.minecraft.elitesquad.listener.EventListener;

/**
 * Represents the main-class of the plugin.
 *
 * @author Protagor
 */
public class MinecraftServerPlugin extends JavaPlugin {

    /**
     * Singleton for reference to the only object of this class.
     */
    public static MinecraftServerPlugin minecraftServerPlugin;

    /**
     * Pluginmanager for registering events.
     */
    private final SimplePluginManager pluginManager = (SimplePluginManager) Bukkit.getPluginManager();

    /**
     * Instance of the Eventlistener class.
     */
    private final EventListener eventListener = new EventListener();

    @Override
    public void onEnable() {
        minecraftServerPlugin = this;

        pluginManager.registerEvents(eventListener, this);
    }
}
