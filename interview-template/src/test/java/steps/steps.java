package steps;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
	
	@Given("the user has access to the current block {int} {int}")
	public void the_user_has_access_to_the_current_block(int current, int previous) throws IOException {
		URL url1 = new URL("https://api.blockcypher.com/v1/btc/main/blocks/"+current);
		HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
		con1.setRequestMethod("GET");
		con1.connect();
		int responsecode = con1.getResponseCode();
		if(responsecode != 200) {
			System.out.println("Something went wrong.");			
		}
		else {
			String inline = null;
			Scanner sc = new Scanner(url1.openStream());
			while(sc.hasNext())
			{
				inline = inline + sc.nextLine();
			}
			System.out.println("\nJSON data in string format");
			System.out.println(inline);
			sc.close();		
		}
	}
	
	@When("the user calls the API with previous block {int} {int}")
	public void the_user_calls_the_API_with_previous_block(int current, int previous) throws IOException {
		URL url2 = new URL("https://api.blockcypher.com/v1/btc/main/blocks/"+previous);
		HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
		con2.setRequestMethod("GET");
		con2.connect();
		int responsecode = con2.getResponseCode();
		if(responsecode != 200) {
			System.out.println("Something went wrong.");			
		}
		else {
			String inline = null;
			Scanner sc = new Scanner(url2.openStream());
			while(sc.hasNext())
			{
				inline = inline + sc.nextLine();
			}
			System.out.println("\nJSON data in string format");
			System.out.println(inline);
			sc.close();		
		}	
	}
	
	@Then("the prev_block field of current block is equal to hash field of previous block")
	public void the_prev_block_field_of_current_block_is_equal_to_hash_field_of_previous_block() {
		//validation is missing here
	}

}
