package com.fr.matrax.sellallcreator.sellers;

import org.bukkit.Material;

public class SellerMaterial 
{
	
	private Material material;
	private double price;
	
	public SellerMaterial(Material material, double price) 
	{
		this.material = material;
		this.price = price;
	}
	
	public Material getMaterial() 
	{
		return this.material;
	}
	
	public double getPrice() 
	{
		return this.price;
	}

}
