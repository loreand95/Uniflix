package it.uniflix.reviewservice.model;


import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@XmlRootElement(name="Review")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
	
	private String author;
	private String content;
	private long movieId;
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

	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
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
		return "Review [author=" + author + ", content=" + content + ", movieId=" + movieId + ", url=" + url + "]";
	}

}
