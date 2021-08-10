package rb.prodcatalog.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rb.prodcatalog.exception.ProductIdNotFoundException;
import rb.prodcatalog.exception.ProductNameNotFoundException;
import rb.prodcatalog.model.Product;
import rb.prodcatalog.repository.ProductRepository;
import rb.prodcatalog.response.MessageResponse;
import rb.prodcatalog.service.ProductService;

import java.util.List;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public Iterable<Product> listAllProducts(@RequestBody Product Product) {
        return productService.findAll();
    }

    @GetMapping("/id/{ProductId}")
    public Product findProductById(@PathVariable("ProductId") Long ProductId) throws ProductIdNotFoundException {
        return productService.findById(ProductId);
    }

    @GetMapping("/name/{ProductName}")
    public List<Product> findProductById(@PathVariable("ProductName") String ProductName) throws ProductNameNotFoundException {
        return productService.findByName(ProductName);
    }

    @PutMapping("/id/{ProductId}")
    public MessageResponse updateProductById(@PathVariable("ProductId") Long ProductId, @RequestBody Product Product) throws ProductIdNotFoundException {
        return productService.updateProduct(ProductId, Product);
    }


    @DeleteMapping("/id/{ProductId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductByID(@PathVariable("ProductId") Long ProductId) throws Exception, ProductIdNotFoundException {
        productService.deleteProduct(ProductId);
    }
}
