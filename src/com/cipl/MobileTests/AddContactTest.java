package com.cipl.MobileTests;

import org.testng.annotations.Test;

import com.cipl.MobilePages.AddContactPage;
import com.cipl.MobilePages.TestBase;

public class AddContactTest {

	@Test(description = "Clicking on add contact", priority = 1)
	public void TC1() {
		AddContactPage addcontactpage = new AddContactPage();
		TestBase.WaitForElementPresent(addcontactpage.getbtnAddContact());
		addcontactpage.getbtnAddContact().click();
		TestBase.WaitForElementPresent(addcontactpage.gettxtContactName());
		addcontactpage.gettxtContactName().sendKeys("Tithi Shah");
		addcontactpage.gettxtContactPhone().sendKeys("4856934989");
	}

}
