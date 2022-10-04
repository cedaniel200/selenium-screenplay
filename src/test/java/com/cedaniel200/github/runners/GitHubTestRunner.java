package com.cedaniel200.github.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/create_repository.feature",
        glue = {"com.cedaniel200.github.stepdefinitions"},
        plugin = { "pretty",  "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class GitHubTestRunner {
}
