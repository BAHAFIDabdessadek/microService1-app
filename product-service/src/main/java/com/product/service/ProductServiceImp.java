package com.product.service;

import com.product.dtos.ProductRequest;
import com.product.dtos.ProductResponse;
import com.product.repository.ProductRepository;
import com.product.service.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public void create(ProductRequest productRequest) {

        Product  product = Product.builder()
                .name(productRequest.getName())
                .Description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} saved with success.",product.getName());
    }

    @Override
    public List<ProductResponse> getAllProduct() {

        return productRepository.findAll().stream().map(this::productToResponse).toList();
    }

    private ProductResponse productToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .Description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
