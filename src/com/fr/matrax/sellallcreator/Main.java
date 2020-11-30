package com.fr.matrax.sellallcreator;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.fr.matrax.sellallcreator.file.SellFile;
import com.fr.matrax.sellallcreator.managers.CommandManager;
import com.fr.matrax.sellallcreator.managers.SellManager;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin
{
	
	private static CommandManager commandManager;
	private static SellFile sellFile;
	private static SellManager sellManager;
    private static Economy economy;
    
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) economy = economyProvider.getProvider();
        return (economy != null);
    }
	
	@Override
	public void onEnable() 
	{
		boolean vault = setupEconomy();
		if(vault == true)
		{
			sellFile = new SellFile();
			commandManager = new CommandManager(this);
			sellManager = new SellManager();
			sellManager.load(sellFile);
			commandManager.load();
		} else {
			System.err.println("ERROR ON LOAD VAULT ! MAYBE BAD VERSION OF VAULT ! DISABLING SELLALLCREATOR");
			this.getPluginLoader().disablePlugin(this);
		}
	}
	
	@Override
	public void onDisable() 
	{
		sellManager.unload();
		commandManager.unload();
	}
	
	public static Economy getEconomy() 
	{
		return economy;
	}
	
	public static SellFile getSellFile() 
	{
		return sellFile;
	}
	
	public static SellManager getSellManager() 
	{
		return sellManager;
	}

}
