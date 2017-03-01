package com.teamtreehouse.giflib.service;

import com.teamtreehouse.giflib.dao.CategoryDaoImp;
import com.teamtreehouse.giflib.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 20/02/2017.
 */
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDaoImp categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findbyId(Long id) {
        return categoryDao.findbyId(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
