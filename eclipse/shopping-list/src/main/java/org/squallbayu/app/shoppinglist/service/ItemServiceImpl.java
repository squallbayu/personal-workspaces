package org.squallbayu.app.shoppinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.squallbayu.app.shoppinglist.model.Item;
import org.squallbayu.app.shoppinglist.repository.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements
		ItemService {

	@Autowired
	private ItemRepository itemRepository;


	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item save(Item i) {
		return itemRepository.save(i);
	}

	@Override
	public void delete(Long id) {
		 itemRepository.delete(id);
	}

	@Override
	public Item findById(Long id) {
		return itemRepository.findOne(id);
	}
	

}
