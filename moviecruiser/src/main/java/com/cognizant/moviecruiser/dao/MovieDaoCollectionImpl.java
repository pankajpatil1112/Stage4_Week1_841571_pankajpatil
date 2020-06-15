package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Repository
public class MovieDaoCollectionImpl implements MovieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

	private ArrayList<Movie> adminMovieList;

	@Override
	public ArrayList<Movie> getMovieListAdmin() {
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getMovieListAdmin() START");

		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		adminMovieList = context.getBean("adminMovieList", ArrayList.class);

		LOGGER.debug("AdminMovieList: {}", adminMovieList);

		((ConfigurableApplicationContext) context).close();
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getMovieListAdmin() END");
		return adminMovieList;
	}

	@Override
	public ArrayList<Movie> getMovieListCustomer() {
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getMovieListCustomer() START");

		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		ArrayList<Movie> userMovieList = context.getBean("userMovieList", ArrayList.class);

		LOGGER.debug("UserMovieList: {}", userMovieList);

		((ConfigurableApplicationContext) context).close();

		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getMovieListCustomer() END");
		return userMovieList;
	}

	@Override
	public Movie findById(int id) {
		LOGGER.info("MovieDaoCollectionImpl Movie findById(int id) START");

		adminMovieList = getMovieListAdmin();

		LOGGER.info("MovieDaoCollectionImpl Movie findById(int id) END");

		return adminMovieList.stream().filter(movie -> movie.getId()==id).findFirst().orElseThrow(() -> {throw new MovieNotFoundException();});
	}

	@Override
	public void modifyMovie(Movie movie) {
		LOGGER.info("MovieDaoCollectionImpl modifyMovie(Movie movie) START");

		Movie movieUpdate = findById(movie.getId());
		
		movieUpdate.setTitle(movie.getTitle());
		movieUpdate.setBoxOffice(movie.getBoxOffice());
		
		LOGGER.debug("MovieUpdate: {}", movieUpdate);
		LOGGER.info("MovieDaoCollectionImpl modifyMovie(Movie movie) END");
	}

	@Override
	public ArrayList<Movie> getMovieListActive() {
		// TODO Auto-generated method stub
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getMovieListActive() START");

		adminMovieList = getMovieListAdmin();

		ArrayList<Movie> activeMovieList = new ArrayList<Movie>();
		activeMovieList.add(adminMovieList.stream().filter(movie -> movie.isActive()).findFirst().orElseThrow(() -> {throw new MovieNotFoundException();}));
		
		LOGGER.debug("ActiveMovieUpdate: {}", activeMovieList);
		
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getMovieListActive() END");

		return activeMovieList;
	}
}
