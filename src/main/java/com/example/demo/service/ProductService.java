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


    public Product guardar(Product product) {
        // Validar que el producto no sea nulo y que tenga un nombre válido
        if( product== null)
            throw new IllegalArgumentException("Producto no puede ser nulo");
        // Validar que el nombre del producto no sea nulo o vacío
        if(product.getName() == null || product.getName().isEmpty())
            throw new IllegalArgumentException("Nombre del producto no puede ser nulo o vacío");

        // Validar que el precio del productos sea mayor que cero
        if (product.getPrice() <= 0)
            throw new IllegalArgumentException("El precio del producto no puede ser negativo, ni cero");

        return productRepository.save(product);
    }

    //actualizar producto
    public Product actualizar(long id, Product productDetails) {
        Product product = ObtenerPorId(id);

        if (productDetails.getName() != null && !productDetails.getName().isEmpty()==false) {
            product.setName(productDetails.getName());
        }
        if (productDetails.getPrice() > 0) {
            product.setPrice(productDetails.getPrice());
        }

        return productRepository.save(product);
    }


    //eliminar producto
    public void eliminar(long id) {
        if(productRepository.existsById(id) == false)
            throw new RuntimeException("Producto no encontrado para eliminar");
        //Si lo encuentra, lo elimina
        productRepository.deleteById(id);
    }
 ///#endregion
    }


