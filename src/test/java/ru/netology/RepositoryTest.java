package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();
    Book first = new Book(1, "book", 111, "bookName", "Masha");
    Book second = new Book(2, "book", 222, "bookName", "Tom");
    Smartphone third = new Smartphone(3, "smartphone", 333, "smartphoneName", "apple");
    Smartphone forth = new Smartphone(4, "smartphone", 444, "smartphoneName", "sony");

    @Test
    void shouldRemoveByIdOfExistingProduct() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);

        repo.removeById(4);
        Product[] actual = repo.findAll();
        Product[] expected = {first, second,third};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldThrowExceptionIfRemoveByInvalidId() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);

        assertThrows(NotFoundException.class,()->{
            repo.removeById(5);
        });
    }
}