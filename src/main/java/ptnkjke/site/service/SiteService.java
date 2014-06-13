package ptnkjke.site.service;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ptnkjke.site.entity.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Lopatin on 08.06.2014.
 */
@Service
public class SiteService {
    private static final String fileDir = "c:/files";

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveorUpdate(BaseEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    public void saveImage(File file, String name) {

    }

    @Transactional
    public void deleteEntity(BaseEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    /**
     * Получить страницу "Контакты"
     *
     * @return
     */
    public PageEntity getPageContact() {
        Session session = sessionFactory.getCurrentSession();
        PageEntity pageEntity = (PageEntity) session.createCriteria(PageEntity.class).add(Restrictions.eq("url", "/contacts")).uniqueResult();
        if (pageEntity == null) {
            pageEntity = new PageEntity();
            pageEntity.setUrl("/contacts");

            saveorUpdate(pageEntity);
        }
        return pageEntity;
    }

    /**
     * Получить страницу "О компании"
     *
     * @return
     */
    public PageEntity getPageAbout() {
        Session session = sessionFactory.getCurrentSession();

        PageEntity pageEntity = (PageEntity) session.createCriteria(PageEntity.class).add(Restrictions.eq("url", "/about")).uniqueResult();
        if (pageEntity == null) {
            pageEntity = new PageEntity();
            pageEntity.setUrl("/about");

            saveorUpdate(pageEntity);
        }
        return pageEntity;
    }

    /**
     * Сохранить изменения "Контакты"
     *
     * @param newHtml
     */
    @Transactional
    public void savePageContact(String newHtml) {
        PageEntity pageEntity = getPageContact();
        pageEntity.setContent(newHtml);
        saveorUpdate(pageEntity);
    }

    /**
     * Сохранение изменения в "О компании"
     *
     * @param newHtml
     */
    @Transactional
    public void savePageAbout(String newHtml) {
        PageEntity pageEntity = getPageAbout();
        pageEntity.setContent(newHtml);
        saveorUpdate(pageEntity);
    }

    /**
     * Получить список предоставляемых услуг
     *
     * @return
     */
    public List<DescriptionEntity> getServiceList() {
        List<DescriptionEntity> list = sessionFactory.getCurrentSession()
                .createCriteria(DescriptionEntity.class)
                .add(Restrictions.eq("typeDescription", TypeDescription.SERVICE))
                .list();
        return list;
    }

    /**
     * Получить список продукции
     *
     * @return
     */
    public List<DescriptionEntity> getProductList() {
        List<DescriptionEntity> list = sessionFactory.getCurrentSession()
                .createCriteria(DescriptionEntity.class)
                .add(Restrictions.eq("typeDescription", TypeDescription.PRODUCT))
                .list();
        return list;
    }

    public ImgFile getImgFile(Integer id) {
        return (ImgFile) sessionFactory.getCurrentSession().load(ImgFile.class, id);
    }

    @Transactional
    public ImgFile createImgFile(MultipartFile multipartFile) {
        ImgFile imgFile = new ImgFile();

        if (!new File(fileDir).exists()) {
            new File(fileDir).mkdirs();
        }
        File f = new File(fileDir, multipartFile.getOriginalFilename());

        try {
            IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }

        imgFile.setPathToFile(f.getAbsolutePath());

        sessionFactory.getCurrentSession().save(imgFile);
        return imgFile;
    }

    @Transactional
    public void delete(Integer id, Class clss) {
        Object ob = sessionFactory.getCurrentSession().get(clss, id);
        sessionFactory.getCurrentSession().delete(ob);
    }

}
