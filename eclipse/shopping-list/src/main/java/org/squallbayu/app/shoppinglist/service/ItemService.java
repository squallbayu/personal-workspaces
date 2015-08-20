package org.squallbayu.app.shoppinglist.service;

import java.util.List;

import org.squallbayu.app.shoppinglist.model.Item;


public interface ItemService{
	public List<Item> findAll();
	public Item save(Item i);
	public void delete(Long id);
	public Item findById(Long id);

}
