package tests.books;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/tests/books/books.feature",
        glue = {""},
        plugin = {"html:test-output/cucumber_reports/books.html"},
        monochrome = true
)
public class BooksTestRunner extends AbstractTestNGCucumberTests {
}
