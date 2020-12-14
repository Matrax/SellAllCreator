package com.fr.matrax.sellallcreator.file;

import java.util.ArrayList;
import com.fr.matrax.sellallcreator.utils.PluginFile;

public class SellFile extends PluginFile
{

	public SellFile() 
	{
		super("plugins/SellAllCreator/Sell.yml");
		this.initialize();
	}

	@Override
	public void OnCreate() 
	{
		ArrayList<String> sellers = new ArrayList<String>();
		sellers.add("default");
		this.set("default", "[]");
		this.set("sellers", sellers);
		this.save();
	}

	@Override
	public void OnLoad() 
	{
		
	}

}
