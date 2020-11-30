package com.fr.matrax.sellallcreator.managers;

import java.util.ArrayList;

import com.fr.matrax.sellallcreator.array.SellerList;
import com.fr.matrax.sellallcreator.file.SellFile;
import com.fr.matrax.sellallcreator.sellers.Seller;

public class SellManager 
{
	
	private static SellManager sellManager;
	private SellerList sellers;
	
	public SellManager() 
	{
		this.sellers = new SellerList(50);
		sellManager = this;
	}
	
	public static SellManager getSellManager() 
	{
		return sellManager;
	}
	
	public void load(SellFile file)
	{
		ArrayList<String> list = (ArrayList<String>) file.getStringList("sellers");
		for(int i = 0; i < list.size(); i++)
		{
			Seller seller = new Seller(list.get(i));
			this.sellers.add(seller);
			seller.load(file);
		}
	}
	
	public void unload()
	{
		this.sellers.clear();
	}
	
	public SellerList getSellers() 
	{
		return this.sellers;
	}

}
