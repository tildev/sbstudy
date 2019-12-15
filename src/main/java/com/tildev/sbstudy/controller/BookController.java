/**
 * 
 */
package com.tildev.sbstudy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tildev.sbstudy.dto.BookVO;
import com.tildev.sbstudy.repository.BookRepository;

/**
 * @author tildev
 * @date   2019. 12. 15.
 *
 */
@Controller
@RequestMapping("/")
public class BookController {
    private static final String reader = "tildev";
    
    private BookRepository bookRepository;
    
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @GetMapping
    public String readerBooks(Model model) {
        List<BookVO> bookList = bookRepository.findByReader(reader);
        if(bookList!=null) {
            model.addAttribute("books", bookList);
        }
        return "bookList";
    }
    
    @PostMapping
    public String addToBookList(BookVO book) {
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/";
    }

}
