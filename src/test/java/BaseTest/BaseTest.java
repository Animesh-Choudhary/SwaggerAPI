package BaseTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.Objects;


public class BaseTest {
    @BeforeSuite
    public void cleanAllureResults() {
        File allureResults = new File("allure-results");
        if (allureResults.exists()) {
            for (File file : Objects.requireNonNull(allureResults.listFiles())) {
                file.delete();
            }
        }
        System.out.println("✅ Allure results cleared before test execution.");
    }

    @AfterSuite
    public void generateAllureReport() {
        try {
            Process process = Runtime.getRuntime().exec("allure generate allure-results --clean -o reports/allure-report");
            process.waitFor();
            System.out.println("📊 Allure report generated successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to generate Allure report: " + e.getMessage());
        }
    }
}
