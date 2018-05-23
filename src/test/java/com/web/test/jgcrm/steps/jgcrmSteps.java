package com.web.test.jgcrm.steps;

import com.web.test.common.framework.testData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class jgcrmSteps {
	public testData data;
	public jgcrmSteps(testData data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}
	
	@Given("^用户打开jgcrm登录界面$")
	public void input_username() throws Throwable {
	   data.jgcrmLoginPage.go();
	}

	@Given("^输入用户账号\"([^\"]*)\"和密码\"([^\"]*)\"$")
	public void input_password(String name,String passw) throws Throwable {
		data.jgcrmLoginPage.inputUserNamePassWord(name, passw);
	}

	@When("^点击登录按钮$")
	public void click_login_button() throws Throwable {
		data.jgcrmLoginPage.clickLoginButton();
	}

	@Then("^登录成功$")
	public void login_success() throws Throwable {
		System.out.println("登录成功");
		Thread.sleep(3000);
	}
}

