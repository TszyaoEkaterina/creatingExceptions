package ru.netology;

public class Repository {
    private Product[] products = new Product[0];

    public void removeById(int id) {
        if (findById(id) == null){
            throw new NotFoundException(id);
        }
        Product[] tmp = new Product [products.length - 1];
        int index = 0;
        for (Product product:products) {
            if (product.getId() != id) {
                tmp[index] =product;
                index++;
            }
        }
        products= tmp;
    }
    public Product findById(int id){
        for (Product product: products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
    public void save(Product newProduct) {
        if (findById(newProduct.getId()) != null){
            throw new AlreadyExistsException(newProduct.getId());
        }
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products,0,tmp,0,products.length);
        tmp[tmp.length - 1] = newProduct;
        this.products = tmp;
    }
    public Product[] findAll() {
        return products;
    }
}
