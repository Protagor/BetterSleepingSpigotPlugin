package to.minecraft.elitesquad.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;
import java.util.List;

/**
 * Handles all events that have to be handled in this plugin.
 *
 * @author Protagor
 */
public class EventListener implements Listener {

    private static final List<String> sleepingQuotes = Arrays.asList(
            " schläft nun!",
            " hat sich in die Welt der Träume verabschiedet!",
            " ist ganz, ganz müde!",
            " kommt nach einem anstrengenden Tag endlich zur Ruhe!",
            " macht Hajahaja!"
    );

    private static final List<String> wakingUpQuotes = Arrays.asList(
            " startet nun ausgeschlafen und munter in den Tag!",
            " ist jetzt wach!",
            " hat zwar massiv verpennt, ist dann aber jetzt doch noch aufgewacht!",
            " würde zwar gerne noch weiterschlafen, aber die Pflicht ruft!",
            " ist aus einem schauderlichen Albtraum erwacht."
    );

    /**
     * Sends a random sleeping related quote to all players
     * when a player enters the bed.
     *
     * @param bedEnterEvent Method is invoked when 'PlayerBedEnterEvent' is triggered.
     */
    @EventHandler
    public void sendSleepingQuote(PlayerBedEnterEvent bedEnterEvent) {
        //checks if player really entered the bed
        if (bedEnterEvent.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            bedEnterEvent.getPlayer().setSleepingIgnored(false);
            //sends random sleeping quote to all players
            Bukkit.broadcastMessage(
                    ChatColor.GOLD + bedEnterEvent.getPlayer().getName()
                    + ChatColor.GREEN + sleepingQuotes.get( (int) ( Math.random() * sleepingQuotes.size() ) )
            );
        }
    }

    /**
     * Sends a random waking up related quote to all players
     * when a player leaves the bed.
     *
     * @param bedLeaveEvent Method is invoked when 'PlayerBedLeaveEvent' is triggered.
     */
    @EventHandler
    public void leaveBed(PlayerBedLeaveEvent bedLeaveEvent) {
        bedLeaveEvent.getPlayer().setSleepingIgnored(true);
        //sends random wake up quote to all players
        Bukkit.broadcastMessage(
                ChatColor.GOLD + bedLeaveEvent.getPlayer().getName()
                        + ChatColor.GREEN + wakingUpQuotes.get( (int) ( Math.random() * wakingUpQuotes.size() ) )
        );
    }

    /**
     * Sets 'sleepingIgnored' for every player to true
     * so only one player in the whole world has to go to bed.
     *
     * @param joinEvent Method is invoked when 'PlayerJoinEvent' is triggered.
     */
    @EventHandler
    public void setSleepingIgnored(PlayerJoinEvent joinEvent) {
        joinEvent.getPlayer().setSleepingIgnored(true);
    }

}
