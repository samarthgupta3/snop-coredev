package core;

import com.smartNodeProtocol.core.dao.HibernateDAO;
import com.smartNodeProtocol.core.dao.HibernateQuery;
import com.smartNodeProtocol.core.nodes.entity.Organisation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Samarth on 06-10-2017.
 */
public class Org {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HibernateDAO hibernateDAO = context.getBean(HibernateDAO.class);
        HibernateQuery hibernateQuery = context.getBean(HibernateQuery.class);
        Organisation organisation = new Organisation();
        organisation.setName("Samarth");
        hibernateDAO.saveOrUpdate(organisation);
        System.out.println("User::" + organisation);
        List<Organisation> list = hibernateQuery.query("from Organisation");
        for (Organisation p : list) {
            System.out.println("User List::" + p);
            p.setName(p.getName() + (p.getVersion() + 1));
            hibernateDAO.saveOrUpdate(p);
        }
        context.close();
    }
}
