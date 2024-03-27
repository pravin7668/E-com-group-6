package com.test;

import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;
import com.model.Product;
import com.service.ProductService;

public class ProductServiceTest {

	ProductService productservice = new ProductService();
	@Test
    public void createProductTest() {

        int productId = 1;
        String name = "Keeper Gloves";
        double price = 6000.0;
        String description = "Best for wk";
        int stockQuantity = 10;
        try {
            productservice.createProduct(productId, name, price, description, stockQuantity);
            List<Product> productList = productservice.displayProductDetails();
            Assert.assertTrue("ExpectedOutput is not empty", !productList.isEmpty());
            Product createdProduct = productList.get(productList.size() - 1); 
            Assert.assertEquals("ExpectedOutput name matches", name, createdProduct.getName());
            Assert.assertEquals("ExpectedOutput price matches", price, createdProduct.getPrice(),6000.0);
            
        } catch (SQLException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }


    @Test
    public void deleteProductTest() {
        
        int productId = 1;
        try {
            productservice.deleteProduct(productId);
            
            Product deletedProduct = productservice.getProductById(productId);
            Assert.assertNull("ExpectedOutput not exist", deletedProduct);
        } catch (SQLException e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }



}
