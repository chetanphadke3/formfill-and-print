package helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsExecutor {

	private JavascriptExecutor jse = null;
	private Map<String, Object> map = null;

	public void avaformInTest(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(5000);
		jse = ((JavascriptExecutor) driver);
		FileRead fr = new FileRead();
		String file = "C:\\chetan.phadke\\putForm.js";

		String script = fr.readFile(file);
		jse.executeScript(script);

		System.out.println("Avaform in test mode");

	}

	public void printData() {
		map = new HashMap<>();
		map = (Map<String, Object>) jse.executeScript("return ava.marketingapi.payload;");

		for (String key : map.keySet()) {
			System.out.println(key + "" + map.values());
		}

		System.out.println("Transaction id-> " + map.get("transaction_id"));

		Map data = (Map) map.get("data");
		System.out.println(data.get("email"));
	}

}
