package com.ladderbush.miniapp.Services;

import java.util.List;

import com.ladderbush.miniapp.Entities.Image;
import com.ladderbush.miniapp.Entities.Miniature;


public interface UserService {
    Miniature saveMiniature(Miniature miniature);

    Image saveImage(Image image);

    void addImageToMiniature(String miniatureName, String imageUrl);

    Miniature getMiniature(String miniatureName);

    List<Miniature> getMiniatures();

    Image getImage(String imageUrl);

    List<Image> getImages();

}