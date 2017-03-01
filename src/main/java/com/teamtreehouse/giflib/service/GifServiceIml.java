package com.teamtreehouse.giflib.service;

import com.teamtreehouse.giflib.dao.GifDAO;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 26/02/2017.
 */
@Repository
public class GifServiceIml implements GifService {

    @Autowired
    private GifDAO gifDAO;

    @Override
    public List<Gif> findAll() {
        return gifDAO.findAll();
    }

    @Override
    public Gif findById(Long id) {
        return gifDAO.findById(id);
    }

    @Override
    public void save(Gif gif, MultipartFile file) {
        try {
            gif.setBytes(file.getBytes());
            gifDAO.save(gif);
        } catch (IOException e) {
            System.err.print("Unable to get byte array from upload file");
        }
    }

    @Override
    public void delete(Gif gif) {
        gifDAO.delete(gif);
    }
}
