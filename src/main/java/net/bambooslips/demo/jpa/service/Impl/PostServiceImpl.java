package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.PostNotFoundException;
import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.model.PostType;
import net.bambooslips.demo.jpa.repository.PostRepository;
import net.bambooslips.demo.jpa.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    
    private static final Logger LOG = LoggerFactory.getLogger(PostServiceImpl.class);

    protected static final int PAGE = 5;

    @Resource
    private PostRepository postRepository;

    @Transactional
    @Override
    public Post create(Post post) {
        LOG.debug("Creating a new post with information: " + post);
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public long count() {
        return postRepository.count();
    }

    @Transactional
    @Override
    public long count(PostType type) {
        return postRepository.countByPostType(type);
    }

    @Transactional(rollbackFor = PostNotFoundException.class)
    @Override
    public Post delete(Long postId) throws PostNotFoundException {
        LOG.debug("Deleting post with id: " + postId);
        
        Post deleted = postRepository.findOne(postId);
        
        if (deleted == null) {
            LOG.debug("No post found with id: " + postId);
            throw new PostNotFoundException("No post found with id: " + postId);
        }
        
        postRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Post> findAll() {
        LOG.debug("Finding all posts");
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Post> findAll(Pageable pageable) {
        LOG.debug("Finding posts by page.");
        return postRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Post> findAll(Pageable pageable, PostType type) {
        LOG.debug("Finding posts by type.");
        return postRepository.findByPostTypeOrderByCreatedAtDesc(pageable,type);
    }

    @Transactional(readOnly = true)
    @Override
    public Post findById(Long id) {
        LOG.debug("Finding post by id: " + id);
        return postRepository.findOne(id);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Post> search(String searchTerm) {
        LOG.debug("Searching post by title: " + searchTerm);
        return postRepository.searchByTitle(searchTerm);
    }

    @Transactional(rollbackFor = PostNotFoundException.class)
    @Override
    public Post update(Post updated) throws PostNotFoundException {
        LOG.debug("Updating post with information: " + updated);
        
        Post post = postRepository.findOne(updated.getId());
        
        if (post == null) {
            LOG.debug("No post found with id: " + updated.getId());
            throw new PostNotFoundException("Post "+updated.getTitle()+" not found.");
        }
        post.update(updated);

        return post;
    }
    
}
