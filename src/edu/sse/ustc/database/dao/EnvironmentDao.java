package edu.sse.ustc.database.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.session.HibernateSessionFactory;
import edu.sse.ustc.innerclass.Environment;

@Entity
@SuppressWarnings("unchecked")
public class EnvironmentDao {

	private SessionFactory sessionFactory;

	public List<Environment> getEnvironment() {
		List<Environment> environments = new ArrayList<Environment>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from Environment";
			Query query = session.createQuery(hql);
			environments = query.list();
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return environments;
	}

	public List<Integer> getEnviromentId() {
		List<Integer> environmentIds = new ArrayList<Integer>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "select environmentId from Environment";
			Query query = session.createQuery(hql);
			environmentIds = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// Environment environment = (Environment) list.get(i);
			// environments.add(environment);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return environmentIds;
	}

	public Environment getEnvironmentById(int environmentId) {

		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Environment environment = new Environment();
		try {
			String hql = "from Environment where environmentId ='" + environmentId + "'";
			Query query = session.createQuery(hql);
			List<Environment> list = query.list();
			if (!list.isEmpty()) {
				environment = list.get(0);
				// environment.setEnvironmentURI("/environment/" +
				// environment.getEnvironmentId());
			}
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return environment;
	}

	public boolean newEnvironment(List<Environment> ems) {

		if(ems == null || ems.isEmpty())
		{
			return false;
		}
		
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		for (Environment environment : ems) {
			// System.out.println(environment.toString()+" "+this.isExist(environment));
			if (isExist(environment)) {
				MyLog.info(environment.toString() + "is Exist!", this.getClass().getName());
			} else {
				try {
					// System.out.println(environment.getName());
					session.save(environment);
					tx.commit();
				} catch (HibernateException e) {

					MyLog.error(e.toString(), this.getClass().getName());
					return false;
				}
			}
		}
		session.close();
		return true;

	}

	private boolean isExist(Environment us) {

		List<Environment> environments = this.getEnvironment();

		for (Environment environment : environments) {
			if ((int) us.getEnvironmentId() == (int) environment.getEnvironmentId()) {
				return true;
			}
		}
		return false;
	}

	public void updateEnvironment(int environmentId, String name) {
		Environment environment = this.getEnvironmentById(environmentId);
		environment.setEnvironmentId(environmentId);
		environment.setEnvironmentName(name);
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(environment);
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

	}

	public void delEnvironment(int environmentId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "delete Environment where environmentId ='" + environmentId + "'";
			Query query = session.createQuery(hql);
			query.setInteger(0, 1);
			query.executeUpdate();

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
	}

}
