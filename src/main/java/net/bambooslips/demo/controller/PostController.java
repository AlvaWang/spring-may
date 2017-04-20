package net.bambooslips.demo.controller;

import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.model.PostType;
import net.bambooslips.demo.exception.InvalidParamsException;
import net.bambooslips.demo.jpa.repository.PostRepository;
import net.bambooslips.demo.jpa.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;

/**
 * Created by Eureka on 2016/5/12.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);

    protected static final String PAGE_SIZE = "20";
    protected static final String PAGE = "0";

    @Autowired
    private PostService postService;

    // posts 应该需要方法级别上的访问控制
    // get 获取posts应该是允许所有用户的 并且提供页面和json
    // create delete put patch则应该是只有管理员才能访问


    @RequestMapping(method = RequestMethod.GET, produces = {"text/html", "application/xhtml+xml", "application/xml"})
    public ModelAndView listView(@RequestParam(defaultValue = PAGE) Integer page,
                                 @RequestParam(defaultValue = "10") Integer page_size,
                                 PostType type) {
        Pageable pageable = new PageRequest(page, page_size,
                new Sort(
                        new Sort.Order(Sort.Direction.DESC, "createdAt")
                ));
        ModelAndView mav = new ModelAndView("posts");
        if(type != null) {
            mav.addObject("posts", postService.findAll(pageable, type));
        } else {
            mav.addObject("posts", postService.findAll(pageable));
        }
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json", "*/*"})
    @ResponseBody
    public Page<Post> list(@RequestParam(defaultValue = PAGE) Integer page,
                           @RequestParam(defaultValue = PAGE_SIZE) Integer page_size,
                           PostType type) {
        Pageable pageable = new PageRequest(page, page_size,
                new Sort(
                        new Sort.Order(Sort.Direction.DESC, "createdAt")
                ));
        if(type != null)
            return postService.findAll(pageable,type);
        else
            return postService.findAll(pageable);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestParam(required = true) String title,
                        @RequestParam(required = true) String outline,
                       @RequestParam(required = true) String thumbnail,
                        @RequestParam(required = true) String content,
                        @RequestParam(required = false, defaultValue = "MAIN")  PostType type) {
        Post post = new Post(title, outline, thumbnail,content, type);
        return postService.create(post);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Post createByJson(Post post) {
        return postService.create(post);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Post getById(@PathVariable long id) {
        return postService.findById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET , produces = {"text/html", "application/xhtml+xml", "application/xml"})
    public ModelAndView getViewById(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("post");
        mav.addObject("post",postService.findById(id));
        return mav;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Post delete(@PathVariable long id) {
        return postService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Post updateByForm(@PathVariable long id, PostType type, String outline, String thumbnail, String title, String content) {
        Post post = new Post();
        post.setId(id);
        post.setPostType(type);
        post.setTitle(title);
        post.setThumbnail(thumbnail);
        post.setOutline(outline);
        post.setContent(content);
        return postService.update(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public Post update(@PathVariable long id, Post post) {
        post.setId(id);
        return postService.update(post);
    }
}
