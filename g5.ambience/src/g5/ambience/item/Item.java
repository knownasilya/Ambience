package g5.ambience.item;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private int item_id;

	@Column(length=45)
	private String developer;

	@Column(length=45)
	private String director;

	@Column(name="esrb_rating", length=10)
	private String esrb_rating;

	@Column(nullable=false, length=45)
	private String genre;

	@Column(name="image_url", nullable=false, length=200)
	private String image_url;

	@Column(name="is_out", nullable=false)
	private byte is_out;

	@Column(name="mpaa_rating", length=5)
	private String mpaa_rating;

	@Column(length=45)
	private String platform;

	@Column(name="reference_number", nullable=false)
	private int reference_number;

    @Temporal( TemporalType.DATE)
	@Column(name="release_year", nullable=false)
	private Date release_year;

	@Column(nullable=false, length=500)
	private String synopsis;

	@Column(nullable=false, length=45)
	private String title;

	@Column(name="trailer_url", length=200)
	private String trailer_url;

	@Column(nullable=false, length=45)
	private String type;

	@Column(name="user_rating")
	private int user_rating;

    public Item() {
    }

	public int get_item_id() {
		return this.item_id;
	}

	public void set_item_id(int item_id) {
		this.item_id = item_id;
	}

	public String get_developer() {
		return this.developer;
	}

	public void set_developer(String developer) {
		this.developer = developer;
	}

	public String get_director() {
		return this.director;
	}

	public void set_director(String director) {
		this.director = director;
	}

	public String get_esrb_rating() {
		return this.esrb_rating;
	}

	public void set_esrb_rating(String esrb_rating) {
		this.esrb_rating = esrb_rating;
	}

	public String get_genre() {
		return this.genre;
	}

	public void set_genre(String genre) {
		this.genre = genre;
	}

	public String get_image_url() {
		return this.image_url;
	}

	public void set_image_url(String image_url) {
		this.image_url = image_url;
	}

	public byte get_is_out() {
		return this.is_out;
	}

	public void set_is_out(byte is_out) {
		this.is_out = is_out;
	}

	public String get_mpaa_rating() {
		return this.mpaa_rating;
	}

	public void set_mpaa_rating(String mpaa_rating) {
		this.mpaa_rating = mpaa_rating;
	}

	public String get_platform() {
		return this.platform;
	}

	public void set_platform(String platform) {
		this.platform = platform;
	}

	public int get_reference_number() {
		return this.reference_number;
	}

	public void set_reference_number(int reference_number) {
		this.reference_number = reference_number;
	}

	public Date get_release_year() {
		return this.release_year;
	}

	public void set_release_year(Date release_year) {
		this.release_year = release_year;
	}

	public String get_synopsis() {
		return this.synopsis;
	}

	public void set_synopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String get_title() {
		return this.title;
	}

	public void set_title(String title) {
		this.title = title;
	}

	public String get_trailer_url() {
		return this.trailer_url;
	}

	public void set_trailer_url(String trailer_url) {
		this.trailer_url = trailer_url;
	}

	public String get_type() {
		return this.type;
	}

	public void set_type(String type) {
		this.type = type;
	}

	public int get_user_rating() {
		return this.user_rating;
	}

	public void set_user_rating(int user_rating) {
		this.user_rating = user_rating;
	}

}