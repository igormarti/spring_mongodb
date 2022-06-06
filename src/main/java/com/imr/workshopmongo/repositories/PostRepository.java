package com.imr.workshopmongo.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.imr.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContaining(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ title: { $regex: /?0/i } }")
	List<Post> searchByTitle(String text);
	
	@Query("{ $and: [ { date: {$gte: ?0 } }, { date: {$lte: ?1 } }, { $or: [ { title: { $regex: ?2, $options: 'i' } }, { body: { $regex: ?2, $options: 'i' } }, { 'comments.text' : { $regex: ?2, $options: 'i' } }   ]  } ] }")
	List<Post> search(Instant dateMin, Instant dateMax, String text);

}
