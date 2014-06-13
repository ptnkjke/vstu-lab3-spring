package ptnkjke.site.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Entity
public class ImgFile extends BaseEntity {
    private String pathToFile;

    @OneToOne
    private DescriptionEntity description;

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public DescriptionEntity getDescription() {
        return description;
    }

    public void setDescription(DescriptionEntity description) {
        this.description = description;
    }
}
