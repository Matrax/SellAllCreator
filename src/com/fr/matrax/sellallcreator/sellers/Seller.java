package com.fr.matrax.sellallcreator.sellers;

import java.util.ArrayList;
import org.bukkit.Material;
import com.fr.matrax.sellallcreator.file.SellFile;

public class Seller 
{
	
	private String name;
	private SellerMaterial[] sellerMaterials;
	
	public Seller(String name)
	{
		this.name = name;
		this.sellerMaterials = new SellerMaterial[50];
	}
	
	public void load(SellFile file)
	{
		ArrayList<String> content = (ArrayList<String>) file.getStringList(this.name);
		
		for(int i = 0; i < content.size(); i++)
		{
			String[] split = content.get(i).split(":");
			Material material = Material.valueOf(split[0]);
			double price = Double.valueOf(split[1]);
			this.sellerMaterials[i] = new SellerMaterial(material, price);
		}
	}
	
	public void unload()
	{
		for(int i = 0; i < this.sellerMaterials.length; i++)
		{
			this.sellerMaterials[i] = null;
		}
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public SellerMaterial[] getSellerMaterials() 
	{
		return this.sellerMaterials;
	}

}
