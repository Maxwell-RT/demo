package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    //#region
    @Autowired
    private ProductRepository productRepository;

    ////#endregion
    /// 
    ///#region
    /// Obtener todos los productos
    public List<Product> ObtenerTodos() {
    List<Product> products = productRepository.findAll();
    return products;}


    //Obtener por id
    public Product ObtenerPorId(long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }


    
    ///#endregion
}
