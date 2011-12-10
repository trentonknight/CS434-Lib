/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import library.business.BookMgr;
import library.domain.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trentonknight
 */
public class IBookSvcJDBCImplTest {
    
    public IBookSvcJDBCImplTest() {
    }
        String title = "testTitle";
        String isbn = "testISBN";
        String author = "testAuthor";
    
    /**
     * Test of add method, of class IBookSvcJDBCImpl.
     */
    @Test public void testAdd() {
        
        try {
            Book book = new Book();
            book.setTitle("testTitle");
            book.setIsbn("testISBN");
            book.setAuthor("testAuthor");
            BookMgr bkmgr = new BookMgr();
            book = bkmgr.createBook(book);
            assertEquals(title,book.getTitle());
            assertEquals(isbn,book.getIsbn());
            assertEquals(author,book.getAuthor());
            
        } catch (Exception ex) {
            Logger.getLogger(IBookSvcJDBCImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

   
}

    /**
     * Test of retrieve method, of class IBookSvcJDBCImpl.
     */
    @Test
    public void testRetrieve() {
        try {
            Book book = new Book();
            book.setTitle("testTitle");
            book.setIsbn("testISBN");
            book.setAuthor("testAuthor");
            BookMgr bkmgr = new BookMgr();
            book = bkmgr.retBook(book);
            assertEquals(title,book.getTitle());
            assertEquals(isbn,book.getIsbn());
            assertEquals(author,book.getAuthor());
        } catch (Exception ex) {
            Logger.getLogger(IBookSvcJDBCImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
}
