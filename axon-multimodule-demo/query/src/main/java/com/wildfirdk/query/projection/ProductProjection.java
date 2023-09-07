package com.wildfirdk.query.projection;

import com.wildfirdk.query.queries.GetProductsQuery;
import com.wildfiredk.data.Product;
import com.wildfiredk.data.repository.ProductRepository;
import com.wildfiredk.data.model.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> products = productRepository.findAll();
        List<ProductRestModel> productRestModelList =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .name(product.getName())
                                .price(product.getPrice())
                                .quantity(product.getQuantity())
                                .build()).collect(Collectors.toList());
        return productRestModelList;

    }
}
