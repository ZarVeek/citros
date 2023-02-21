package ru.appline.framework.basetestsclass;

import com.google.gson.Gson;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;
import ru.appline.framework.startParameters.POJOParams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static ru.appline.framework.utils.PropConst.*;

public class BaseTests {

    /**
     * Менеджер страничек
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private final DriverManager driverManager = DriverManager.getDriverManager();

    private final Gson gson = new Gson();

    private final BufferedReader br;
    {
        try {
            br = new BufferedReader(new FileReader(START_PARAMETERS_FOR_TEST));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected final POJOParams pojoParams = gson.fromJson(br, POJOParams.class);

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeMethod
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
