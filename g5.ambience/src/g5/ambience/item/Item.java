package g5.ambience.item;

import g5.ambience.user.User;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Item database table.
 * 
 */
@Entity
@Table(name="Item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="item_id", unique=true, nullable=false)
	private int itemId;

	@Column(length=45)
	private String developer;

	@Column(length=45)
	private String director;

	@Column(name="esrb_rating", length=10)
	private String esrbRating;

	@Column(nullable=false, length=45)
	private String genre;

	@Column(name="image_url", nullable=false, length=200)
	private String imageUrl;

	@Column(name="is_out", nullable=false)
	private byte isOut;

	@Column(name="mpaa_rating", length=5)
	private String mpaaRating;

	@Column(length=45)
	private String platform;

	@Column(name="reference_number", nullable=false)
	private int referenceNumber;

    @Temporal( TemporalType.DATE)
	@Column(name="release_year", nullable=false)
	private Date releaseYear;

	@Column(nullable=false, length=500)
	private String synopsis;

	@Column(nullable=false, length=45)
	private String title;

	@Column(name="trailer_url", length=200)
	private String trailerUrl;

	@Column(nullable=false, length=45)
	private String type;

	@Column(name="user_rating")
	private int userRating;

	//bi-directional many-to-many association to User
    @ManyToMany
	@JoinTable(
		name="Member_has_Item"
		, joinColumns={
			@JoinColumn(name="item_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="username", nullable=false)
			}
		)
	private Set<User> users;

    public Item() {
    }

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDeveloper() {
		return this.developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getEsrbRating() {
		return this.esrbRating;
	}

	public void setEsrbRating(String esrbRating) {
		this.esrbRating = esrbRating;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public byte getIsOut() {
		return this.isOut;
	}

	public void setIsOut(byte isOut) {
		this.isOut = isOut;
	}

	public String getMpaaRating() {
		return this.mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrailerUrl() {
		return this.trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserRating() {
		return this.userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}