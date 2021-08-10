package rb.prodcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "index")
public class Product {

    @Id
    @Field(type = FieldType.Long, name = "id")
    private Long Id;

    @Field(type = FieldType.Text, name = "name")
    @NotNull
    private String name;

    @Field(type = FieldType.Integer, name = "amount")
    @NotNull
    private Integer amount;
}
