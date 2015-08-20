package org.squallbayu.app.shoppinglist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.squallbayu.app.shoppinglist.model.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{

	@Query("select i from Item i")
	List<Item> findAll();
}
