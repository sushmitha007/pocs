package com.stackroute.controller;

import com.stackroute.model.Movie;
import com.stackroute.service.UserService;
import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/movies")
    public Collection<Movie> getAllMovies() { return userService.getMovies();}

    @GetMapping("/moviesusers")
    public Collection<User> getAllMoviesUsers() { return userService.getMoviesUsers();}

    @DeleteMapping("movie/{id}")
    public Collection<Movie> deleteMovies(@PathVariable("id") Long movieId) { return userService.deleteMovie(movieId);}

    @PostMapping("addmovie/{id}/{title}/{director}")
    public Collection<Movie> addMovie(@PathVariable("id") Long movieId,@PathVariable("title")String title,@PathVariable("director") String director)
    {
        return userService.addMovie(movieId,title,director);
    }

    @PostMapping("adduser/{id}/{name}/{age}")
    public Collection<User> addUser(@PathVariable("id") Long userId,@PathVariable("name")String name,@PathVariable("age") Integer age)
    {
        return userService.addUser(userId,name,age);
    }

    @PostMapping("addrelationship/{title}/{rating}/{name}")
    public Collection<User> addRelationship(@PathVariable("title") String title,@PathVariable("rating")Integer rating,@PathVariable("name") String name)
    {
        return userService.addRelationship(title,rating,name);
    }

    @DeleteMapping("deleterelationship/{title}/{name}")
    public Collection<User> addRelationship(@PathVariable("title") String title,@PathVariable("name") String name)
    {
        return userService.deleteRelationship(title,name);
    }


//    @GetMapping("specificusers/{title}/{name}")
//    public Collection<User> getSpecificUsers() { return userService.getPerticularUsers();}



}
