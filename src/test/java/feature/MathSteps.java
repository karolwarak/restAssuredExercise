package feature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MathSteps {

    private int minuend;
    private List<Integer> subtrahends = new ArrayList();

    @Given ("^I have (\\d+)$")
    public void i_have(int minuend)
    {
        this.minuend = minuend;
    }

    @When ("^I subtracted (\\d+)$")
    public void i_subtract(int subtrahend)
    {
        this.subtrahends.add(subtrahend);
    }

//    @When ("^I subtracted (.*)$")
//    public void followingNumbers(List<Integer> subtrahends)
//    {
//        this.subtrahends.addAll(subtrahends);
//    }


    @Then ("^I have result (\\d+)$")
    public void i_have_result_second(int expectedResult)
    {
        int actualResult = minuend;
        for (int subtrahend : subtrahends)
        {
            actualResult -= subtrahend;
        }
        assertThat(actualResult, equalTo(expectedResult));
    }


}