package ru.netology;

public class ProductManager {
    Repository repo = new Repository();
    
    public ProductManager() {
    }
    
    public void add(Product newProduct) {
        repo.save(newProduct);
    }
    
    public void removeById(int id) {
        repo.removeById(id);
    }
    
    public Product[] findAll() {
        return repo.findAll();
    }
}
