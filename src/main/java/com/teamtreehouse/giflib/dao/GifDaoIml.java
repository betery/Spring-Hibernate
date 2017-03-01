package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Admin on 26/02/2017.
 */
@Repository
public class GifDaoIml implements GifDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Gif> findAll() {
        Session session = sessionFactory.openSession();
        List<Gif> gifList = session.createCriteria(Gif.class).list();
        session.close();
        return gifList;
    }

    @Override
    public Gif findById(Long id) {

        Session session = sessionFactory.openSession();
        Gif gif = session.get(Gif.class, id);
        session.close();
        return gif;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public void save(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(gif);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Gif gif) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(gif);
        session.getTransaction().commit();
        session.close();
    }
}
