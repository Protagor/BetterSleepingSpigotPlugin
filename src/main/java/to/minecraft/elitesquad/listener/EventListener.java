package to.minecraft.elitesquad.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import to.minecraft.elitesquad.plugin.MinecraftServerPlugin;

/**
 * Handles all events that have to be handled in this plugin.
 *
 * @author Protagor
 */
public class EventListener implements Listener {

    /**
     * Time in seconds the player has to stay in the bed so it gets day.
     */
    private final long secondsToFallAsleep = 5;

    /**
     *
     * @param event Method is invoked when 'PlayerBedEnterEvent' is triggered.
     */
    @EventHandler
    public void goToBed(final PlayerBedEnterEvent event) {

        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            Bukkit.broadcastMessage(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.GREEN + " entered the bed!");
            Bukkit.getScheduler().runTaskLater(MinecraftServerPlugin.minecraftServerPlugin, new Runnable() {
                public void run() {
                    if (event.getPlayer().isSleeping()) {
                        event.getPlayer().getWorld().setTime(0);
                    }
                }
            }, secondsToFallAsleep*20);
        }

    }

    @EventHandler
    public void leaveBed(PlayerBedLeaveEvent event) {

        Bukkit.broadcastMessage(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.GREEN + " left the bed!");

    }

}
