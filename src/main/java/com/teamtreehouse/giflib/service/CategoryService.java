package com.teamtreehouse.giflib.service;

import com.teamtreehouse.giflib.model.Category;

import java.util.List;

/**
 * Created by Admin on 20/02/2017.
 */
public interface CategoryService {

    List<Category> findAll();
    Category findbyId(Long id);
    void save(Category category);
    void insert(Category category);
    void delete(Category category);
}
