package core;

import com.smartNodeProtocol.core.dao.HibernateDAO;
import com.smartNodeProtocol.core.dao.HibernateQuery;
import com.smartNodeProtocol.core.nodes.entity.Organisation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Core {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HibernateDAO hibernateDAO = context.getBean(HibernateDAO.class);
        HibernateQuery hibernateQuery = context.getBean(HibernateQuery.class);

        Organisation organisation = new Organisation();
        organisation.setName("New Day Care");
        hibernateDAO.saveOrUpdate(organisation);
        System.out.println("Organisation::" + organisation);
        List<Organisation> listP = hibernateQuery.query("from Organisation");
        for (Organisation p : listP) {
            System.out.println("Organisation List::" + p);
            p.setName(p.getName()+(p.getVersion()+1));
            hibernateDAO.saveOrUpdate(p);
        }
        context.close();
    }
}
