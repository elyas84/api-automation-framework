package base;


import listeners.TestListeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListeners.class)
public class TestBase {
    private static final Logger logger = LogManager.getLogger(TestBase.class.getName());

    @BeforeClass(alwaysRun = true)
    public void setup() {

    }
}
