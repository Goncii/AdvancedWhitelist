package rename.goncii;

import org.bukkit.configuration.file.*;
import java.io.*;
import org.bukkit.command.*;
import net.md_5.bungee.api.*;

public class Files
{
    private static YamlConfiguration msg;
    
    public static void checkFiles() {
        if (!Main.getInst().getDataFolder().exists()) {
            Main.getInst().getDataFolder().mkdir();
        }
        if (!new File(Main.getInst().getDataFolder(), "config.yml").exists()) {
            Main.getInst().saveDefaultConfig();
        }
        final File message = new File(Main.getInst().getDataFolder(), "message.yml");
        if (!message.exists()) {
            Main.getInst().saveResource("message.yml", true);
        }
        Files.msg = YamlConfiguration.loadConfiguration(message);
        Main.enable = Main.getInst().getConfig().getBoolean("enable");
    }
    
    public static YamlConfiguration getMsg() {
        return Files.msg;
    }
    
    public static void reloadConfig(final CommandSender sender) {
        checkFiles();
        Main.getInst().reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getMsg().getString("reload")));
    }
    
    public static void saveReload() {
        Main.getInst().saveConfig();
        Main.getInst().reloadConfig();
        Main.enable = Main.getInst().getConfig().getBoolean("enable");
    }
}
