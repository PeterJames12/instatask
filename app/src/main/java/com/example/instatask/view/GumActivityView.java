package com.example.instatask.view;

import com.example.instatask.model.dto.GumRoom;

import java.util.List;

/**
 * @author Igor Hnes on 12/26/17.
 */
public interface GumActivityView {
    void showMessage(String message);
    void showGums(List<GumRoom> gumRooms);
    void startActivity(int position, Class targetClass);
}
