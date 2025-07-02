package com.example.library;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;

    // Constructor injection
    public BookService(String serviceName) {
        this.serviceName = serviceName;
        System.out.println("Constructor Injection: Service name is " + serviceName);
    }

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBooks() {
        System.out.println("Service Name: " + serviceName);
        bookRepository.displayBooks();
    }
}