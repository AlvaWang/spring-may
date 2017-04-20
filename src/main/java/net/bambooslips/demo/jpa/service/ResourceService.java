package net.bambooslips.demo.jpa.service;

import net.bambooslips.demo.jpa.model.Resource;
import net.bambooslips.demo.jpa.model.ResourceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Eureka on 2016/5/16.
 * This service provides CRUD operations for Resource
 *
 */
public interface ResourceService {


        Resource create(Resource post);

        Resource delete(Long id);

        Resource update(Resource update);

        Iterable<Resource> findAll();

        Page<Resource> findAll(Pageable pageable);

        Page<Resource> findAll(Pageable pageable, ResourceType type);

        Resource findById(Long id);

        long count(ResourceType type);

        long count();

        public List<Resource> search(String searchTerm);


}
