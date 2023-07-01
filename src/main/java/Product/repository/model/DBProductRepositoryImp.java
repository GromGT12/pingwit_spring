package Product.repository.model;

import Product.model.Product;
import Product.repository.ProductRepository;

import java.util.Collection;

public class DBProductRepositoryImp implements ProductRepository{
    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Collection<Product> getAll() {
        return null;
    }

    @Override
    public void delete(Integer productId) {

    }

    @Override
    public Integer createProduct(Product productToCreate) {
        return null;
    }
}
