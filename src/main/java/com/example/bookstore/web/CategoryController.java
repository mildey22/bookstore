package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;


@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @RequestMapping(value = {"/categorylist"})
    public String categorylist(Model model){
        model.addAttribute("categories", repository.findAll());
    return "categorylist";
}

@RequestMapping(value = "/deletecategory/{categoryId}", method = RequestMethod.GET)
public String deleteCategory(@PathVariable("categoryId") Long categoryId, Model model) {
    repository.deleteById(categoryId);
    return "redirect:../categorylist";
}

@RequestMapping("/addcategory")
public String addCategory(Model model) {
    model.addAttribute("category", new Category());
    return "addcategory";
}


@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
public String save(Category category) {
    repository.save(category);
    return "redirect:categorylist";
}



}
