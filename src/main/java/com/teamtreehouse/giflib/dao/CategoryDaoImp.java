package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 20/02/2017.
 */
@Repository
public class CategoryDaoImp implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("uncheck")
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createCriteria(Category.class).list();
        session.close();
        return categories;
    }

    @Override
    public Category findbyId(Long id) {

        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    @SuppressWarnings( "Duplicates" )
    public void save(Category category) {

        Session session = sessionFactory.openSession();

        //set transaction
        session.beginTransaction();

        //save data to database
        session.saveOrUpdate(category);

        //comit
        session.getTransaction().commit();

        //close session
        session.close();
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    @SuppressWarnings("Duplicates")
    public void delete(Category category) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(category);

        session.getTransaction().commit();
        session.close();
    }
}
