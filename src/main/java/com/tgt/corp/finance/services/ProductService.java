package com.tgt.corp.finance.services;


import com.tgt.corp.finance.entity.Response;
import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.message.ErrorMessage;
import com.tgt.corp.finance.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

@Service
public class ProductService {

    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);

    Gson gson = new Gson();

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

    public Object getFullProductDetails(Long id){
        String productExternalUri = "http://redsky.target.com/v2/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
        System.out.println(productExternalUri);
        RestTemplate restTemplate = new RestTemplate();
        try {
            Response productDetails = restTemplate.getForObject(productExternalUri, Response.class, id);
            return productDetails;
        }catch (Exception e){
            LOGGER.error("error: " + e.getMessage());
            if(e.getMessage().contains("404")) {
                errorMessage.setMessage("No such product available at external location");
                errorMessage.setStatus("404");
            }else {
                errorMessage.setMessage("external API not reachable");
                errorMessage.setStatus("502");
            }
            return errorMessage;
        }

    }
}
