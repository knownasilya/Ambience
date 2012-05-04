/**
 * 
 */
package g5.ambience.controller;

import g5.ambience.model.BundleEntity;
import g5.ambience.model.ItemEntity;
import g5.ambience.model.UserEntity;
import g5.ambience.util.Auth;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.context.RequestContext;

/**
 * @author ilya
 *
 */
public class ItemController {
	
	private int itemId;
	private String developer;
	private String director;
	private String esrbRating;
	private String genre;
	private String imageUrl;
	private boolean isOut;
	private String mpaaRating;
	private String platform;
	private int referenceNumber;
	private int releaseYear;
	private String synopsis;
	private String title;
	private String trailerUrl;
	private String type;
	private int userRating;
	private Set<BundleEntity> bundleEntities;
	private List<ItemEntity> allItems;
	private List<ItemEntity> movies;
	private List<ItemEntity> games;
	private List<ItemEntity> topTen;
	private List<ItemEntity> latestItems;
	private ItemEntity selectedItem;
	private UserEntity currentUser;

	
	
	
	@PersistenceContext(unitName="g5.ambience")
	EntityManager em;
	
	public ItemController(){
		if(em == null){
			em = (EntityManager) Persistence.createEntityManagerFactory("g5.ambience").createEntityManager();
		}		
	}
	
	private void createMovie(int itemId, String title, int releaseYear, String type, String platform, String genre, boolean isOut, int userRating, int referenceNumber, String director, String trailerUrl, String synopsis, String imageUrl, String mpaaRating){
		try {
			String esrbRating = "N/A";
			String developer = "N/A";
			ItemEntity item = new ItemEntity(itemId, title, releaseYear, type, platform, genre, isOut, userRating, esrbRating, referenceNumber, director, trailerUrl, synopsis, imageUrl, developer, mpaaRating);
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			//blank
		}
	}
	
	private void createGame(int itemId, String title, int releaseYear, String type, String platform, String genre, boolean isOut, int userRating, String esrbRating, int referenceNumber, String trailerUrl, String synopsis, String imageUrl, String developer){
		try {
			String mpaaRating = "N/A";
			String director = "N/A";
			ItemEntity item = new ItemEntity(itemId, title, releaseYear, type, platform, genre, isOut, userRating, esrbRating, referenceNumber, director, trailerUrl, synopsis, imageUrl, developer, mpaaRating);
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			//blank
		}
	}
	
