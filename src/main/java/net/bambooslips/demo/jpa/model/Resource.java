package net.bambooslips.demo.jpa.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Eureka on 2016/5/16.
 */
@Entity
@Table(name = "resources")
public class Resource extends BaseModel{

    /**
     * 注明实体与数据库对应
     */
    @Column(nullable = false)
    @NotEmpty
    private String name;


    @Column(nullable = false)
    @NotEmpty
    private String url;

    @Column(nullable = false, length = 1024)
    @NotEmpty
    @Type(type="text")
    private String content;

    @Column(nullable = false, name = "type")
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    public Resource() {
    }

    /**
     * 对数据库进行操作的方法
     * @param name
     * @param url
     * @param content
     * @param resourceType
     */
    public Resource(String name, String url, String content, ResourceType resourceType) {
        this.name = name;
        this.url = url;
        this.content = content;
        this.resourceType = resourceType;
    }

    public  Resource update(Resource updated) {
        if(updated.getName() != null)this.setName(updated.getName());
        if(updated.getUrl() != null)this.setUrl(updated.getUrl());
        if(updated.getContent() != null)this.setContent(updated.getContent());
        if(updated.getResourceType() != null)this.setResourceType(updated.getResourceType());
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
}
