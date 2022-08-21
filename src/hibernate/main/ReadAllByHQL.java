package hibernate.main;

import java.util.List;

//HQL hibernate query language
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Users;

public class ReadAllByHQL {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// Start transaction
			session.beginTransaction();

			List<Users> users = session.createQuery("from users").getResultList();

			for (Users temp : users) {
				System.out.println(temp);
			}

			// Commit the transaction
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}

	}

}
