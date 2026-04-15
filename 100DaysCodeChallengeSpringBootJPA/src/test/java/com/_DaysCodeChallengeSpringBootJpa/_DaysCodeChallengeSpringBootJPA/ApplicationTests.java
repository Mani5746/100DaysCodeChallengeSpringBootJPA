package com._DaysCodeChallengeSpringBootJpa._DaysCodeChallengeSpringBootJPA;

import com._DaysCodeChallengeSpringBootJpa._DaysCodeChallengeSpringBootJPA.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity=ProductEntity.builder()
				.sku("Nestle1234")
				.title("NestleChocolate")
				.price(BigDecimal.valueOf(123.43))
				.quantity(13)
				.build();

		ProductEntity savedEntity= productRepository.save(productEntity);
		System.out.println(savedEntity);

	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities= productRepository.findBy(Sort.by());
//		System.out.println(entities);
	}


}
