package tests;

import com.reporting.ReportingListeners;
import com.utils.ResponseUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pojo.DynamicPayloads;
import pojo.Mapper;

@Listeners(ReportingListeners.class)
public class ProductTests {

    @Test
    public void AddProduct() {
        Response response = ResponseUtils.postResponse(DynamicPayloads.getProductPayload()).prettyPeek();
        Assert.assertEquals(Mapper.getProductResponsePayload(response), DynamicPayloads.getProductPayload());
    }
}
