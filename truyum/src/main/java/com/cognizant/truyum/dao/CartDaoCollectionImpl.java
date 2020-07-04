package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartDaoCollectionImpl implements CartDao {

	@Autowired
	private MenuItemDaoCollectionImpl menuItemDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TruyumApplication.class);
	private static ArrayList<Cart> userCarts;

	public CartDaoCollectionImpl() {
		
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
	
		LOGGER.info("START CartDaoImpl addCartItem");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"truyum.xml");
		userCarts = context.getBean("cartItemList", java.util.ArrayList.class);
		userCarts.forEach(a -> {
			if (a.getUserId().equals(userId)) {
				menuItemList = a.getCartItemList();
				
				if (menuItemList.isEmpty()) {
					throw new CartEmptyException();
				} 
				LOGGER.info("CartItemList : {}", menuItemList);
				
				 
			}
			
		});
		MenuItem menuItem = menuItemDaoCollectionImpl.getMenuItem(menuItemId);
		menuItemList.add(menuItem);
		LOGGER.info("userId: {}", userId);
		LOGGER.info("menuItemId: {}", menuItemId);
		LOGGER.info("UserCart : {}", menuItemList);

	}

	ArrayList<MenuItem> menuItemList;

	@Override
	public ArrayList<MenuItem> getAllCartItems(String userId)
			throws CartEmptyException {
		// TODO Auto-generated method stub
		LOGGER.info("START CartDaoImpl getAllCartItems");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"truyum.xml");
		userCarts = context.getBean("cartItemList", java.util.ArrayList.class);
		userCarts.forEach(a -> {
			if (a.getUserId().equals(userId)) {
				menuItemList = a.getCartItemList();
				double total = 0.0;
				if (menuItemList.isEmpty()) {
					throw new CartEmptyException();
				} else {

					for (int i = 0; i < menuItemList.size(); i++) {
						total += menuItemList.get(i).getPrice();
					}
				}
				LOGGER.info("CartItemList : {}", menuItemList);
				 LOGGER.info("Total: {} ", total);
				 
			}
			
		});
		
		
		LOGGER.info("END CartDaoImpl getAllCartItems");
		return menuItemList;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {

		LOGGER.info("START CartDaoImpl removeCartItem");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"truyum.xml");
		userCarts = context.getBean("cartItemList", java.util.ArrayList.class);
		userCarts.forEach(a -> {
			if (a.getUserId().equals(userId)) {
				menuItemList = a.getCartItemList();
			
				if (menuItemList.isEmpty()) {
					throw new CartEmptyException();
				} 
				LOGGER.info("CartItemList : {}", menuItemList);
				
				 
			}
			
		});
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);

			}

		}
		LOGGER.info("userId: {}", userId);
		LOGGER.info("menuItemId: {}", menuItemId);
		LOGGER.debug("CartItemList: {}", menuItemList);
		

	}

}
