package com.product.service;

import com.product.dtos.ProductRequest;
import com.product.dtos.ProductResponse;

import java.util.List;

public interface IProductService {

    void create(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();
}
