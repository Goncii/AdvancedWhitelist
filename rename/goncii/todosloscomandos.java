package rename.goncii;

import org.bukkit.command.*;
import org.bukkit.*;

public class todosloscomandos implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("wl")) {
            if (sender.hasPermission("use")) {
                if (args.length == 0) {
                    dfsdggfsdfg.commandList(sender);
                }
                else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("list")) {
                        if (sender.hasPermission("whitelist.list")) {
                            dfsdggfsdfg.list(sender);
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else if (args[0].equalsIgnoreCase("on")) {
                        if (sender.hasPermission("whitelist.on")) {
                            dfsdggfsdfg.on(sender);
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else if (args[0].equalsIgnoreCase("off")) {
                        if (sender.hasPermission("whitelist.off")) {
                            dfsdggfsdfg.off(sender);
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else if (args[0].equalsIgnoreCase("add")) {
                        if (sender.hasPermission("whitelist.add")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("incorrectUse")));
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else if (args[0].equalsIgnoreCase("remove")) {
                        if (sender.hasPermission("whitelist.remove")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("incorrectUse")));
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else if (args[0].equalsIgnoreCase("reload")) {
                        if (sender.hasPermission("whitelist.reload")) {
                            Files.reloadConfig(sender);
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("incorrectUse")));
                    }
                }
                else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("add")) {
                        if (sender.hasPermission("whitelist.add")) {
                            dfsdggfsdfg.add(sender, args[1]);
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else if (args[0].equalsIgnoreCase("remove")) {
                        if (sender.hasPermission("whitelist.remove")) {
                            dfsdggfsdfg.remove(sender, args[1]);
                        }
                        else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
                        }
                    }
                    else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("incorrectUse")));
                    }
                }
                else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("incorrectUse")));
                }
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Files.getMsg().getString("permission")));
            }
        }
        return false;
    }
}
