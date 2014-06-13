package ptnkjke.site.controller.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Lopatin on 12.06.2014.
 */
public class DescriptionModel {
    private String name;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
