package com.gill.spring5webapp.bootstrap;

import com.gill.spring5webapp.model.Author;
import com.gill.spring5webapp.model.Book;
import com.gill.spring5webapp.model.Publisher;
import com.gill.spring5webapp.repository.AuthorRepository;
import com.gill.spring5webapp.repository.BookRepository;
import com.gill.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }



    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "123 main ln XYZ");
        Book ddd = new Book("Domain Driven Design", "1234", harper);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rad = new Author("Rad", "Johnson");
        Publisher publisher = new Publisher("worx", "123fsd sdfs ABC");
        Book noEJB = new Book("J2EE dev without EJB", "23444", publisher);
        rad.getBooks().add(noEJB);
        publisherRepository.save(publisher);

        authorRepository.save(rad);
        bookRepository.save(noEJB);
    }


}
