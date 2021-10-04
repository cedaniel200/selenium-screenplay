package com.cedaniel200.github.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/create_repository.feature",
        glue = {"com.cedaniel200.github.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class GitHubTestRunner {
}
