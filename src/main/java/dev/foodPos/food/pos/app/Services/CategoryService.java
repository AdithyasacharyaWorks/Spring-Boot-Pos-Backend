package dev.foodPos.food.pos.app.Services;

import dev.foodPos.food.pos.app.Models.Category;
import dev.foodPos.food.pos.app.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public Category createCategory(Category category) {
        category.setCreatedAt(new java.util.Date());
        category.setUpdatedAt(new java.util.Date());
        return categoryRepository.save(category);
    }

    public Category updateCategory(String id, Category categoryDetails) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDetails.getName());
            category.setDescription(categoryDetails.getDescription());
            category.setImageUrl(categoryDetails.getImageUrl());
            category.setSlug(categoryDetails.getSlug());
            category.setActive(categoryDetails.isActive());
            category.setUpdatedAt(new java.util.Date());
            return categoryRepository.save(category);
        } else {
            return null;
        }
    }

    public boolean deleteCategory(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
            return true;
        } else {
            return false;
        }
    }
}
