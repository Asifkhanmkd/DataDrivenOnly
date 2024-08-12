package com.testProject.rough;

import java.util.Date;

import com.testProject.utilities.TestUtil;

public class AnotherRoughTest {

	public static void main(String[] args) {
		
		Date date = new Date();
		String d = date.toString().replace(":", "-").replace(" ", "-");
		
		System.out.println(d);

	}

}
