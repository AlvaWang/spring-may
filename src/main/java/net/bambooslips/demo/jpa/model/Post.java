package net.bambooslips.demo.jpa.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.text.SimpleDateFormat;


@Entity
@Table(name = "posts")
public class Post extends BaseModel{
    private static final SimpleDateFormat SLUG_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    ;

    @Column(nullable = false)
    @NotEmpty
    private String title;

    @Column(nullable = false)
    @NotEmpty
    private String outline;

    @Column(nullable = false)
    private String thumbnail;

    @Type(type="text")
    @Column(nullable = false, length = 2048)
    @NotEmpty
    private String content;

    @Column(nullable = false, name = "type")
    @Enumerated(EnumType.STRING)
    private PostType postType;

    public Post(long id) {
        super();
        this.setId(id);
    }

    public Post() {
        super();
    }

    public Post(String title, String outline, String content, PostType postType) {
        this.title = title;
        this.outline = outline;
        this.content = content;
        this.postType = postType;
    }

    public Post(String title, String outline, String thumbnail, String content, PostType postType) {
        this.title = title;
        this.outline = outline;
        this.thumbnail = thumbnail;
        this.content = content;
        this.postType = postType;
    }

    public  Post update(Post updated) {
        if(updated.getTitle() != null)this.setTitle(updated.getTitle());
        if(updated.getOutline() != null)this.setOutline(updated.getOutline());
        if(updated.getThumbnail() != null)this.setThumbnail(updated.getThumbnail());
        if(updated.getContent() != null)this.setContent(updated.getContent());
        if(updated.getPostType() != null)this.setPostType(updated.getPostType());
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", outline='" + outline + '\'' +
                ", content='" + content + '\'' +
                ", postType=" + postType +
                '}';
    }
}
