package com.tgt.corp.finance.services;


import com.tgt.corp.finance.dto.Item;
import com.tgt.corp.finance.dto.ItemDetails;
import com.tgt.corp.finance.dto.ProductDetails;
import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.dto.ErrorMessage;
import com.tgt.corp.finance.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

@Service
public class ProductService {

    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

    Gson gson = new Gson();

    @Value("${product.external.uri}") private String productUri;

    @Autowired
    ProductRepository productRepository;



    ErrorMessage errorMessage = new ErrorMessage();

    public Product fetchProductDetails(Long id){
        return productRepository.findByProductId(id);
    }

    public void saveProductDetails(Product product){
        productRepository.save(product);
        System.out.println("records saved successfully\n");
    }

    public Object getFullProductDetails(Product product) throws Exception{
        String productExternalUri = productUri;
        System.out.println(productExternalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity(productExternalUri, ItemDetails.class, product.getProductId());
        }catch (Exception e){
            LOGGER.error(e);
            throw new Exception("Error getting the product name");
        }
            ItemDetails itemDetails = (ItemDetails) responseEntity.getBody();
            if(responseEntity.getStatusCode().is2xxSuccessful()) {
                ProductDetails productDetails = new ProductDetails();
                productDetails.setId(product.getProductId());
                productDetails.setPrice(product.getPrice());
                productDetails.setName(itemDetails.getExternalProduct().getItem().getProductDescription().getTitle());
                return productDetails;
            }else {
                throw new Exception("Error getting the product name");
            }
    }

}
