package com.fr.matrax.sellallcreator.commands;

import java.util.HashMap;
import java.util.Map.Entry;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import com.fr.matrax.sellallcreator.Main;
import com.fr.matrax.sellallcreator.managers.SellManager;
import com.fr.matrax.sellallcreator.sellers.Seller;
import com.fr.matrax.sellallcreator.sellers.SellerMaterial;

import net.milkbowl.vault.economy.Economy;

public class SellAllCommand 
{
	
	public static void sellAllInfo(Player player)
	{
		if(player.hasPermission("sellallcreator.commands.info") == false && player.isOp() == false)
		{
			player.sendMessage("§cYou don't have the permission !");
			return;
		}
			
		
		Seller[] sellers = SellManager.getSellManager().getSellers().getSellers();
		for(Seller sell : sellers)
		{
			if(sell == null) continue;
			player.sendMessage("§6" + sell.getName() + ": ");
			for(SellerMaterial mat : sell.getSellerMaterials())
			{
				if(mat == null) continue;
				player.sendMessage("     §a" + mat.getMaterial().toString() + " / " + mat.getPrice() + " $");
			}

		}
	}
	
	public static void sellAll(Player player)
	{
		if(player.hasPermission("sellallcreator.commands.sellall") == false && player.isOp() == false)
		{
			player.sendMessage("§cYou don't have the permission !");
			return;
		}
			
		
		Seller[] sellers = SellManager.getSellManager().getSellers().getSellers();
		Inventory inv = player.getInventory();
		Economy eco = Main.getEconomy();
		double sellAmount = 0.0d;
		boolean hasSell = false;
		
		for(int i = 0; i < inv.getSize(); i++)
		{
			ItemStack item = inv.getItem(i);
			if(item == null) continue;
			
			HashMap<Seller, Double> sellersPossible = new HashMap<Seller, Double>();
			for(Seller sell : sellers)
			{
				if(sell == null) continue;
				if(player.isOp() == false && player.hasPermission("sellallcreator.commands.sellall." + sell.getName()) == false) continue;
				for(SellerMaterial mat : sell.getSellerMaterials())
				{
					if(mat == null) continue;
					if(item.getType().equals(mat.getMaterial()) == false) continue;
					sellersPossible.put(sell, mat.getPrice());
				}
			}
			
			if(sellersPossible.size() > 0)
			{
				Seller bestSeller = null;
				double bestPrice = 0;
				
				for(Entry<Seller, Double> entry : sellersPossible.entrySet())
				{
					if(entry == null) continue;
					if(bestSeller == null || (entry.getValue() >= bestPrice))
					{
						bestSeller = entry.getKey();
						bestPrice = entry.getValue();
					}
				}
				
				sellAmount += inv.getItem(i).getAmount() * bestPrice / 64;
				inv.setItem(i, null);
				hasSell = true;
			}
		}
		
		if(hasSell == true)
		{
			eco.depositPlayer(player, sellAmount);
			player.sendMessage("§a+ " + sellAmount + " $");
		} else {
			player.sendMessage("§cYou have nothing to sell !");
		}
	}

}
