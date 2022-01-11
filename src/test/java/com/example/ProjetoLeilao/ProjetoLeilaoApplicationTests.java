package com.example.ProjetoLeilao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProjetoLeilaoApplicationTests {

	@Test
	void contextLoads() {

		Boolean expected = true;
		Boolean result = false;

		// aqui voce escreve seu codigo e seta a variavel result

		result = true;

		assertThat(result).isEqualTo(expected);

	}

}
