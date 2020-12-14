package com.fr.matrax.sellallcreator.array;

import com.fr.matrax.sellallcreator.sellers.Seller;

public class SellerList 
{
	
	private Seller[] sellers;
	private int max;
	private int count;
	
	/**
	 * Constructor of the class SellerList.
	 * Create a list of sellers.
	 * @param max The max of seller in the list
	 */
	public SellerList(int max)
	{
		this.sellers = new Seller[max];
		this.max = max;
		this.count = 0;
	}
	
	/**
	 * This method add a seller in the list
	 * @param seller The seller to add
	 */
	public void add(Seller seller)
	{
		if(this.count < this.max)
		{
			for(int i = 0; i < this.sellers.length; i++)
			{
				if(this.sellers[i] == null)
				{
					this.sellers[i] = seller;
					this.count++;
					break;
				}
			}
		}
	}
	
	/**
	 * This method remove a seller in the list
	 * @param seller The seller to remove
	 */
	public void remove(Seller seller)
	{
		for(int i = 0; i < this.sellers.length; i++)
		{
			if(this.sellers[i] != null && this.sellers[i] == seller)
			{
				this.sellers[i] = null;
				this.count--;
				break;
			}
		}
	}
	
	/**
	 * This method clear the list of sellers
	 */
	public void clear()
	{
		if(this.count > 0)
		{
			for(int i = 0; i < this.sellers.length; i++)
			{
				this.sellers[i] = null;
			}
		}
		this.count = 0;
	}
	
	/**
	 * This method check if the seller is in the list
	 * @param seller The seller to check
	 * @return if the seller is in the list
	 */
	public boolean contains(Seller seller)
	{
		for(int i = 0; i < this.sellers.length; i++)
		{
			if(this.sellers[i] != null && this.sellers[i] == seller) return true;
		}
		return false;
	}
	
	/**
	 * This method return the count of sellers in the list
	 * @return The count of sellers in the list
	 */
	public int getCount() 
	{
		return this.count;
	}
	
	/**
	 * This method return the max of sellers in the list
	 * @return The max of sellers in the list
	 */
	public int getMax() 
	{
		return this.max;
	}
	
	/**
	 * This method return the array of sellers
	 * @return The array of sellers
	 */
	public Seller[] getSellers() 
	{
		return this.sellers;
	}

}
