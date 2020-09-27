package com.stackroute.repository;

import com.stackroute.model.Movie;
import com.stackroute.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MATCH (m:Movie) RETURN m")
    Collection<Movie> getAllMovies();


    @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    Collection<User> getAllMoviesUsers();

    @Query("Match(n:Movie {movieId:{0}}) detach delete n")
    Collection<Movie> deleteById(Long movieId);

    @Query("CREATE (:Movie {movieId:{0},title: {1}, director:{2}})")
    Collection<Movie> insertMovie(Long movieId,String title,String director);

    @Query("CREATE (:User {userId:{0},name: {1}, age:{2}})")
    Collection<User> insertUser(Long userId,String name,Integer age);


    @Query("MATCH(m:Movie {title:{0}}),(u:User{name: {1}}) RETURN u,r")
    Collection<User> getSpecificUsers();

    @Query("MATCH(m:Movie {title:{0}}),(u:User{name: {2}}) CREATE(m)-[:RATED {rating:{1}}]->(u)")
    Collection<User> insertRelationship(String title,Integer rating,String name);

//    @Query("MATCH (n:Movie {title:{0}})-[r:RATED]->(u:User {name:{1}}) detach delete r RETURN u,n");
//    Collection<User> deleteRelationship(String title,String name);

    @Query("MATCH(m:Movie{title:{0}})-[r:RATED]->(u:User{name:{1}}) detach delete r RETURN m,u")
    Collection<User> deleteRelationship(String title,String name);


}
