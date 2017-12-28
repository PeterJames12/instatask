package com.example.instatask.view;

import com.example.instatask.model.dto.GumRoom;

import java.util.List;

/**
 * @author Igor Hnes on 12/26/17.
 */
public interface GumActivityView {

    /**
     * @param message text message.
     */
    void showMessage(String message);

    /**
     * Show gum rooms.
     */
    void showGums(List<GumRoom> gumRooms);

    /**
     * @param hallId      item position.
     * @param targetClass Class name.
     */
    void startActivity(int hallId, Class targetClass);
}
