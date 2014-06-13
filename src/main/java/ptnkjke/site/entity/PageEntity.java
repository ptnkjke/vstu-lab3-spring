package ptnkjke.site.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Entity
public class PageEntity extends BaseEntity {
    private String title = "";
    @Column(columnDefinition = "TEXT", length = 65535)
    private String content = "";
    private String url = "";

    public String getTitle() {
        return title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
