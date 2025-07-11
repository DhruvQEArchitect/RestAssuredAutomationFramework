import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = true,
        monochrome = true,
//        glue = "com/stepdef",
        features = "src/test/resources/features",
        tags = "@BDD",
        publish = true
)
public class CucumberDriver extends AbstractTestNGCucumberTests {


}
