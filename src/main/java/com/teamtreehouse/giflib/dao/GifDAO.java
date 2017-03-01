package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Admin on 26/02/2017.
 */
public interface GifDAO {

    List<Gif> findAll();
    Gif findById(Long id);
    void save(Gif gif);
    void delete(Gif gif);

}
