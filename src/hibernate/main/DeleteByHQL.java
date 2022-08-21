package hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Users;

public class DeleteByHQL {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// Start transaction
			session.beginTransaction();

			 session.createQuery("delete from users where user_id=5").executeUpdate();

			

			// Commit the transaction
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}


	}

}
