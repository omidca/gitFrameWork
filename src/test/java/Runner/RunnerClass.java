package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/Resources/features/addEmployee.feature",

        glue = "Steps",

        dryRun = false,

        monochrome = true




)

public class RunnerClass {







}
