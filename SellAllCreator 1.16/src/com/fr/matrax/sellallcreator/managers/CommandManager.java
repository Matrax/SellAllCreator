package com.fr.matrax.sellallcreator.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.fr.matrax.sellallcreator.commands.SellAllCommand;

public class CommandManager implements CommandExecutor 
{
	
	private JavaPlugin plugin;
	
	/**
	 * Constructor of the class CommandManager
	 * @param plugin The instance of the plugin
	 */
	public CommandManager(JavaPlugin plugin) 
	{
		this.plugin = plugin;
	}
	
	/**
	 * This method load the command manager
	 */
	public void load()
	{
		this.plugin.getCommand("sellall").setExecutor(this);
	}
	
	/**
	 * This method unload the command manager
	 */
	public void unload()
	{
		this.plugin.getCommand("sellall").setExecutor(null);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) 
	{
		if(command.getName().equalsIgnoreCase("sellall"))
		{
			Player player = (Player) sender;
			if(args.length == 0)
			{
				SellAllCommand.sellAll(player);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("info")) 
			{
				SellAllCommand.sellAllInfo(player);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("help")) 
			{
				player.sendMessage("");
				player.sendMessage("§6=========SellAllCreator Version:" + this.plugin.getDescription().getVersion() + "=========");
				player.sendMessage("§9Plugin by _Matrax_");
				player.sendMessage("§a/sellall");
				player.sendMessage("§a/sellall reload");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("reload")) this.reloadCommand(player, args);
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method use the command for reload sellallcreator
	 * @param player The player who use the command
	 * @param args The arguments list of the command
	 */
	public void reloadCommand(Player player, String[] args)
	{
		if(player.hasPermission("sellallcreator.command.reload") == true || player.isOp())
		{
			player.sendMessage("§cSellAllCreator reloading ...");
			Bukkit.getPluginManager().disablePlugin(this.plugin);
			Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin("SellAllCreator"));
			player.sendMessage("§aSellAllCreator reloaded !");
		} else {
			player.sendMessage("§cYou don't have the permission");
		}
	}
	
}
