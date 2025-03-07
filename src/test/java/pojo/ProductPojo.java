package pojo;

import com.utils.FakeDataBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductPojo {

    private int id = 20;
    private String title = FakeDataBuilder.getRandomTitle();
    private float price = FakeDataBuilder.getRandomPrice();
    private String description = FakeDataBuilder.getRandomDescription();
    private String category = FakeDataBuilder.getRandomTitle();
    private String image = FakeDataBuilder.getRandomWebsite();
}
