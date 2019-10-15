package com.atmecs.TaskKonakart.konakart_automation.helpers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.TaskKonakart.konakart.pageactions.PageActions;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;

public class SortingVerification extends BrowserInvoke {
	LogReport log = new LogReport();

	/**
	 * sortingVerify method checks the sorting of two types:low to high star rating
	 * and High to low star rating based on the star rating in the customer review
	 * page
	 *
	 */
	public void sortingVerify() throws IOException, InterruptedException {
		PageActions pageaction = new PageActions();
		pageaction.dropdown(FilePath.LOCATORS_FILE, "loc.review.dropdown", "Rating: low to high");
		Thread.sleep(5000);
		int size = driver.findElements(By.cssSelector(PropertiesFileReader.getData(FilePath.LOCATORS_FILE, "loc.size"))).size();
		int array[];
		array = new int[10];
		String textfirst = PropertiesFileReader.getData(FilePath.LOCATORS_FILE, "loc.textfirst");

		for (int i = 1; i <=size; i++) {
			int sizesec;
			String textsec = Integer.toString(i);
			String textthird = ") span[class='star full']";
			sizesec = driver.findElements(By.cssSelector(textfirst + textsec + textthird)).size();
			array[i - 1] = sizesec;
			System.out.println(array[i - 1]);

		}

		for (int i = 0; i < size-1; i++) {
			if (array[i] <= array[i + 1]) {
				log.info("Star ratings are in  ascending order");

			} else {
				log.info("Star ratings are not in  ascending order");
			}
		}
		pageaction.dropdown(FilePath.LOCATORS_FILE, "loc.review.dropdown", "Rating: high to low");
		Thread.sleep(5000);
		int array1[];
		array1 = new int[10];
		int i;
		for (i = 1; i <=size; i++) {
			int sizesec1;
			String textsec1 = Integer.toString(i);
			String textthird1 = ") span[class='star full']";
			sizesec1 = driver.findElements(By.cssSelector(textfirst + textsec1 + textthird1)).size();
			array1[i - 1] = sizesec1;
			System.out.println(array1[i - 1]);
		}
		for (int k = 0; k < size-1; k++) {
			if (array1[k ] >= array1[k+1]) {
				log.info("Star ratings are in  descending order");

			} else {
				log.info("Star ratings are not in  descending order");
			}
		}

	}

}
