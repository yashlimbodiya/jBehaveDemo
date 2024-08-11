package JBehaveDemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class Steps {
	
	private int threhold;
	private String message;
	
	@Given("a stock of symbol STK1 and a threshold of $threshold")
	public void m1(int threshold) {
		this.threhold = threshold;
	}
	
	@When("the stock is traded at $threshold")
	public void whenMethod(int inputThreshold) {
		if(this.threhold > inputThreshold) {
			this.message = "Greater";
		} else {
			this.message = "Smaller";
		}
	}
	
	@Then("the alert status should be ON")
	public void thenMethod() {
		System.out.println("Message: " + this.message);
	}

}
