package tests;

import com.reporting.ReportingListeners;
import com.utils.ResponseUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.AirlineDynamicPayload;

@Listeners(ReportingListeners.class)
public class AirlineTests {

    @Test
    public void CreateAirline() {
        ResponseUtils.postResponse(AirlineDynamicPayload.getDynamicPayload()).prettyPeek();
    }
}
