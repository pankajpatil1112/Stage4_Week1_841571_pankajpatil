package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	@Autowired
	private MovieDaoCollectionImpl moiveDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);
	private static ArrayList<Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
//		super();
//		if(userFavorites==null)
//		{
//			userFavorites = new HashMap<String,Favorites>();
//		}
	}

	@Override
	public void addFavoritesMovie(String userId, int movieId) {

		LOGGER.info("CartDaoImpl addFavoritesMovie() START");
		Movie movie = moiveDaoCollectionImpl.findById(movieId);
		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		userFavorites = context.getBean("favoriteList", ArrayList.class);
         userFavorites.forEach(a -> {
        	 String uId = a.getUs_id();
              if(uId.equals(userId)){
            movieFavoritesList = a.getFavoritesMovieList();
            	  if (movieFavoritesList.isEmpty()) {
      				throw new FavoritesEmptyException();
      			}
            	  
              }
         });
         movieFavoritesList.add(movie);
         LOGGER.info("UserId:{}", userId);
		LOGGER.info("MovieId: {}", movieId);
 		LOGGER.info("UserFavorites:{}", movieFavoritesList);


	}
	ArrayList<Movie> movieFavoritesList = new ArrayList<>();
	@Override
	public ArrayList<Movie> getAllFavoritesMovies(String userId) {
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getAllFavoritesMovies(String userId) START");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		userFavorites = context.getBean("favoriteList", ArrayList.class);
         userFavorites.forEach(a -> {
        	 String uId = a.getUs_id();
              if(uId.equals(userId)){
            movieFavoritesList = a.getFavoritesMovieList();
            	  if (movieFavoritesList.isEmpty()) {
      				throw new FavoritesEmptyException();
      			}
            	  
              }
         });
        

         LOGGER.debug("UserMovieList: {}", movieFavoritesList);
		LOGGER.debug("UserId: {}", userId);
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getAllFavoritesMovies(String userId) END");
		//throw new FavoritesEmptyException();
		 return movieFavoritesList;
	}

	@Override
	public void removeFavoritesMovie(String userId, int movieId) {
		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie(int userId, int movieId) START");

		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		userFavorites = context.getBean("favoriteList", ArrayList.class);
         userFavorites.forEach(a -> {
        	 String uId = a.getUs_id();
              if(uId.equals(userId)){
            movieFavoritesList = a.getFavoritesMovieList();
            	  if (movieFavoritesList.isEmpty()) {
      				throw new FavoritesEmptyException();
      			}
            	  
              }
         });
         for (int i = 0; i < movieFavoritesList.size(); i++) {
				if (movieFavoritesList.get(i).getId() == movieId) {
					movieFavoritesList.remove(i);
				}
			}
         LOGGER.debug("userId: {}", userId);
			LOGGER.info("movieId: {}", movieId);
			LOGGER.info("MovieFavoritesList: {}", movieFavoritesList);
			


		LOGGER.debug("UserId: {}", userId);
		LOGGER.debug("MovieId: {}", movieId);

		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie(int userId, int movieId) END");

	}

}
