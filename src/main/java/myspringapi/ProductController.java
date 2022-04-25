package myspringapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	/* List the added products. */
	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)
	public String listProductList(Model model) {
		List<Product> productList = this.productRepository.findAll();
		model.addAttribute(ConstantVariable.PRODUCT_LIST, productList);
		return "listProduct";
	}

	/* Display the add product form page. */
	@RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
	public String addProductPage(Model model) {
		List<Category> options = this.categoryRepository.findAll();
		model.addAttribute("options", options);

		return "addProduct";
	}

	/*
	 * Add user submitted product info to h2 database and redirect to the list
	 * products page.
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Product product) {
		productRepository.save(product);
		return "redirect:/product/listProduct";
	}

	/* Delete a product by id */
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") long id, Model model) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		productRepository.delete(product);
		return "redirect:/product/listProduct";
	}

	/* Display the update product form page. */
	@RequestMapping(value = "/updateProductPage/{id}", method = RequestMethod.GET)
	public String updateProductPage(@PathVariable("id") long id, Model model) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		model.addAttribute(ConstantVariable.PRODUCT, product);

		// Add list of categories
		List<Category> options = this.categoryRepository.findAll();
		model.addAttribute("options", options);

		return "updateProduct";
	}

	@PostMapping("/updateProduct")
	public String updateProduct(Product product) {
		productRepository.save(product);
		return "redirect:/product/listProduct";
	}
}
