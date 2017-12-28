package com.example.instatask.model.api;

import com.example.instatask.model.dto.GumRoom;
import com.example.instatask.model.dto.Schedule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Igor Hnes on 12/26/17.
 */
public interface InstaApi {

    @GET("api/hall")
    Call<List<GumRoom>> getRooms();

    @GET("api/schedule/dates/{data_start}/{data_finish}/hall/{hall_id}")
    Call<List<Schedule>> getSchedule(@Path("data_start") String dataStart, @Path("data_finish") String dataFinish, @Path("hall_id") int hallId);
}
