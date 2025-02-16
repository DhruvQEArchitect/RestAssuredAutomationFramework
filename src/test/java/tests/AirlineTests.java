package tests;

import com.utils.ResponseUtils;
import org.testng.annotations.Test;
import pojo.AirlineDynamicPayload;

public class AirlineTests {

    @Test
    public void CreateAirline() {
        ResponseUtils.postResponse(AirlineDynamicPayload.getDynamicPayload()).prettyPeek();
    }
}
