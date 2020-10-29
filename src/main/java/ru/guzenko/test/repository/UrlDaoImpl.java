package ru.guzenko.test.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.guzenko.test.model.Url;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UrlDaoImpl implements UrlDao {

    private static final Logger logger = LoggerFactory.getLogger(UrlDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addWords(Url url) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(url);

        logger.info("Words with current URL successfully saved. URL: " + url);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Url> listAllUrls() {
        Session session = sessionFactory.getCurrentSession();
        List<Url> urlList = session.createQuery("from Url").list();

        for (Url url : urlList) {
            logger.info("List of words with URL " + url + " successfully loaded.");
        }

        return urlList;
    }
}
