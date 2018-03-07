package com.tgt.corp.finance.controller;

import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.entity.Response;
import com.tgt.corp.finance.message.ErrorMessage;
import com.tgt.corp.finance.message.SuccessMessage;
import com.tgt.corp.finance.repository.ProductRepository;
import com.tgt.corp.finance.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MyRetailController {

    private static final Logger LOGGER = LogManager.getLogger(MyRetailController.class);

    @Autowired
    private ProductService productService;

    SuccessMessage successMessage = new SuccessMessage();
    ErrorMessage errorMessage = new ErrorMessage();

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.fetchProductDetails(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products/store")
    public SuccessMessage saveProduct(@RequestBody Product product){
        productService.saveProductDetails(product);
        successMessage.setMessage("product details stored successfully");
        successMessage.setStatus("OK");
        return successMessage;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public SuccessMessage updatePrice(@RequestBody Product product){
        productService.saveProductDetails(product);
        successMessage.setMessage("product price details updated successfully");
        successMessage.setStatus("OK");
        return successMessage;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/fulldetails/{id}")
    public Object getFullDetails(@PathVariable("id") Long id){
        Product product = productService.fetchProductDetails(id);
        Object productDetails = productService.getFullProductDetails(id);
//        if(productService.getFullProductDetails(id).getClass().equals(Response.class)) {
        if(productDetails.getClass().equals(Response.class)){
            Response response = (Response) productService.getFullProductDetails(id);
            response.getExternalProduct().setProduct(product);
            return response;
        }else{
            return productDetails;
        }
    }
}
