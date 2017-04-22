package net.bambooslips.demo.jpa.repository;

import javax.transaction.Transactional;

import net.bambooslips.demo.jpa.model.Post;
import net.bambooslips.demo.jpa.model.PostType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {

    // 手动使用 HQL 查询 Dao接口层及mapper实现层
    @Query(
            "Select p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) "
    )
    public List<Post> searchByTitle(@Param("searchTerm") String searchTerm);

    Page<Post> findByPostTypeOrderByCreatedAtDesc(Pageable pageable, PostType type);
//    findAllByPostType

    long countByPostType(PostType type);

}