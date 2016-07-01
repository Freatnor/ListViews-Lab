package ly.generalassemb.drewmahrt.bookshelf;

/**
 * Created by drewmahrt on 12/16/15.
 */
public class Book {
    private String mTitle;
    private String mAuthor;
    private int mYearPublished;
    private int mPages;

    public Book(String title,String author, int yearPublished, int pages){
        mTitle = title;
        mAuthor = author;
        mYearPublished = yearPublished;
        mPages = pages;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public int getYearPublished() {
        return mYearPublished;
    }

    public int getPages() {
        return mPages;
    }
}
