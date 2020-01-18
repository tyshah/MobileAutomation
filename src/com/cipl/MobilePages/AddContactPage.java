package com.cipl.MobilePages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddContactPage {
	public AddContactPage() {
		PageFactory.initElements(new AppiumFieldDecorator(TestBase.getMobileDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Add Contact']")
	private AndroidElement btnAddContact;
	
	@AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
	private AndroidElement txtContactName;
	
	@AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
	private AndroidElement txtContactPhone;
	
	public AndroidElement getbtnAddContact() {
		return btnAddContact;
	}
	
	public AndroidElement gettxtContactName() {
		return txtContactName;
	}
	
	public AndroidElement gettxtContactPhone() {
		return txtContactPhone;
	}
}
