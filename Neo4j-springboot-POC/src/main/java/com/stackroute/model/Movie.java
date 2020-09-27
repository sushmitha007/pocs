package com.stackroute.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Movie {

    @GraphId
    private Long movieId;
    private String title;
    private String director;

    public Movie() {
    }



    public Long getId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }
}
