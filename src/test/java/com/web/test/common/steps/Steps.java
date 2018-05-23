package com.web.test.common.steps;





import com.web.test.common.framework.testData;

import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Steps {
    public testData data;
    public Steps(testData data) {
		// TODO Auto-generated constructor stub
    	 this.data =data;
	}
	@Before
	public void init() {
       data.initTestData();
	}

	@After
	public void clean() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        data.quit();
        
	}
}
