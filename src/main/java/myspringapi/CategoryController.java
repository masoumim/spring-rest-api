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
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	/* List the added categories. */
	@RequestMapping(value = "/listCategory", method = RequestMethod.GET)
	public String listCategoryList(Model model) {
		List<Category> categoryList = this.categoryRepository.findAll();
		model.addAttribute(ConstantVariable.CATEGORY_LIST, categoryList);
		return "listCategory";
	}

	/* Display the add category form page. */
	@RequestMapping(value = "/addCategoryPage", method = RequestMethod.GET)
	public String addCategoryPage() {
		return "addCategory";
	}

	/* Display the update category form page. */
	@RequestMapping(value = "/updateCategoryPage/{id}", method = RequestMethod.GET)
	public String updateCategoryPage(@PathVariable("id") long id, Model model) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		model.addAttribute(ConstantVariable.CATEGORY, category);
		return "updateCategory";
	}

	/*
	 * Add user submitted category info to h2 database and redirect to the list
	 * categories page.
	 */
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:/category/listCategory";
	}

	/* Delete a category by id */
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") long id, Model model) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
		categoryRepository.delete(category);
		return "redirect:/category/listCategory";
	}

	@PostMapping("/updateCategory")
	public String updateCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:/category/listCategory";
	}
}