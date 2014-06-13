package ptnkjke.site.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ptnkjke.site.entity.ImgFile;
import ptnkjke.site.service.SiteService;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void getFile(@PathVariable("id") Integer objectId, HttpServletResponse httpResponse) {
        try {
            // get your file as InputStream
            ImgFile imgFile = siteService.getImgFile(objectId);
            File file = new File(imgFile.getPathToFile());
            InputStream is = new FileInputStream(file);
            // copy it to response's OutputStream
            String mimeType = URLConnection.guessContentTypeFromStream(new FileInputStream(file));
            httpResponse.setContentType(mimeType);
            IOUtils.copy(is, httpResponse.getOutputStream());
            httpResponse.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream :" + ex.toString());
        }
    }
}
