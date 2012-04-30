/**
 * 
 */
package g5.ambience.controller;

import g5.ambience.model.BundleEntity;
import g5.ambience.model.ItemEntity;
import g5.ambience.model.UserEntity;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	private byte isOut;
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
	private List<ItemEntity> nMovies;
	private ItemEntity selectedItem;
	private UserEntity currentUser;

	
	
	
	@PersistenceContext(unitName="g5.ambience")
	EntityManager em;
	
	public ItemController(){
		if(em == null){
			em = (EntityManager) Persistence.createEntityManagerFactory("g5.ambience").createEntityManager();
		}		
	}
	
	public List<ItemEntity> findAllItems() {
	    TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o", ItemEntity.class);
	    return (List<ItemEntity>)query.getResultList();
	}
	
	public List<ItemEntity> findNUniqueItemsByType(int max, String type){
		TypedQuery<ItemEntity> query = em.createQuery("SELECT o FROM ItemEntity o WHERE o.type = :type", ItemEntity.class);
		query.setParameter("type", type).setMaxResults(max);
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
	public byte getIsOut() {
		return isOut;
	}

	/**
	 * @param isOut the isOut to set
	 */
	public void setIsOut(byte isOut) {
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
	 * @return the nMovies
	 */
	public List<ItemEntity> getnMovies() {
		return nMovies = findNUniqueItemsByType(7, "Movie");
	}

	/**
	 * @param nMovies the nMovies to set
	 */
	public void setnMovies(List<ItemEntity> nMovies) {
		this.nMovies = nMovies;
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

}
