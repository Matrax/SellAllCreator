package com.fr.matrax.sellallcreator.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

public abstract class PluginFile
{
	private FileConfiguration configFile;
	private File file;
	
	/**
	 * This method is called when the plugin file is created
	 */
	public abstract void OnCreate();
	
	/**
	 * This method is called when the plugin load the file
	 */
	public abstract void OnLoad();
	
	/**
	 * Constructor of the class PluginFile
	 * @param path The path of the file
	 */
	public PluginFile(String path)
	{
		this.file = new File(path);
		this.configFile = YamlConfiguration.loadConfiguration(this.file);
	}
	
	/**
	 * This method create the file if it doesn't exist
	 */
	public void initialize()
	{
		if(this.getFile().exists() == false) this.OnCreate();
	}
	
	/**
	 * This method load the file
	 */
	public void load()
	{
		this.OnLoad();
	}
	
	/**
	 * This method save the file
	 */
	public void save()
	{
		try {
			this.configFile.save(this.file);
		} catch (IOException e) {
			System.err.println("Error to save the file " + this.file.getPath());
		}
	}
	
	/**
	 * This method set the value of a configuration
	 * @param name The name of the configuration
	 * @param value The value to set
	 */
	public void set(String name, Object value)
	{
		this.configFile.set(name, value);
	}
	
	/**
	 * This method check if a configuration is in the file
	 * @param name The name of the configuration
	 * @return of the configuration is in the file
	 */
	public boolean contains(String name)
	{
		return this.configFile.contains(name);
	}
	
	/**
	 * This method return a string value from the file
	 * @param name The name of the configuration
	 * @return The string value of the configuration
	 */
	public String getString(String name)
	{
		return this.configFile.getString(name);
	}
	
	/**
	 * This method return a char value from the file
	 * @param name The name of the configuration
	 * @return The char value of the configuration 
	 */
	public char getChar(String name)
	{
		return this.configFile.getString(name).charAt(0);
	}
	
	/**
	 * This method return a boolean value from the file
	 * @param name The name of the configuration 
	 * @return The boolean value of the configuration
	 */
	public boolean getBoolean(String name)
	{
		return this.configFile.getBoolean(name);
	}
	
	/**
	 * This method return an integer value from the file
	 * @param name The name of the configuration
	 * @return The int value of the configuration
	 */
	public int getInt(String name)
	{
		
		return this.configFile.getInt(name);
	}
	
	/**
	 * This method return a float value from the file
	 * @param name The name of the configuration
	 * @return The float value of the configuration
	 */
	public float getFloat(String name)
	{
		
		return (float) this.configFile.getDouble(name);
	}
	
	/**
	 * This method return a double value from the file
	 * @param name The name of the configuration
	 * @return The double value of the configuration
	 */
	public double getDouble(String name)
	{
		
		return this.configFile.getDouble(name);
	}
	
	/**
	 * This method return a string list value from the file
	 * @param name The name of the configuration
	 * @return The string list value of the configuration
	 */
	public List<String> getStringList(String name)
	{
		
		return this.configFile.getStringList(name);
	}
	
	/**
	 * This method return a world option from the file 
	 * @param name The name of the configuration
	 * @return
	 */
	public World getWorld(String name)
	{
		return Bukkit.getWorld(this.getString(name));
	}
	
	/**
	 * This method return a effect option from the file
	 * @param name The name of the configuration
	 * @return
	 */
	public Effect getEffect(String name)
	{
		return Effect.valueOf(this.getString(name).toUpperCase());
	}
	
	/**
	 * This method return a entity type option from the file
	 * @param name The name of the configuration
	 * @return
	 */
	public EntityType getEntityType(String name)
	{
		return EntityType.valueOf(this.getString(name).toUpperCase());
	}
	
	/**
	 * This method return a material option from the file
	 * @param name The name of the configuration
	 * @return
	 */
	public Material getMaterial(String name)
	{
		return Material.valueOf(this.getString(name).toUpperCase());
	}
	
	/**
	 * This method return the configuration file
	 * @return The configuration file
	 */
	public FileConfiguration getConfigFile() {
		return configFile;
	}
	
	/**
	 * This method return the file
	 * @return The file
	 */
	public File getFile() {
		return file;
	}
	
}
