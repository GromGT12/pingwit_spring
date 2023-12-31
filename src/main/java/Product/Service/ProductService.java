package Product.Service;

import Product.Controller.ProductDTO.ProductDTO;
import Product.Controller.ProductDTO.ProductFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface ProductService {



        Collection<ProductDTO> getAllProducts();

        ProductDTO getById(Integer id);

        Integer createProduct(ProductDTO productToCreate);

        void deleteProduct(Integer id);


        List<ProductDTO> searchByDescription(String description);

        ProductDTO updateProduct(Integer id, ProductDTO productToUpdate);

        List<ProductDTO> search(ProductFilterDTO filter);

        Page<ProductDTO> getPage(Pageable pageable);
}