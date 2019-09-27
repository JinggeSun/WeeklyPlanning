package com.sun.restFulApi.controller;

import com.sun.javafx.binding.StringFormatter;
import com.sun.restFulApi.entity.Book;
import com.sun.restFulApi.exception.InvalidException;
import com.sun.restFulApi.exception.ResourceException;
import com.sun.restFulApi.repository.BookRepository;
import com.sun.restFulApi.repository.BookRestRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zcm
 */
@RestController
@RequestMapping("/v1")
public class BookController {

    private BookRestRepository bookRepository;

    @Autowired
    public BookController(BookRestRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @GetMapping("/books")
    public HttpEntity<?> books(){
        List<Book> books= (List<Book>) bookRepository.findAll();
        if (books == null || books.isEmpty()) {
            throw new ResourceException("Not find book");
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public HttpEntity<?> booksone(@PathVariable Long id){
        return new ResponseEntity<>(bookRepository.findById(id).
                orElseThrow(()-> new ResourceException(String.format("book id %s not found",id))),HttpStatus.OK);
    }

    @PutMapping("/books")
    public HttpEntity<?> addBook(@Valid @RequestBody Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new InvalidException("Invaild",bindingResult);
        }
        book.setId(null);
        return new ResponseEntity<>(bookRepository.save(book),HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public HttpEntity<?> search(@PathVariable String author){
        return new ResponseEntity<>(bookRepository.findBookByAuthor(author), HttpStatus.OK);
    }


    @PatchMapping("/books/{id}")
    public HttpEntity<?> booksPatch(@PathVariable Long id, @RequestBody Book book) {
        Book exist = bookRepository.findById(id).get();
        BeanWrapper beanWrapper = new BeanWrapperImpl(book);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : propertyDescriptors) {
            if (beanWrapper.getPropertyValue(pd.getName()) == null) {
                nullPropertyNames.add(pd.getName());
            }
        }
        BeanUtils.copyProperties(book, exist, nullPropertyNames.toArray(new String[nullPropertyNames.size()]));
        return new ResponseEntity<>(bookRepository.save(exist), HttpStatus.OK);
    }

    /**
     * 删除一个书单
     * DELETE  /api/v1/books/{id}   删除一条书单
     *
     * @param id id
     * @return http 响应
     */
    @DeleteMapping("/books/{id}")
    public HttpEntity<?> booksDeleteOne(@PathVariable Long id) {
        Book exist = bookRepository.findById(id).get();
        bookRepository.deleteById(exist.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 删除所有书单
     * DELETE  /API/v1/books        删除所有书单
     *
     * @return http 响应
     */
    @DeleteMapping("/books")
    public HttpEntity<?> booksDeleteAll() {
        bookRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
