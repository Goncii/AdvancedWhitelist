package rename.goncii;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class checkerwl implements Listener
{
    private Main plugin;
    
    public checkerwl(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(final PlayerLoginEvent e) {
        if (Main.enable) {
            final Player p = e.getPlayer();
            if (!p.hasPermission("whitelist.bypass")) {
                final List<String> whitelist = (List<String>)Main.getInst().getConfig().getStringList("whitelist");
                if (!whitelist.contains(p.getName())) {
                    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("kickMessage")));
                }
            }
        }
    }
}
