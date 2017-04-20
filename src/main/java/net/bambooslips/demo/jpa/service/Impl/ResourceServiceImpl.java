package net.bambooslips.demo.jpa.service.Impl;

import net.bambooslips.demo.exception.ResourceNotFoundException;
import net.bambooslips.demo.jpa.model.Resource;
import net.bambooslips.demo.jpa.model.ResourceType;
import net.bambooslips.demo.jpa.repository.ResourceRepository;
import net.bambooslips.demo.jpa.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceServiceImpl.class);

    protected static final int PAGE = 1;
    protected static final int PAGE_SIZE = 10;

    @Autowired
    private ResourceRepository resourceRepository;


    @Transactional
    @Override
    public long count() {
        return resourceRepository.count();
    }

    @Transactional
    @Override
    public long count(ResourceType type) {
        return resourceRepository.countByResourceType(type);
    }

    @Transactional
    @Override
    public Resource create(Resource resource) {
        LOG.debug("Creating a new resource with information: " + resource);
        return resourceRepository.save(resource);
    }

    @Transactional(rollbackFor = ResourceNotFoundException.class)
    @Override
    public Resource delete(Long resourceId) throws ResourceNotFoundException {
        LOG.debug("Deleting resource with id: " + resourceId);

        Resource deleted = resourceRepository.findOne(resourceId);

        if (deleted == null) {
            LOG.debug("No resource found with id: " + resourceId);
            throw new ResourceNotFoundException("No resource found with id: " + resourceId);
        }

        resourceRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Resource> findAll() {
        LOG.debug("Finding all resources");
        return resourceRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Resource> findAll(Pageable pageable) {
        LOG.debug("Finding resources by page.");
        return resourceRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Resource> findAll(Pageable pageable, ResourceType type) {
        LOG.debug("Finding resources by type.");
        return resourceRepository.findAllByResourceType(pageable, type);
    }

    @Transactional(readOnly = true)
    @Override
    public Resource findById(Long id) {
        LOG.debug("Finding resource by id: " + id);
        return resourceRepository.findOne(id);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Resource> search(String searchTerm) {
        LOG.debug("Searching resource by title: " + searchTerm);
        return resourceRepository.searchByName(searchTerm);
    }

    @Transactional(rollbackFor = ResourceNotFoundException.class)
    @Override
    public Resource update(Resource updated) throws ResourceNotFoundException {
        LOG.debug("Updating resource with information: " + updated);

        Resource resource = resourceRepository.findOne(updated.getId());

        if (resource == null) {
            LOG.debug("No resource found with id: " + updated.getId());
            throw new ResourceNotFoundException("Resource "+updated.getName()+" not found.");
        }
        resource.update(updated);

        return resource;
    }
    
}
