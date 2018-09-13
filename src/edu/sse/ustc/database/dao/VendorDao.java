package edu.sse.ustc.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.session.HibernateSessionFactory;
import edu.sse.ustc.innerclass.Vendor;

public class VendorDao {
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public String getVendor(String mac) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String rs = null;
		try {
			String sql = "select vendor from Vendor where mac = '" + mac + "'";
			Query query = session.createSQLQuery(sql);

			List<String> list = query.list();
			if (list != null && !list.isEmpty()) {

				rs = list.get(0);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return rs;
	}

	public boolean newVendor(List<Vendor> vendors) {

		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		boolean flag = true;

		for (int i = 0; i < vendors.size(); i++) {

			Vendor ven = vendors.get(i);
			try {
				session.save(ven);
				if ((i+1) % 20 == 0 || i == vendors.size() - 1) {
					session.flush();
					session.clear();
					tx.commit();
					tx = session.beginTransaction();
				}
			} catch (Exception e) {
				flag = false;
				MyLog.error(e.toString(), this.getClass().getName());
			}

		}

		session.close();

		return flag;

	}

	public boolean newVendor(Vendor ven) {

		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(ven);
		tx.commit();
		session.close();

		return true;

	}

}
