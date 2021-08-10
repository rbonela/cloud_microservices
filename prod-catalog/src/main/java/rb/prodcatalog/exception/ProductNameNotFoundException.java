package rb.prodcatalog.exception;

public class ProductNameNotFoundException extends Exception{
    public ProductNameNotFoundException(String productName) {
        super("Product with name " + productName + " not found");
    }
}
