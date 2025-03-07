package pojo;

import com.utils.FakeDataBuilder;

public class DynamicPayloads {

    public static AirlinePojo getDynamicPayload() {
        return AirlinePojo.builder().id(FakeDataBuilder.getRandomID()).name(FakeDataBuilder.getRandomName()).country(FakeDataBuilder.getRandomCountry()).logo(FakeDataBuilder.getRandomLogo()).slogan(FakeDataBuilder.getRandomSlogan()).head_quaters(FakeDataBuilder.getRandomHeadquarter()).website(FakeDataBuilder.getRandomWebsite()).established(String.valueOf(FakeDataBuilder.getRandomYear())).build();
    }

    public static ProductPojo getProductPayload() {
        return ProductPojo.builder().id(21).title(FakeDataBuilder.getRandomTitle()).price(FakeDataBuilder.getRandomPrice())
                .description(FakeDataBuilder.getRandomDescription()).category(FakeDataBuilder.getRandomTitle()).image(FakeDataBuilder.getRandomWebsite()).build();
    }

}
