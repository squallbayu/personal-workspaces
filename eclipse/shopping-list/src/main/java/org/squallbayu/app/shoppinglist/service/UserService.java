package org.squallbayu.app.shoppinglist.service;

import org.squallbayu.app.shoppinglist.model.User;

public interface UserService {
	User save(User user);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
}
