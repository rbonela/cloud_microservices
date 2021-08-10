package rb.prodcatalog.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import rb.prodcatalog.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByName(String name);

}
