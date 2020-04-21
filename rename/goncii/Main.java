package rename.goncii;

import org.bukkit.plugin.java.*;
import org.bukkit.*;
import org.bukkit.command.*;
import java.net.*;
import java.io.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    PluginDescriptionFile descf;
    public static Main inst;
    public static boolean enable;
    public String latestversion;
    public String version;
    
    public String getVersion() {
        return this.version;
    }
    
    public String getLatestversions() {
        return this.latestversion;
    }
    
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l*&8&m----------------------------------&7&l*"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lAdvanced &b&lWhitelist &7| &cVersion: &a1.0.0"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lAutor: &2Goncii &7| Support (Discord): invite.gg/gsa"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l*&8&m----------------------------------&7&l*"));
        this.updateChecker();
        Files.checkFiles();
        this.EventsReg();
        this.getCommand("wl").setExecutor((CommandExecutor)new todosloscomandos());
        this.getCommand("whitelist").setExecutor((CommandExecutor)new coamndos2());
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lAdvanced &b&lWhitelist &7| &cHas been disabled :C"));
    }
    
    public void updateChecker() {
        try {
            final HttpURLConnection con = (HttpURLConnection)new URL("https://api.spigotmc.org/legacy/update.php?resource=27456").openConnection();
            final int timed_out = 1250;
            con.setConnectTimeout(timed_out);
            con.setReadTimeout(timed_out);
            this.latestversion = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
            if (this.latestversion.length() <= 7 && !this.version.equals(this.latestversion)) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lAdvanced &9&lWhitelist&7>> &cWe have relased a new version,"));
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/41736/");
            }
        }
        catch (Exception ex) {
            Bukkit.getConsoleSender().sendMessage("Error while checking update.");
        }
    }
    
    public void EventsReg() {
        Bukkit.getPluginManager().registerEvents((Listener)new checkerwl(this), (Plugin)this);
    }
    
    public Main() {
        this.descf = this.getDescription();
        this.version = this.descf.getVersion();
        Main.inst = this;
    }
    
    public static Main getInst() {
        return Main.inst;
    }
}
