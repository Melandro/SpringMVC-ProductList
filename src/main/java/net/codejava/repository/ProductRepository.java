package net.codejava.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.codejava.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT p FROM Product p WHERE price > :price")
	List<Product> findByPrice(@Param("price") float price);
	
	List<Product> findByBrand(String brand);
}
