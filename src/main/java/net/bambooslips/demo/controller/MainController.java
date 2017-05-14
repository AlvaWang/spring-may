package net.bambooslips.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.model.PostType;
import net.bambooslips.demo.jpa.model.Resource;
import net.bambooslips.demo.jpa.model.ResourceType;
import net.bambooslips.demo.jpa.service.PostService;
import net.bambooslips.demo.jpa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    protected static final String PAGE_SIZE = "12";
    protected static final String PAGE = "0";

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index2() {
        return "index";
    }

    @RequestMapping("/temp")
    public String temp() {
        return "temp";
    }

    @RequestMapping("/editor")
    public String editor() {
        return "html-editor";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
    @RequestMapping("/entry")
    public String entry() {
        return "entry";
    }
    @RequestMapping("/registerSuccess")
    public String registerSuccess() {
        return "registerSuccess";
    }

    @RequestMapping("/registerState")
    public String registerState() {
        return "registerState";
    }

    @RequestMapping("/unitTable")
    public String unitTable() {
        return "unitTable";
    }

    @RequestMapping("/project")
    public String project() {
        return "project";
    }

    @RequestMapping("/projectSubmit")
    public String projectSubmit() {
        return "project_submit";
    }

    @RequestMapping("/unitCreate")
    public String unitCreate() {
        return "unitCreate";
    }

    @RequestMapping("/teamCreate")
    public String teamCreate() {
        return "teamCreate";
    }

    @RequestMapping("/teamTable")
    public String teamTable() {
        return "teamTable";
    }

    @ModelAttribute("avatars")
    @RequestMapping("/avatars")
    public Page<Resource> avatars(@RequestParam(defaultValue = PAGE) Integer page,
                                  @RequestParam(defaultValue = PAGE_SIZE) Integer page_size) {
        Pageable pageable = new PageRequest(page, page_size);
        return resourceService.findAll(pageable, ResourceType.AVATAR);
        //调用数据库查询
    }

    @ModelAttribute("pictures")
    @RequestMapping("/pictures")
    public Page<Resource> pictures(@RequestParam(defaultValue = PAGE) Integer page,
                                  @RequestParam(defaultValue = PAGE_SIZE) Integer page_size) {
        Pageable pageable = new PageRequest(page, page_size);
        return resourceService.findAll(pageable, ResourceType.PICTURE);
    }

    @RequestMapping(value = "/threads",method = RequestMethod.GET, produces = {"text/html", "application/xhtml+xml", "application/xml"})
    public ModelAndView listView(@RequestParam(defaultValue = PAGE) Integer page,
                                 @RequestParam(defaultValue = "10") Integer page_size,
                                 PostType type) {
        Pageable pageable = new PageRequest(page, page_size);
        ModelAndView mav = new ModelAndView("posts");
        if (type != null) {
            mav.addObject("type", type);
            mav.addObject("posts", postService.findAll(pageable, type));
        } else {
            mav.addObject("type", PostType.MAIN);
            mav.addObject("posts", postService.findAll(pageable));
        }
        return mav;
    }

    @RequestMapping(value = "/threads/{id}", method = RequestMethod.GET , produces = {"text/html", "application/xhtml+xml", "application/xml"})
    public ModelAndView getViewById(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("post");
        mav.addObject("post",postService.findById(id));
        mav.addObject("formatter",new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
        return mav;
    }
}

