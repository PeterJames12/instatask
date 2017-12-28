package com.example.instatask.model.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.ToString;

/**
 * @author Igor Hnes on 12/26/17.
 */
@SuppressWarnings("CheckStyle")
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "hall",
        "template",
        "seats",
        "title",
        "start",
        "end",
        "duration",
        "url",
        "instructor"
})
public class Schedule {
    @JsonProperty("id")
    private int id;
    @JsonProperty("hall")
    private int hall;
    @JsonProperty("template")
    private int template;
    @JsonProperty("seats")
    private int seats;
    @JsonProperty("title")
    private String title;
    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("url")
    private String url;
    @JsonProperty("instructor")
    private List<Instructor> instructor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("hall")
    public int getHall() {
        return hall;
    }

    @JsonProperty("hall")
    public void setHall(int hall) {
        this.hall = hall;
    }

    @JsonProperty("template")
    public int getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(int template) {
        this.template = template;
    }

    @JsonProperty("seats")
    public int getSeats() {
        return seats;
    }

    @JsonProperty("seats")
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("instructor")
    public List<Instructor> getInstructor() {
        return instructor;
    }

    @JsonProperty("instructor")
    public void setInstructor(List<Instructor> instructor) {
        this.instructor = instructor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
