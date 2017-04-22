package net.bambooslips.demo.jpa.repository;

import net.bambooslips.demo.jpa.model.Resource;
import net.bambooslips.demo.jpa.model.ResourceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    //自定义查询，加参数,参数命名u.name = :searchTerm
    @Query(
            "Select r FROM Resource r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) "
    )
    //带入参数
    public List<Resource> searchByName(@Param("searchTerm") String searchTerm);

    Page<Resource> findAllByResourceType(Pageable pageable, ResourceType type);

    long countByResourceType(ResourceType type);
}