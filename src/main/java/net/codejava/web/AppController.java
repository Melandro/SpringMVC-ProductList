package net.codejava.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Product;
import net.codejava.service.ProductService;

@Controller
public class AppController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);
	     
	    return "index";
	}
	
	@RequestMapping("/price/{price}")
	public ModelAndView searchByPriceHigherThan(@PathVariable(name = "price") Float price) {
		logger.info("Search Products where price is higher than " + price);
		List<Product> listProducts = service.searchByPrice(price);

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listProducts", listProducts);
		
		return mav;
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new_product";
		}
	    service.save(product);
	     
	    return "redirect:/";
	}
//	
//	@RequestMapping("/brand/{brand}")
//	public ModelAndView searchBrand(@PathVariable(name = "brand") String brand) {
//		logger.info("Search for brand: " + brand);
//		ModelAndView mav = new ModelAndView("brand");
//		List<Product> listProducts = service.findByBrand(brand);
//		logger.info("Found " + listProducts.size() + " products for brand " + brand);
//		mav.addObject("listProducts", listProducts);
//		
//		return mav;
//	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Product product = service.get(id);
	    mav.addObject("product", product);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	
	@GetMapping("/international")
    public String getInternationalPage(Model model) {
        return viewHomePage(model);
    }
}
