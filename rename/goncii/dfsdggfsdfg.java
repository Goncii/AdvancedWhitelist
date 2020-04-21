package rename.goncii;

import org.bukkit.command.*;
import org.bukkit.*;
import org.apache.commons.lang.*;
import java.util.*;

public class dfsdggfsdfg
{
    static void commandList(final CommandSender sender) {
        for (final String s : Files.getMsg().getStringList("help")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
        }
    }
    
    static void list(final CommandSender sender) {
        final List<String> whitelist = (List<String>)Main.getInst().getConfig().getStringList("whitelist");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("list").replace("%amount", new StringBuilder(String.valueOf(whitelist.size())).toString()).replace("%list", StringUtils.join((Collection)whitelist, ", "))));
    }
    
    static void add(final CommandSender sender, final String p) {
        final List<String> whitelist = (List<String>)Main.getInst().getConfig().getStringList("whitelist");
        if (!whitelist.contains(p)) {
            whitelist.add(p);
            Main.getInst().getConfig().set("whitelist", (Object)whitelist);
            Files.saveReload();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("add").replaceAll("%player", p)));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("arleadyAdded").replaceAll("%player", p)));
        }
    }
    
    static void remove(final CommandSender sender, final String p) {
        final List<String> whitelist = (List<String>)Main.getInst().getConfig().getStringList("whitelist");
        if (whitelist.contains(p)) {
            whitelist.remove(p);
            Main.getInst().getConfig().set("whitelist", (Object)whitelist);
            Files.saveReload();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("remove").replaceAll("%player", p)));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("unknownPlayer").replaceAll("%player", p)));
        }
    }
    
    static void on(final CommandSender sender) {
        if (!Main.enable) {
            Main.getInst().getConfig().set("enable", (Object)true);
            Files.saveReload();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("turnOn")));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("arleadyOn")));
        }
    }
    
    static void off(final CommandSender sender) {
        if (Main.enable) {
            Main.getInst().getConfig().set("enable", (Object)false);
            Files.saveReload();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("turnOff")));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("arleadyOff")));
        }
    }
}
