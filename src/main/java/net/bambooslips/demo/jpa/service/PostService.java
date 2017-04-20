package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.model.PostType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Eureka on 2016/5/16.
 * This service provides CRUD operations for Post
 * 
 */
@Service
public interface PostService {


        Post create(Post post);

        Post delete(Long id);

        Post update(Post update);

        Iterable<Post> findAll();

        Page<Post> findAll(Pageable pageable);

        Page<Post> findAll(Pageable pageable, PostType type);

        Post findById(Long id);

        long count(PostType type);

        long count();

        public List<Post> search(String searchTerm);


}