	public void deleteItem(int itemId) {		
		try {
			ItemEntity item = em.find(ItemEntity.class, itemId);
			em.getTransaction().begin();
			em.remove(item);
			em.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		finally {	
		}
	}
	
	public void updateItem(int itemId, String title, int releaseYear, String type, String platform, String genre, boolean isOut, int userRating, String esrbRating, int referenceNumber, String director, String trailerUrl, String synopsis, String imageUrl, String developer, String mpaaRating) {
		try {
			ItemEntity item = em.find(ItemEntity.class, itemId);
			em.getTransaction().begin();
			em.merge(item);
			em.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		finally {	
		}
	}
	
	public List<ItemEntity> searchItem(int itemId) {
		try {
			TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o WHERE o.itemId = :itemId", ItemEntity.class);
			query.setParameter("itemId", itemId);
			return (List<ItemEntity>)query.getResultList();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		finally {
		}
		return null;
	}
	
	public List<ItemEntity> searchItem(String title) {
		try {
			TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o WHERE o.title = :title", ItemEntity.class);
			query.setParameter("title", title);
			return (List<ItemEntity>)query.getResultList();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		finally {
		}
		return null;
	}
	
	public List<ItemEntity> findAllItems() {
	    TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o", ItemEntity.class);
	    return (List<ItemEntity>)query.getResultList();
	}
	
	public List<ItemEntity> findItemsWithRatingGreaterThan(int value) {
	    TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o WHERE o.userRating > :value", ItemEntity.class);
	    query.setParameter("value", value);
	    return (List<ItemEntity>)query.getResultList();
	}
	
	public List<ItemEntity> findAllItems(String type) {
	    TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o WHERE o.type = :type", ItemEntity.class);
	    query.setParameter("type", type);
	    return (List<ItemEntity>)query.getResultList();
	}
	
	public List<ItemEntity> findUniqueItemsByType(String type, int numItems){
		TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o WHERE o.type = :type", ItemEntity.class);
		if(numItems > 0){
			query.setParameter("type", type).setMaxResults(numItems);
		} 
		else {
			query.setParameter("type", type);
		}		
		return (List<ItemEntity>)query.getResultList();
	}
	
	public String item(){
		return "item";
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the developer
	 */
	public String getDeveloper() {
		return developer;
	}

	/**
	 * @param developer the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the esrbRating
	 */
	public String getEsrbRating() {
		return esrbRating;
	}

	/**
	 * @param esrbRating the esrbRating to set
	 */
	public void setEsrbRating(String esrbRating) {
		this.esrbRating = esrbRating;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the isOut
	 */
	public boolean getIsOut() {
		return isOut;
	}

	/**
	 * @param isOut the isOut to set
	 */
	public void setIsOut(boolean isOut) {
		this.isOut = isOut;
	}

	/**
	 * @return the mpaaRating
	 */
	public String getMpaaRating() {
		return mpaaRating;
	}

	/**
	 * @param mpaaRating the mpaaRating to set
	 */
	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the referenceNumber
	 */
	public int getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * @param referenceNumber the referenceNumber to set
	 */
	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the trailerUrl
	 */
	public String getTrailerUrl() {
		return trailerUrl;
	}

	/**
	 * @param trailerUrl the trailerUrl to set
	 */
	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the userRating
	 */
	public int getUserRating() {
		return userRating;
	}

	/**
	 * @param userRating the userRating to set
	 */
	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	/**
	 * @return the bundleEntities
	 */
	public Set<BundleEntity> getBundleEntities() {
		return bundleEntities;
	}

	/**
	 * @param bundleEntities the bundleEntities to set
	 */
	public void setBundleEntities(Set<BundleEntity> bundleEntities) {
		this.bundleEntities = bundleEntities;
	}

	/**
	 * @return the allItems
	 */
	public List<ItemEntity> getAllItems() {
		return allItems = findAllItems();
	}

	/**
	 * @param allItems the allItems to set
	 */
	public void setAllItems(List<ItemEntity> allItems) {
		this.allItems = allItems;
	}


	/**
	 * @return the selectedItem
	 */
	public ItemEntity getSelectedItem() {
		return selectedItem;
	}

	/**
	 * @param selectedItem the selectedItem to set
	 */
	public void setSelectedItem(ItemEntity selectedItem) {
		this.selectedItem = selectedItem;
	}

	/**
	 * @return the currentUser
	 */
	public UserEntity getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(UserEntity currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the movies
	 */
	public List<ItemEntity> getMovies() {
		//0 means do not limit the number of rows returned.
		return movies = findUniqueItemsByType("Movie", 0);
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<ItemEntity> movies) {
		this.movies = movies;
	}

	/**
	 * @return the games
	 */
	public List<ItemEntity> getGames() {
		return games = findUniqueItemsByType("Game", 0);
	}

	/**
	 * @param games the games to set
	 */
	public void setGames(List<ItemEntity> games) {
		this.games = games;
	}

	/**
	 * @return the topTen
	 */
	public List<ItemEntity> getTopTen() {
		return topTen = findItemsWithRatingGreaterThan(3);
	}

	/**
	 * @param topTen the topTen to set
	 */
	public void setTopTen(List<ItemEntity> topTen) {
		this.topTen = topTen;
	}

	/**
	 * @return the latestItems
	 */
	public List<ItemEntity> getLatestItems() {
		return latestItems;
	}

	/**
	 * @param latestItems the latestItems to set
	 */
	public void setLatestItems(List<ItemEntity> latestItems) {
		this.latestItems = latestItems;
	}	

}
