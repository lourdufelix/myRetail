package com.tgt.corp.finance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.corp.finance.dto.RestErrorDto;
import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.dto.ProductDetails;
import com.tgt.corp.finance.dto.ErrorMessage;
import com.tgt.corp.finance.dto.SuccessMessage;
import com.tgt.corp.finance.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@RestController
public class MyRetailController {

    private static final Logger LOGGER = LogManager.getLogger(MyRetailController.class);

    @Autowired
    private ProductService productService;

    SuccessMessage successMessage = new SuccessMessage();
    ErrorMessage errorMessage = new ErrorMessage();

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public Object updatePrice(@RequestBody String request, HttpServletResponse httpServletResponse, @PathVariable("id") String id){
        Set<ConstraintViolation<Product>> constraintViolations = new HashSet<>();
        Product product = null;
        Long productId = null;
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        try {
            product = new ObjectMapper().readValue(request, Product.class);
        }catch (Exception e){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RestErrorDto restErrorDto = new RestErrorDto();
            restErrorDto.setMessage("Invalid Request");
            restErrorDto.addError(null, "Request body is invalid");
            return restErrorDto;
        }
        try {
            productId = Long.parseLong(id);
        }catch (Exception e){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RestErrorDto restErrorDto = new RestErrorDto();
            restErrorDto.setMessage("Invalid product ID");
            restErrorDto.addError("id", "value is not numeric");
            return restErrorDto;
        }

        if(!productId.equals(product.getProductId())){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RestErrorDto restErrorDto = new RestErrorDto();
            restErrorDto.setMessage("Invalid product ID");
            restErrorDto.addError("id", "product ID doesn't match with request body");
            return restErrorDto;
        }


        constraintViolations = validator.validate(product);

            /*If there are violations found, respond back as error*/
        if(constraintViolations.size() > 0)
        {
                /* Set Response Status as 400 for any exception*/
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            LOGGER.error("Invalid Request Error - {}", constraintViolations.toString());
            RestErrorDto restErrorDto = new RestErrorDto();
            restErrorDto.setMessage("Invalid Request");
            for(ConstraintViolation constraintViolation: constraintViolations)
            {
                restErrorDto.addError(((PathImpl)constraintViolation.getPropertyPath()).getLeafNode().getName(), constraintViolation.getMessage());
            }

            return restErrorDto;
        }
        productService.saveProductDetails(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public Object getFullDetails(@PathVariable("id") String id, HttpServletResponse httpServletResponse){
        Long productId = null;
        try {
            productId = Long.parseLong(id);
        }catch (Exception e){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RestErrorDto restErrorDto = new RestErrorDto();
            restErrorDto.setMessage("Invalid product ID");
            restErrorDto.addError("id", "value is not numeric");
            return restErrorDto;
        }

        try {
            Product product = productService.fetchProductDetails(productId);
            if(product == null){
                throw new Exception("product pricing not available");
            }
            Object productDetails = productService.getFullProductDetails(product);
            return productDetails;
        }catch (Exception e){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RestErrorDto restErrorDto = new RestErrorDto();
            restErrorDto.setMessage(e.getMessage());
            restErrorDto.addError(null, e.getMessage());
            return restErrorDto;
        }

    }
}
