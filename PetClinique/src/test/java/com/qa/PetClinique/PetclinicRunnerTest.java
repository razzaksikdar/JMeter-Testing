package com.qa.PetClinique;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/assessment.feature")

public class PetclinicRunnerTest {

}
