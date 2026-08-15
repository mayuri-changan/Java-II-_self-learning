package com.demo.Q15SpringTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.demo.controller.HelloController;

public class Q15SpringTestApplicationTests {

	private final HelloController controller = new HelloController();

	@Test
	void testSayHello() {
		String response = controller.sayHello();
		assertThat(response).isEqualTo("Hello, mayuri! Your Spring app is working.");
	}
}
