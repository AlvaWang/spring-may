package net.bambooslips.demo.controller;

import net.bambooslips.demo.jpa.model.Resource;
import net.bambooslips.demo.jpa.model.ResourceType;
import net.bambooslips.demo.jpa.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Eureka on 2016/5/12.
 */
@Controller
@RequestMapping("/resources")
public class ResourceController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);

    protected static final String PAGE_SIZE = "20";
    protected static final String PAGE = "0";

    @Autowired
    private ResourceService resourceService;

    // resources 应该需要方法级别上的访问控制
    // get 获取resources应该是允许所有用户的 并且提供页面和json
    // create delete put patch则应该是只有管理员才能访问

    @RequestMapping(method = RequestMethod.GET, produces = {"text/html", "application/xhtml+xml", "application/xml"})
    @ResponseBody
    public Page<Resource> list(@RequestParam(defaultValue = PAGE) Integer page,
                                @RequestParam(defaultValue = PAGE_SIZE) Integer page_size,
                                ResourceType type) {
        Pageable pageable = new PageRequest(page, page_size);
        if(type != null)
            return resourceService.findAll(pageable,type);
        else
            return  resourceService.findAll(pageable);

    }

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json", "*/*"})
    @ResponseBody
    public Page<Resource> listJson(@RequestParam(defaultValue = PAGE) Integer page,
                                    @RequestParam(defaultValue = PAGE_SIZE) Integer page_size,
                                    ResourceType type) {
        Pageable pageable = new PageRequest(page, page_size);
        if(type != null)
            return resourceService.findAll(pageable,type);
        else
            return  resourceService.findAll(pageable);

    }


    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Resource create(@RequestParam(required = true) String name,
                        @RequestParam(required = true) String url,
                        @RequestParam(required = true) String content,
                        @RequestParam(required = false, defaultValue = "MAIN")  ResourceType type) {
        Resource resource = new Resource(name, url, content, type);
        return resourceService.create(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Resource getById(@PathVariable long id) {
        return resourceService.findById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Resource delete(@PathVariable long id) {
        return resourceService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Resource updateByForm(@PathVariable long id, ResourceType type,String url, String name, String content) {
        Resource resource = new Resource();
        resource.setId(id);
        resource.setResourceType(type);
        resource.setName(name);
        resource.setUrl(url);
        resource.setContent(content);
        return resourceService.update(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public Resource update(@PathVariable long id, Resource resource) {
        resource.setId(id);
        return resourceService.update(resource);
    }
}
