package com.tgt.corp.finance;


import com.tgt.corp.finance.entity.Price;
import com.tgt.corp.finance.entity.Product;
import com.tgt.corp.finance.dto.ProductDetails;
import com.tgt.corp.finance.services.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyRetailApplicationTests {

    @TestConfiguration
    static class RetailTestConfig {
//        @Bean
//        public TestRestTemplate returnTestRestTemplate() {
//            return new TestRestTemplate();
//        }
        @Bean
        public ProductService createProductService(){
            return new ProductService();
        }
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    private Product product;
    private ProductDetails productDetails;
    String getUrl;

    @Before
    public void before() {
        Product product = new Product();
        product.setProductId(13860428L);
        product.setPrice(new Price(580.19,"USD"));
        productService.saveProductDetails(product);
        productDetails = new ProductDetails();
    }



        @Test
        public void checkReturnHeader() throws  Exception{
            getUrl = "/products/13860428";

            String body = restTemplate.getForObject(getUrl, String.class);
            ResponseEntity responseEntity = restTemplate.getForEntity(getUrl, ProductDetails.class);
            productDetails = (ProductDetails) responseEntity.getBody();
            Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            Assert.assertEquals(productDetails.getPrice().getValue(),Double.valueOf(580.19), Double.valueOf(0.0));
            //Assert.assertEquals(product.getPrice().getValue(),Double.valueOf(580.19));
        }

}
