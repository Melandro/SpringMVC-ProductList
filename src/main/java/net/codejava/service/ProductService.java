package net.codejava.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Product;
import net.codejava.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
    
    public List<Product> searchByPrice(float price) {
    	return repo.findByPrice(price);
    }
    
    public List<Product> findByBrand(String brand) {
    	return repo.findByBrand(brand);
    }
     
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
