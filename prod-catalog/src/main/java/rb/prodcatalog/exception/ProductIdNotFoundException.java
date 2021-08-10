package rb.prodcatalog.exception;

public class ProductIdNotFoundException extends Exception{
    public ProductIdNotFoundException(Long id) {
        super("Product with ID " + id + " not found");
    }
}
