package com.example.storage.ecchi;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles
@TestPropertySource("classpath:application-data.properties")
public @interface storageEcchiApplicationTest {
	@AliasFor(annotation = ActiveProfiles.class, attribute = "profiles")
	String[] activeProfiles() default { "test" };
}
