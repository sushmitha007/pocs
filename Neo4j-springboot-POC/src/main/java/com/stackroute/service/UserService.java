package com.stackroute.service;

import com.stackroute.model.Movie;
import com.stackroute.repository.UserRepository;
import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getUsers() {
        return userRepository.getAllUsers();
    }

    public Collection<Movie> getMovies(){return userRepository.getAllMovies();}

    public Collection<User> getMoviesUsers(){return userRepository.getAllMoviesUsers();}

    public Collection<Movie> deleteMovie(Long movieId)
    {
        userRepository.deleteById(movieId);
        return userRepository.getAllMovies();
    }

    public Collection<Movie> addMovie(Long movieId,String title,String director)
    {
        userRepository.insertMovie(movieId,title,director);
        return userRepository.getAllMovies();
    }

    public Collection<User> addUser(Long userId,String name,Integer age)
    {
        userRepository.insertUser(userId,name,age);
        return userRepository.getAllUsers();
    }

    public Collection<User> getPerticularUsers() {
        return userRepository.getSpecificUsers();
    }

    public Collection<User> addRelationship(String title,Integer rating,String name)
    {
        userRepository.insertRelationship(title,rating,name);
        return userRepository.getAllMoviesUsers();
    }

    public Collection<User> deleteRelationship(String title,String name)
    {
        return userRepository.deleteRelationship(title,name);
    }


}
