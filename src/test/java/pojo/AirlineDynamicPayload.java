package pojo;

import com.utils.FakeDataBuilder;

public class AirlineDynamicPayload {

    public static AirlinePojo getDynamicPayload() {
        return AirlinePojo.builder().id(FakeDataBuilder.getRandomID()).name(FakeDataBuilder.getRandomName()).country(FakeDataBuilder.getRandomCountry()).logo(FakeDataBuilder.getRandomLogo()).slogan(FakeDataBuilder.getRandomSlogan()).head_quaters(FakeDataBuilder.getRandomHeadquarter()).website(FakeDataBuilder.getRandomWebsite()).established(String.valueOf(FakeDataBuilder.getRandomYear())).build();
    }

}
