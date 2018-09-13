package edu.sse.ustc.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.session.HibernateSessionFactory;
import edu.sse.ustc.innerclass.Map;

@Entity
@SuppressWarnings("unchecked")
public class MapDao {

	private static SessionFactory sessionFactory ;

	public List<Map> getMap() {
		List<Map> maps = new ArrayList<Map>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from Map";
			Query query = session.createQuery(hql);
			maps = query.list();
			// if (!list.isEmpty()) {
			// for (int i = 0; i < list.size(); i++) {
			// Map map = (Map) list.get(i);
			// map.setMapURI("/environment/" + map.getEnvironmentId()
			// + "/map/" + map.getMapId());
			// maps.add(map);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return maps;
	}

	public List<Integer> getMapId() {
		List<Integer> mapIds = new ArrayList<Integer>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		// try
		// {
		// String hql = "from Map";
		// Query query = session.createQuery(hql);

		String sql = "select mapId from Map";
		Query query = session.createSQLQuery(sql);
		mapIds = query.list();
		// if (!list.isEmpty())
		// {
		// for (int i = 0; i < list.size(); i++)
		// {
		// Map map = (Map) list.get(i);
		// mapIds.add(map.getMapId());
		// }
		// }
		// }
		// catch (Exception e)
		// {
		// MyLog.error(e.toString(), this.getClass().getName());
		// }
		// finally
		// {
		// tx.commit();
		// session.close();
		// }

		return mapIds;
	}

	public List<Map> getMap(int environmentid) {
		List<Map> maps = new ArrayList<Map>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from Map where environmentId = '" + environmentid + "'";
			Query query = session.createQuery(hql);
			maps = query.list();
			// if (!list.isEmpty()) {
			// for (int i = 0; i < list.size(); i++) {
			// Map map = (Map) list.get(i);
			// map.setMapURI("/environment/" + map.getEnvironmentId()
			// + "/map/" + map.getMapId());
			// maps.add(map);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return maps;
	}

	public Map getMapByMapId(int environmentId, int mapId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Map map = new Map();
		try {
			String hql = "from Map where mapId ='" + mapId + "' and environmentId ='" + environmentId + "'";
			Query query = session.createQuery(hql);
			List<Map> maps = query.list();

			if (maps != null && !maps.isEmpty()) {

				map = maps.get(0);
			}

			// if (!list.isEmpty()) {
			// map = (Map) list.get(0);
			// map.setMapURI("/environment/" + environmentId + "/map/" + mapId);
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return map;
	}

	public boolean newMap(List<Map> mps) {
		
		if(mps == null || mps.isEmpty())
		{
			return false;
		}
		
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		boolean flag = true;

		for (int i = 0; i < mps.size(); i++) {
			Map map = mps.get(i);
			if (isExist(map)) {
				MyLog.error(map.toString() + "is Existed!", this.getClass().getName());
				flag = false;
			} else {

				try {
					session.save(map);

					if ((i+1) % 20 == 0 || i == mps.size() - 1) {
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
		return flag;

	}

	public boolean newMap(Map map) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		boolean flag = true;
		if (isExist(map)) {
			MyLog.error(map.toString() + "is Existed!", this.getClass().getName());
			flag = false;
		} else {

			try {
				session.save(map);
				tx.commit();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				 MyLog.error(e.toString(), this.getClass().getName());
			}
			session.close();
		}
		return flag;

	}

	private boolean isExist(Map us) {

		List<Map> maps = this.getMap();

		for (Map map : maps) {
			if (us.getMapId().equals(map.getMapId())) {
				return true;
			}
		}
		return false;
	}

	// public void updateMap(int mapId, int environmentId, String name, int
	// mapType, int mapFormat, int mapSizeInByte, int width, int height, int
	// scale,
	// String remark, String mapImageName)
	// {
	// Map map = getMapByMapId(environmentId, mapId);
	// map.setName(name);
	// map.setMapType(mapType);
	// map.setMapFormat(mapFormat);
	// map.setMapSizeInByte(mapSizeInByte);
	// map.setWidth(width);
	// map.setHeight(height);
	// map.setScale(scale);
	// map.setRemark(remark);
	// map.setMapImageName(mapImageName);
	// sessionFactory = HibernateSessionFactory.getSessionFactory();
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// try
	// {
	// session.update(map);
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

	public void delMap(int mapId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "delete Map where mapId ='" + mapId + "'";
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
