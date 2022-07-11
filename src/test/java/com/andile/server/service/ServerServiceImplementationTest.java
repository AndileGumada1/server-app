package com.andile.server.service;

import com.andile.server.repository.ServerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class ServerServiceImplementationTest {
   private ServerRepository repository;
   private AutoCloseable autoCloseable;
   private ServerServiceImplementation serviceImplementation;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        serviceImplementation= new ServerServiceImplementation(repository);
    }

    @Test
    void testToCreateServerResource() {
    }

    @Test
    void ping() {
    }

    @Test
    void list() {
     int limit = 0;
     //when
     //serviceImplementation.list(of(0,limit)).toList();

     //
     verify(repository.findAll());
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void setServerImageUrl() {
    }

    @AfterEach
    void tearDown() {
     try {
      autoCloseable.close();
     } catch (Exception e) {
      throw new RuntimeException(e);
     }
    }
}