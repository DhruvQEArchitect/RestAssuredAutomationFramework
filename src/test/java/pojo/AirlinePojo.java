package pojo;

import com.utils.FakeDataBuilder;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
public class AirlinePojo {

    private String id = FakeDataBuilder.getRandomID();
    private String name = FakeDataBuilder.getRandomName();
    private String country = FakeDataBuilder.getRandomCountry();
    private String logo = FakeDataBuilder.getRandomLogo();
    private String slogan = FakeDataBuilder.getRandomSlogan();
    private String head_quaters = FakeDataBuilder.getRandomHeadquarter();
    private String website = FakeDataBuilder.getRandomWebsite();
    private String established = String.valueOf(FakeDataBuilder.getRandomYear());
}
