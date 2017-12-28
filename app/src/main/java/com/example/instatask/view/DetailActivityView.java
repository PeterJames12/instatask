package com.example.instatask.view;

import com.example.instatask.view.vo.Day;

import java.util.List;

/**
 * @author Igor Hnes on 12/26/17.
 */
public interface DetailActivityView {
    void showMessage(String message);
    void updateAdapter(List<Day> daysList);
}
