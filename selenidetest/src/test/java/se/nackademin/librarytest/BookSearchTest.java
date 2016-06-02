package se.nackademin.librarytest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.model.Book;

/**
 *
 * @author nicklas
 */

public class BookSearchTest extends TestBase{
    
    @Test
    public void bookSearchTest(){
            // Creating a book to work with
        Book createdBook = BookHelper.createBook(null,"Stephen Baxter", null, null, null, null);
        
        Book searchedBook = BookHelper.searchForBookAndReturnFirstHit(createdBook.getTitle(), null, null, null);
        assertEquals("Book was found using title search, title displayed correct",createdBook.getTitle(),searchedBook.getTitle());

        searchedBook = BookHelper.searchForBookAndReturnFirstHit(createdBook.getTitle(), createdBook.getAuthor(), null, null);
        assertEquals("Book was found using title and author search, author displayed correct",createdBook.getAuthor(),searchedBook.getAuthor());
        
        searchedBook = BookHelper.searchForBookAndReturnFirstHit(null, null,createdBook.getIsbn(), null);
        assertEquals("Book was found using isbn search, title displayed correct",createdBook.getTitle(),searchedBook.getTitle());
        assertEquals("Book was found using isbn search, isbn displayed correct",createdBook.getIsbn(),searchedBook.getIsbn());

        searchedBook = BookHelper.searchForBookAndReturnFirstHit(createdBook.getTitle(), null,null,createdBook.getDatePublished());
        assertEquals("Book was found using date published search, title displayed correct",createdBook.getTitle(),searchedBook.getTitle());
        assertEquals("Book was found using date published search, date displayed correct",createdBook.getDatePublished(),searchedBook.getDatePublished());
    }
}
