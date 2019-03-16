package Models;

/**
 *
 * @author Charles Brady
 *
 * Last Updated 3/5
 *
 * This is the model for the books class.
 */
public class Books {

    private String author;
    private String title;
    private String ISBN;
    private String category;
    private String imageLink;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String _author) {
        this.author = _author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String _ISBN) {
        this.ISBN = _ISBN;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String _category) {
        this.category = _category;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String _imageLink) {
        this.imageLink = imageLink;
    }
}
