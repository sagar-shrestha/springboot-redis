package com.example.springbootredisdatabase.service;

import com.example.springbootredisdatabase.entity.Product;
import com.example.springbootredisdatabase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Object findProductById(Integer id) {
        return redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProductById(Integer id) {
         redisTemplate.opsForHash().delete(HASH_KEY, id);
         return "Product removed.";
    }

//    public Product save(Product product) {
//        return productRepository.save(product);
//    }
//
//    public List<Product> findAll() {
//        return (List<Product>) productRepository.findAll();
//    }
//
//    public Object findProductById(Integer id) {
//        return productRepository.findById(id);
//    }
//
//    public String deleteProductById(Integer id) {
//        productRepository.deleteById(id);
//        return "Product deleted";
//    }
}
