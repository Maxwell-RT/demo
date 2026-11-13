package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    ///Listar productos de la db
    /// 
    @GetMapping
    public List<Product> listarProductos() {
        return productService.ObtenerTodos();
    }


    //Obtener producto por id
    @GetMapping("/{id}")
    public Product obtenerProductoPorId(@PathVariable Long id) {
        return productService.ObtenerPorId(id);
    }


    //Crear producto
    @PostMapping
    public Product creaProducto(@RequestBody Product product) {
        return productService.guardar(product);
    }

    //Actualizar producto
    @PutMapping("/{id}")
    public Product actualizarProducto(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.actualizar(id, productDetails);
    }

    //Eliminar producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productService.eliminar(id);
    }

}
