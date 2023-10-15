package com;

import org.testng.annotations.Test;

import dv.DataSource;

public class DataDrivenTest {

	@Test(dataProviderClass = DataSource.class,dataProvider="ronzu")
	public void f(Object n, Object s) {
		System.out.println(n);//user1 user2
		System.out.println(s);//pass1 pass2
	}
	@Test(dataProviderClass = DataSource.class,dataProvider="write data")
	public void sendData() {
		System.out.println("this is send data method");
		
	}

}
