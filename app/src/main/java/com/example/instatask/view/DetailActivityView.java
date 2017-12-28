package com.example.instatask.view;

import com.example.instatask.view.vo.Day;

import java.util.List;

/**
 * @author Igor Hnes on 12/26/17.
 */
public interface DetailActivityView {

    /**
     * @param message text message.
     */
    void showMessage(String message);

    /**
     * @param daysList List day objects.
     */
    void updateAdapter(List<Day> daysList);
}
