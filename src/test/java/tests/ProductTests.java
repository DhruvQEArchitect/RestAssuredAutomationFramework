package tests;

import com.reporting.ReportingListeners;
import com.utils.ResponseUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.DynamicPayloads;

@Listeners(ReportingListeners.class)
public class ProductTests {

    @Test
    public void AddProduct() {
        ResponseUtils.postResponse(DynamicPayloads.getProductPayload()).prettyPeek();
    }
}
