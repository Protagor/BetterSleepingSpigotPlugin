package to.minecraft.elitesquad.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import to.minecraft.elitesquad.plugin.MinecraftServerPlugin;

public class EventListener implements Listener {

    private final long secondsToFallAsleep = 3;

    @EventHandler
    public void goToBed(final PlayerBedEnterEvent event) {

        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            Bukkit.getScheduler().runTaskLater(MinecraftServerPlugin.minecraftServerPlugin, new Runnable() {
                public void run() {
                    if (event.getPlayer().isSleeping()) {
                        event.getPlayer().getWorld().setTime(0);
                    }
                }
            }, secondsToFallAsleep*20);
        }

    }

}
