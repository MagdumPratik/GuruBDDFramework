package StepDefination;

import io.cucumber.java.en.Then;

public class closeStep extends BaseClass{

	@Then("close Browser")
	public void close_Browser() {
	   driver.close();
	   logger.info("****************Browser Closed !!*************");
	}
	
}
