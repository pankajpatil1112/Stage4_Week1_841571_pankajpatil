package com.cognizant.truyum.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.exception.MenuItemNotFoundException;;
@Service
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TruyumApplication.class);

	private static ArrayList<MenuItem> listOfMenuItem;

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("START MenuItemDaoImpl getMenuItemListCustomer");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"truyum.xml");
		listOfMenuItem = context.getBean("menuItemList",
				java.util.ArrayList.class);

		LOGGER.debug("MenuItemList: {} ", listOfMenuItem.toString());

		((AbstractApplicationContext) context).close();
		LOGGER.info("END MenuItemDaoImpl getMenuItemListCustomer");
		return listOfMenuItem;
	}

	@Override
	public MenuItem getMenuItem(long id) {
		LOGGER.info("START MenuItemDaoImpl getMenuItem");

		listOfMenuItem = getMenuItemListCustomer();

		LOGGER.debug("MenuItemList: {} ", listOfMenuItem);

		LOGGER.info("END MenuItemDaoImpl getMenuItem");

		return listOfMenuItem.stream().filter(item -> (item.getId() == id))
				.findFirst().orElseThrow(() -> {
					throw new MenuItemNotFoundException();
				});
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("START MenuItemDaoImpl modifyMenuItem");
		MenuItem menuItemUpdate = getMenuItem(menuItem.getId());

		menuItemUpdate.setName(menuItem.getName());
		menuItemUpdate.setPrice(menuItem.getPrice());
		menuItemUpdate.setActive(menuItem.isActive());
		menuItemUpdate.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuItemUpdate.setCategory(menuItem.getCategory());
		menuItemUpdate.setFreeDelivery(menuItem.isFreeDelivery());

		LOGGER.info("MenuItemUpdated: {}", menuItemUpdate);
		LOGGER.info("END MenuItemDaoImpl modifyMenuItems");

		return;
	}
}
