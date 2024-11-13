import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Book implements Serializable {
    @JsonProperty("titulo")
    private String title;
    @JsonProperty("autor")
    private String author;
    @JsonProperty("año")
    private int year;

    public Book(){

    }
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }


    // Getters y Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
    }
}
