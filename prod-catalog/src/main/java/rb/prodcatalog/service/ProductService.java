package rb.prodcatalog.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rb.prodcatalog.exception.ProductIdNotFoundException;
import rb.prodcatalog.exception.ProductNameNotFoundException;
import rb.prodcatalog.model.Product;
import rb.prodcatalog.repository.ProductRepository;
import rb.prodcatalog.response.MessageResponse;
import java.util.List;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository productRepository;

    public MessageResponse saveProduct(final Product product) {
        return createResponse(productRepository.save(product), "added to");
    }

    public Product findById(Long productId) throws ProductIdNotFoundException {
        return verifyIfExists(productId);
    }

    public List<Product> findByName(String productName) throws ProductNameNotFoundException {
        try {
            return productRepository.findByName(productName);
        }catch (Exception e){
            throw new ProductNameNotFoundException(productName);
        }
    }

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }


    public void deleteProduct(Long productId) throws ProductIdNotFoundException {
        verifyIfExists(productId);
        productRepository.deleteById(productId);
    }

    public MessageResponse updateProduct(Long productId, Product product) throws ProductIdNotFoundException {
        verifyIfExists(productId);
        return createResponse(productRepository.save(product),"updated in");
    }


    private Product verifyIfExists(long productId) throws ProductIdNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductIdNotFoundException(productId));
    }


    private MessageResponse createResponse(Product product, String string) {
        return MessageResponse
            .builder()
            .message("Product with name " + product.getName() + " and ID " + product.getId()  + "  " + string + " database" )
            .build();
    }

}
