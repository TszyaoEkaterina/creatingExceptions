package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Book first = new Book(1, "book", 111, "bookName","Masha");
    Book second = new Book(2, "book", 222, "bookName","Tom");
    Smartphone third = new Smartphone(3, "smartphone", 333, "smartphoneName", "Apple");
    Smartphone forth = new Smartphone(4, "smartphone", 444, "smartphoneName", "Sony");

    @Test
    void shouldAddWithRepoEmpty() {
        manager.add(first);
        Product[] actual = manager.findAll();
        Product[] expected = {first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldAddWithRepoNotEmpty() {
        manager.add(first);
        manager.add(second);

        manager.add(third);
        Product[] actual = manager.findAll();
        Product[] expected = {first, second, third};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveByIdOfExistingProduct() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);

        manager.removeById(4);
        Product[] actual = manager.findAll();
        Product[] expected = {first, second,third};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldThrowExceptionIfRemoveByInvalidId() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        //manager.removeById(5);
        assertThrows(NotFoundException.class,()->{
            manager.removeById(5);
        });
    }
    @Test
    void shouldThrowExceptionIfAddExistingProduct() {
        manager.add(first);
        manager.add(second);

        //manager.add(second);
        assertThrows(AlreadyExistsException.class, () -> {
            manager.add(second);
        });
    }

}