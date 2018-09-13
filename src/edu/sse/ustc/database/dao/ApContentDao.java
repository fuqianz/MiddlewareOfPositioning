package edu.sse.ustc.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.session.HibernateSessionFactory;
import edu.sse.ustc.innerclass.AP;

@SuppressWarnings("unchecked")
public class ApContentDao {

	private SessionFactory sessionFactory;

	public List<AP> getAp() {
		List<AP> aps = new ArrayList<AP>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from AP";
			Query query = session.createQuery(hql);
			aps = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// AP ap = (AP) list.get(i);
			// aps.add(ap);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return aps;
	}

	public List<Integer> getApId() {
		List<Integer> apIds = new ArrayList<Integer>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql = "select apId from ap";
			Query query = session.createSQLQuery(sql);
			apIds = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// AP ap = (AP) list.get(i);
			// apIds.add(ap.getApId());
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return apIds;
	}

	public AP getApByApId(int apId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		AP ap = new AP();
		try {
			String hql = "from AP where apId ='" + apId + "'";
			Query query = session.createQuery(hql);
			List<AP> list = query.list();

			if (list != null && !list.isEmpty()) {
				ap = (AP) list.get(0);
			}
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return ap;
	}

	public List<AP> getAp(int environmentId, int mapId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<AP> aps = new ArrayList<AP>();
		try {
			String hql = "from AP where apMapIdNow='" + mapId + "'";
			Query query = session.createQuery(hql);
			aps = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// AP ap = (AP) list.get(i);
			//
			// ap.setApURI("/environment/" + environmentId + "/map/" + mapId +
			// "/ap/" + ap.getMac());
			//
			// aps.add(ap);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return aps;
	}

	public AP getApByApMac(int environmentId, int mapId, String apMac) {

		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		AP ap = new AP();
		try {
			String hql = "from AP where mac='" + apMac + "' and apMapIdNow='" + mapId + "'";
			Query query = session.createQuery(hql);
			List<AP> list = query.list();
			if (list != null && !list.isEmpty()) {
				ap = (AP) list.get(0);
				// ap.setApURI("/environment/" + environmentId + "/map/" + mapId
				// + "/ap/" + ap.getMac());
			}
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return ap;
	}

	public boolean newAp(List<AP> res) {
		
		if(res == null || res.isEmpty())
		{
			return false;
		}
		
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < res.size(); i++) {

			AP ap = res.get(i);

			if (isExist(ap)) {
				MyLog.info(ap.toString() + "is Existed!", this.getClass().getName());
			} else {

				try {
					session.save(ap);

					if ((i + 1) % 20 == 0 || i == res.size() - 1) {
						session.flush();
						session.clear();
						tx.commit();
						tx = session.beginTransaction();
					}
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					MyLog.error(e.toString(), this.getClass().getName());
				}
			}
		}
		session.close();

		return true;

	}

	public boolean newAp(AP res) {

		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (isExist(res)) {
			MyLog.info(res.toString() + "is Existed!", this.getClass().getName());
		} else {
			try {
				session.save(res);
				tx.commit();
			} catch (HibernateException e) {

				MyLog.error(e.toString(), this.getClass().getName());
				return false;
			} finally {
				session.close();
			}
		}

		return true;

	}

	private boolean isExist(AP ap) {
		List<AP> res = this.getAp();
		if (res.isEmpty()) {
			return false;
		} else {
			for (AP AP : res) {
				if (ap.getApId().equals(AP.getApId())) {
					return true;
				}
			}
			return false;
		}

	}

	// public void updateAp(int apId, String apName, String mac, int status,
	// String productModel, String ipv4Addr, String ipv6Addr, String remark,
	// int apType, String extInfo, int pointTypeNow, int xnow, int ynow, int
	// znow)
	// {
	// AP ap = getApByApId(apId);
	// ap.setName(apName);
	// ap.setMac(mac);
	// ap.setStatus(status);
	// ap.setProductModel(productModel);
	// ap.setIp4addr(ipv4Addr);
	// ap.setIp6addr(ipv6Addr);
	// ap.setRemark(remark);
	// ap.setApType(apType);
	// ap.setExtInfo(extInfo);
	// ap.setPointTypeNow(pointTypeNow);
	// ap.setXnow(xnow);
	// ap.setYnow(ynow);
	// ap.setZnow(znow);
	// sessionFactory = HibernateSessionFactory.getSessionFactory();
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// try
	// {
	// session.update(ap);
	// }
	// catch (Exception e)
	// {
	// System.out.println("ERROR 99");
	// }
	// finally
	// {
	// tx.commit();
	// session.close();
	// }
	//
	// }

	public void delAp(int apId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "delete AP where apId ='" + apId + "'";
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
