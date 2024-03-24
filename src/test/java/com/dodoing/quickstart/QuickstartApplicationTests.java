package com.dodoing.quickstart;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest // junit에서 spring boot의 기술을 사용할 수 있게 연결함
@Slf4j
class QuickstartApplicationTests {

	@Value("${ip}")
	String ip;

	@Test
	void iptest() {
		assertEquals("192.168.0.1", ip);
	}

	@Test
	void serverTest(@Value("${server.user.id}") String id, @Value("${server.user.age}") int age,
			@Value("${server.url}") String url, @Value("${server.domain.name}") String domain) {
		assertAll(() -> assertEquals("hong", id), () -> assertEquals(20, age),
				() -> assertEquals("http://192.168.0.1", url), () -> assertEquals("com.doding", domain));

	}

	@Test
	void listTest1(@Value("${member.names}") List<String> names) {
		assertEquals(List.of("hong", "jang", "lim"), names);
	}

	@Test
	void listTest2(@Value("${members.skils[0]}") String firstSkil) {
		assertEquals(firstSkil, "java");
	}

	@Test
	void multiDoc(@Value("${members.skils[1]}") String secondSkill) {
		assertEquals("python", secondSkill);
	}

	@Test
	void logTest() {
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
	}

}
