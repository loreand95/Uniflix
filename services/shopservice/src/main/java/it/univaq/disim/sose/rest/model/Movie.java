package it.univaq.disim.sose.rest.model;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@XmlRootElement(name="Movies")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	@JsonIgnore
	private ObjectId id;
	private String title;
	private String originalTitle;
	private Double popularity;
	private String backdropPath;
	private String posterPath;
	private String releaseDate;
	private boolean adult;
	private long budget;
	private List<Genre> genres;
	private String homepage;
	private String overview;
	private String imdbID;
	private String originalLanguage;
	private List<ProductionCompany> productionCompanies;
	private long revenue;
	private int runtime;
	private Double voteAverage;
	private int voteCount;
	private String status;
	private long movieId;
	private List<ActorCast> cast;
	private List<Review> reviews;
	
	public List<ActorCast> getCast() {
		return cast;
	}

	public void setCast(List<ActorCast> cast) {
		this.cast = cast;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Movie() {}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public List<ProductionCompany> getProductionCompanies() {
		return productionCompanies;
	}

	public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adult, backdropPath, budget, cast, genres, homepage, id, imdbID, movieId, originalLanguage,
				originalTitle, overview, popularity, posterPath, productionCompanies, releaseDate, revenue, reviews,
				runtime, status, title, voteAverage, voteCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return adult == other.adult && Objects.equals(backdropPath, other.backdropPath) && budget == other.budget
				&& Objects.equals(cast, other.cast) && Objects.equals(genres, other.genres)
				&& Objects.equals(homepage, other.homepage) && Objects.equals(id, other.id)
				&& Objects.equals(imdbID, other.imdbID) && movieId == other.movieId
				&& Objects.equals(originalLanguage, other.originalLanguage)
				&& Objects.equals(originalTitle, other.originalTitle) && Objects.equals(overview, other.overview)
				&& Objects.equals(popularity, other.popularity) && Objects.equals(posterPath, other.posterPath)
				&& Objects.equals(productionCompanies, other.productionCompanies)
				&& Objects.equals(releaseDate, other.releaseDate) && revenue == other.revenue
				&& Objects.equals(reviews, other.reviews) && runtime == other.runtime
				&& Objects.equals(status, other.status) && Objects.equals(title, other.title)
				&& Objects.equals(voteAverage, other.voteAverage) && voteCount == other.voteCount;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", originalTitle=" + originalTitle + ", popularity="
				+ popularity + ", backdropPath=" + backdropPath + ", posterPath=" + posterPath + ", releaseDate="
				+ releaseDate + ", adult=" + adult + ", budget=" + budget + ", genres=" + genres + ", homepage="
				+ homepage + ", overview=" + overview + ", imdbID=" + imdbID + ", originalLanguage=" + originalLanguage
				+ ", productionCompanies=" + productionCompanies + ", revenue=" + revenue + ", runtime=" + runtime
				+ ", movieId=" + movieId + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount + ", status="
				+ status + "]";
	}

}
