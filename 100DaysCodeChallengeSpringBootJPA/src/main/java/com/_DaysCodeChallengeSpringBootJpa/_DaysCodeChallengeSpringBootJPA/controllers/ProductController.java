package com._DaysCodeChallengeSpringBootJpa._DaysCodeChallengeSpringBootJPA.controllers;

import com._DaysCodeChallengeSpringBootJpa._DaysCodeChallengeSpringBootJPA.ProductRepository;
import com._DaysCodeChallengeSpringBootJpa._DaysCodeChallengeSpringBootJPA.entities.ProductEntity;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
private final int  PAGE_SIZE=7;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue="0") Integer pageNumber){

        Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
        return  productRepository.findAll(pageable).getContent();

    }
}
