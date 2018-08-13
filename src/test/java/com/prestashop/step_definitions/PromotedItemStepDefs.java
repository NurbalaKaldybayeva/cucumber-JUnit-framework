package com.prestashop.step_definitions;

import java.util.List;
import java.util.Map;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.ExcelUtil;
import static org.junit.Assert.*;
import cucumber.api.java.en.Then;

public class PromotedItemStepDefs {
	HomePage homePage = new HomePage();
	ItemPage itemPage = new ItemPage();

	@Then("the system should display the promoted items")
	public void the_system_should_display_the_promoted_items() {
		ExcelUtil excelObject = new ExcelUtil("src/test/resources/com/prestashop/test-data/Products.xlsx", "Sheet1");
		List<Map<String, String>> allRows = excelObject.getDataList();
		for (Map<String, String> row : allRows) {
			String product = row.get("Product");
			if (row.get("Execute").equalsIgnoreCase("y")) {
				System.out.println("Testing" + product);
				assertTrue(homePage.item(product).isDisplayed());
			} else {
				System.out.println("Skip" + product);
			}
		}
	}

	@Then("the item details should be correct")
	public void the_item_details_should_be_correct() {
		ExcelUtil excelObject = new ExcelUtil("src/test/resources/com/prestashop/test-data/Products.xlsx", "Sheet1");
		List<Map<String, String>> allRows = excelObject.getDataList();
		for(int i=0; i <allRows.size(); i++){
			Map<String, String> row=allRows.get(i);
		
			String product = row.get("Product");
			if (row.get("Execute").equalsIgnoreCase("y")) {
				homePage.item(product).click();
				String price = row.get("Price");
				String color = row.get("Color");
				String style = row.get("Styles");
				System.out.println(price + color + style);
				// actual value from UI
				String actualPrice = itemPage.price.getText();
				String actualColor = itemPage.selectedColor.getAttribute("name");
				String actualStyle = itemPage.styles.getText();
				if (price.endsWith(".0")) {
					price = "$" + price + "0";

				} else {
					price = "$" + price;
				}

				assertEquals(price, actualPrice);
				assertEquals(color, actualColor);
				assertEquals(style, actualStyle);
				Driver.getDriver().navigate().back();

				// excelObject.setCellData("pass", "Status", i+1);
			} else {
				System.out.println("Skip" + product);
				// excelObject.setCellData("skiped", "Status", i+1);
			}
		}
	}
}
