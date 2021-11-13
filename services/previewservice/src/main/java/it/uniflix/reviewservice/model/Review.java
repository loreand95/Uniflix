package it.uniflix.reviewservice.model;


import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@XmlRootElement(name="Review")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
	
	@JsonIgnore
	private ObjectId _id;
	private String author;
	private String content;
	private String id;
	private String movieId;
	private String url;


	public Review() {
		super();
	}


	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Review [_id=" + _id + ", author=" + author + ", content=" + content + ", id=" + id + ", movieId="
				+ movieId + ", url=" + url + "]";
	}


}
