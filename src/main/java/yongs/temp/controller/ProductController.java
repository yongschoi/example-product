package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import yongs.temp.dao.ProductRepository;
import yongs.temp.model.Product;
import yongs.temp.service.MinioService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
    private ProductRepository repo;
    @Autowired
    MinioService minio;
    
    @GetMapping("/all")
    public Flux<Product> findAll() {
    	logger.debug("example-product|ProductController|findAll()");  	
    	// a littl 비효율(?)
    	return repo.findAll().map(p -> {
    		return new Product(p.getId(), 
					   p.getCategory(), 
					   p.getName(), 
					   p.getMadein(),
					   p.getShippingfee(),
					   p.getPrice(),
					   minio.getObjectUrl("example-product", p.getImageName()));
    	});
    }
    
    @GetMapping("/search/{name}")
    public Flux<Product> findByRegexpName(@PathVariable("name") String name) {
    	logger.debug("example-product|ProductController|findByRegexpName({})", name);
    	return repo.findByRegexpName(name).map(p -> {
    		return new Product(p.getId(), 
					   p.getCategory(), 
					   p.getName(), 
					   p.getMadein(),
					   p.getShippingfee(),
					   p.getPrice(),
					   minio.getObjectUrl("example-product", p.getImageName()));
    	});
    }	
    
    @GetMapping("/category/{category}")
    public Flux<Product> findByCategory(@PathVariable("category") String category) {
    	logger.debug("example-product|ProductController|findByCategory({})", category);
    	return repo.findByCategory(category).map(p -> {
    		return new Product(p.getId(), 
					   p.getCategory(), 
					   p.getName(), 
					   p.getMadein(),
					   p.getShippingfee(),
					   p.getPrice(),
					   minio.getObjectUrl("example-product", p.getImageName()));
    	});    	
    }	
}
