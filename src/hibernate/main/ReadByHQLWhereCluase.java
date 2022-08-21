package hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Users;

public class ReadByHQLWhereCluase {

	public static void main(String[] args) {
	
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();

			try {

				// Start transaction
				session.beginTransaction();

				List<Users> users = session.createQuery("from users where first_name='Sakil'"+""
															+ "OR last_name='chaitanya'").getResultList();
						

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
