package ptnkjke.site.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Entity
public class DescriptionEntity extends BaseEntity {
    private String name;

    @OneToOne(mappedBy = "description", cascade = CascadeType.ALL)
    private ImgFile imgFile;

    private TypeDescription typeDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImgFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(ImgFile imgFile) {
        this.imgFile = imgFile;
    }

    public TypeDescription getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }
}
