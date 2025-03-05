package tests;

import com.reporting.ReportingListeners;
import com.utils.ResponseUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportingListeners.class)
public class PopulationTests {

    @Test
    public void getPopulationData() {
        ResponseUtils.getResponse("").prettyPrint();
    }

}
