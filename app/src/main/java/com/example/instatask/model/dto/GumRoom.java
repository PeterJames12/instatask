package com.example.instatask.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;

/**
 * @author Igor Hnes on 12/26/17.
 */
@SuppressWarnings("CheckStyle")
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "club",
        "title",
        "description",
        "image",
        "time_open",
        "time_close",
        "instructor"
})
public class GumRoom {
    @JsonProperty("id")
    private int id;
    @JsonProperty("club")
    private int club;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("image")
    private String image;
    @JsonProperty("time_open")
    private String timeOpen;
    @JsonProperty("time_close")
    private String timeClose;
    @JsonProperty("instructor")
    private List<Object> instructor = null;
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

    @JsonProperty("club")
    public int getClub() {
        return club;
    }

    @JsonProperty("club")
    public void setClub(int club) {
        this.club = club;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("time_open")
    public String getTimeOpen() {
        return timeOpen;
    }

    @JsonProperty("time_open")
    public void setTimeOpen(String timeOpen) {
        this.timeOpen = timeOpen;
    }

    @JsonProperty("time_close")
    public String getTimeClose() {
        return timeClose;
    }

    @JsonProperty("time_close")
    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
    }

    @JsonProperty("instructor")
    public List<Object> getInstructor() {
        return instructor;
    }

    @JsonProperty("instructor")
    public void setInstructor(List<Object> instructor) {
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