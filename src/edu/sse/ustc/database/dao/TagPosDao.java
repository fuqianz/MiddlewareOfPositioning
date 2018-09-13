package edu.sse.ustc.database.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.dao.helper.MapHelper;
import edu.sse.ustc.database.session.HibernateSessionFactory;
import edu.sse.ustc.innerclass.TagPos;

@SuppressWarnings("unchecked")
public class TagPosDao {
	private SessionFactory sessionFactory;

	public List<TagPos> getTagPos() {

		List<TagPos> poses = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos";
			Query query = session.createQuery(hql);
			poses = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public List<Integer> getTagPosId() {
		List<Integer> posIds = new ArrayList<Integer>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "select tagposId from TagPos";
			Query query = session.createQuery(hql);
			posIds = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// posIds.add(pos.getTagposId());
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return posIds;
	}
	
	public TagPos getPosListByMacAndChosenTime(String sta_mac, String datetime) {
		List<TagPos> poses = new ArrayList<TagPos>();
		List<TagPos> res = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where mac ='" + sta_mac + "'and  time <='" + datetime
					+ "' order by time desc,seqNum desc limit 1";
			Query query = session.createQuery(hql);
			poses = query.list();
			Date now = Helper.stringToDate(datetime);
            for(TagPos pos : poses){
//            	if((now.getTime()-pos.getTime().getTime())<(10*60*1000))
            		res.add(pos);
            }
            poses.removeAll(poses);

			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}
		if(!res.isEmpty())
		return res.get(0);
		else return null;
	}
	
	public TagPos getPosListByMacAndTime(String sta_mac, String datetime) {
		List<TagPos> poses = new ArrayList<TagPos>();
		List<TagPos> res = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where mac ='" + sta_mac + "'and  time <='" + datetime
					+ "' order by time desc,seqNum desc limit 1";
			Query query = session.createQuery(hql);
			poses = query.list();
			Date now = new Date();
            for(TagPos pos : poses){
            	if((now.getTime()-pos.getTime().getTime())<(10*60*1000))
            		res.add(pos);
            }
            poses.removeAll(poses);

			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}
		if(!res.isEmpty())
		return res.get(0);
		else return null;
	}
	
	
	
	public List<TagPos> getPosListByTimeAndEnvironment(int environmentId, String datetime) {
		List<TagPos> poses = new ArrayList<TagPos>();
		List<TagPos> res = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql = "select * from (select * from TagPos where environmentId ='" + environmentId
					+ "'and  time <='" + datetime + "' order by time desc,seqNum desc)as a group by tagId";
			System.out.println(sql);
			SQLQuery sqlquery = session.createSQLQuery(sql).addEntity(TagPos.class);
			poses = sqlquery.list();
			Date now = Helper.stringToDate(datetime);
			for(TagPos pos : poses){
            	if((now.getTime()-pos.getTime().getTime())<=(10*60*1000))
            		res .add(pos);
            }
            poses.removeAll(poses);

			// System.out.println(list.size());
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return res;
	}

	public List<TagPos> getPosListByTimeAndMap(int environmentId, int mapId, String datetime) {
		// if (MapHelper.getMapByMapId(environmentId, mapId).getMapId() == null)
		// {
		// return new ArrayList<TagPos>();
		// }

		List<TagPos> poses = new ArrayList<TagPos>();
		List<TagPos> res = new ArrayList<TagPos>();

		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql = "select * from (select * from TagPos where environmentId ='" + environmentId
					+ "'and mapId='"+mapId+"'and time <='" + datetime + "' order by time desc,seqNum desc)as a group by tagId ";
			SQLQuery sqlquery = session.createSQLQuery(sql).addEntity(TagPos.class);
			poses = sqlquery.list();
			Date now = Helper.stringToDate(datetime);
			for(TagPos pos : poses){
            	if((now.getTime()-pos.getTime().getTime())<=(10*60*1000))
            		res.add(pos);
            }
            poses.removeAll(poses);

			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return res;
	}

	public List<TagPos> getTagListByTime(int environmentId, int mapId, String datetimeStart, String datetimeEnd) {
		// if (MapHelper.getMapByMapId(environmentId, mapId).getMapId() == null)
		// {
		// return new ArrayList<TagPos>();
		// }

		List<TagPos> poses = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where environmentId ='" + environmentId + "'and mapId='" + mapId
					+ "'and time between '" + datetimeStart + "'and'" + datetimeEnd + "'";
			Query query = session.createQuery(hql);
			poses = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public List<TagPos> getTagListByTime2(int environmentId, String datetimeStart, String datetimeEnd) {
		List<TagPos> poses = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where environmentId ='" + environmentId + "'and time between '" + datetimeStart
					+ "'and'" + datetimeEnd + "'";
			Query query = session.createQuery(hql);
			poses = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public List<String> getMacListByTimeAndMap(int environmentId, int mapId, String datetimeStart, String datetimeEnd) {

		List<String> poses = new ArrayList<String>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql = "select distinct mac from TagPos where mapId ='" + mapId + "'and environmentId ='"
					+ environmentId + "'and time between '" + datetimeStart + "'and'" + datetimeEnd + "'";
			Query query = session.createSQLQuery(sql);
			poses = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// String pos = (String) list.get(i);
			// poses.add(pos);
			// }
			// }
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public List<String> getMacListByTimendEnvironment(int environmentId, String datetimeStart, String datetimeEnd) {
		List<String> poses = new ArrayList<String>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql = "select distinct mac from TagPos where environmentId ='" + environmentId
					+ "'and time between '" + datetimeStart + "'and'" + datetimeEnd + "'";
			Query query = session.createSQLQuery(sql);
			poses = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// String pos = (String) list.get(i);
			// poses.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public List<TagPos> getChosenTagListByTime(String mac, String datetimeStart, String datetimeEnd) {
		List<TagPos> poses = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where mac = '" + mac + "'and time between '" + datetimeStart + "'and'"
					+ datetimeEnd + "' order by time asc,seqNum asc";
			Query query = session.createQuery(hql);
			poses = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
			// MyLog.error(e.toString(), this.getClass().getName());();
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public List<TagPos> getLatestPosByEnvironment(int environmentId)
    {
        List<TagPos> poses = new ArrayList<TagPos>();
        List<TagPos> res = new ArrayList<TagPos>();

        sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try
        {	
            String hql = "select * from (select * from TagPos where environmentId ='" + environmentId
                    + "' order by time desc,seqNum desc)as a group by tagId";
            Query query = session.createSQLQuery(hql).addEntity(TagPos.class);
            poses = query.list();
            Date now = new Date();
            for(TagPos pos : poses){
            	if((now.getTime()-pos.getTime().getTime())<=(1000*60*10))
            		res.add(pos);
            }
            poses.removeAll(poses);
//            if (!list.isEmpty())
//            {
//                for (int i = 0; i < list.size(); i++)
//                {
//                    TagPos pos = (TagPos) list.get(i);
//                    poses.add(pos);
//                }
//            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            tx.commit();
            session.close();
        }

        return res;
    }

	public List<TagPos> getLatestPosByMap(int environmentId, int mapId) {
		List<TagPos> tempposes = new ArrayList<TagPos>();
		List<TagPos> poses = new ArrayList<TagPos>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			String sql = "select * from (select * from TagPos where environmentId ='" + environmentId + "'and mapId ='"
					+ mapId + "' order by time desc,seqNum desc)as a group by tagId";
			Query query = session.createSQLQuery(sql).addEntity(TagPos.class);
			tempposes = query.list();
			 Date now = new Date();
			 System.out.println(tempposes.size());
	            for(TagPos pos : tempposes){
	            	//System.out.println(now.getTime()+" "+pos.getTime()+" "+(now.getTime()-pos.getTime().getTime())+"  "+((now.getTime()-pos.getTime().getTime())/(10*60*1000)));
	            	if(((now.getTime()-pos.getTime().getTime())<(10*60*1000)))
	            	
	            		poses.add(pos);
	            }
	            tempposes.removeAll(tempposes);
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// TagPos pos = (TagPos) list.get(i);
			// poses.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public TagPos getLatestPosByMac(int environmentId, int mapId, String mac) {

		TagPos poses = new TagPos();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where environmentId ='" + environmentId + "'and mapId ='" + mapId + "'and mac ='"
					+ mac + "' order by time desc,seqNum desc limit 1";
			Query query = session.createQuery(hql);
			List<TagPos> list = query.list();
			if (!list.isEmpty()) {
				poses = list.get(0);
			}

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public TagPos getLastTimeTag(String mac, String time) {
		TagPos poses = new TagPos();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where mac ='" + mac + "'and time < '" + time + "' order by time desc,seqNum desc limit 1";
			Query query = session.createQuery(hql);
			List<TagPos> list = query.list();
			
			if (!list.isEmpty()) {
				poses = list.get(0);

			}
			
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public TagPos getNextTimeTag(String mac, String time) {
		TagPos poses = new TagPos();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from TagPos where mac ='" + mac + "'and  time > '" + time + "' order by time asc,seqNum asc limit 1";
			Query query = session.createQuery(hql);
			List<TagPos> list = query.list();
			if (!list.isEmpty()) {
				poses = list.get(0);

			}

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return poses;
	}

	public boolean newTagPos(List<TagPos> aps) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		for (int i = 0; i < aps.size(); i++) {

			session.save(aps.get(i));

			if ((i+1) % 1000 == 0 || i == aps.size() - 1) {
				try {
					session.flush();
					session.clear();
					tx.commit();
					tx = session.beginTransaction();
				} catch (Exception e) {
					MyLog.error(e.toString(), this.getClass().getName());
					return false;
				}
			}

		}

		session.close();

		return true;

	}

	public boolean newTagPos(TagPos aps) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(aps);

		tx.commit();
		session.close();

		return true;

	}

	public void delTagPos(String mac, String time) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String sql = "delete (select * from TagPos where mac ='" + mac + "'and  time <='" + time
					+ "' order by time desc,seqNum desc limit 1)";
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
	}

	public List<edu.sse.ustc.database.returnitem.Heatmap> getLocationTimesList(int environmentId, int mapId,
			String datetimeStart, String datetimeEnd) {
		List<edu.sse.ustc.database.returnitem.Heatmap> locations = new ArrayList<edu.sse.ustc.database.returnitem.Heatmap>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			// String hql =
			// "select new edu.sse.ustc.database.item.Heatmap(pos_x,pos_y,pos_z,loc_times) from (select point_x,point_y,point_z,count(*) from TagPos where environmentId ='"
			// + environmentId + "'and mapId = '"+mapId+"'and time between '" +
			// datetimeStart + "'and'" + datetimeEnd
			// + "' group by point_x,point_y,point_z)as a";
			String sql = "select x_pos as point_x,y_pos as point_y,z_pos as point_z,count(*) as loc_times from TagPos where environmentId ='"
					+ environmentId + "'and mapId = '" + mapId + "'and time between '" + datetimeStart + "'and'"
					+ datetimeEnd + "' group by x_pos,y_pos,z_pos";
			Query query = session.createSQLQuery(sql).addScalar("point_x", Hibernate.INTEGER)
					.addScalar("point_y", Hibernate.INTEGER).addScalar("point_z", Hibernate.INTEGER)
					.addScalar("loc_times", Hibernate.INTEGER);
			query.setResultTransformer(Transformers.aliasToBean(edu.sse.ustc.database.returnitem.Heatmap.class));

			locations = query.list();
			// if (!list.isEmpty())
			// {
			// for (int i = 0; i < list.size(); i++)
			// {
			// edu.sse.ustc.database.item.Heatmap pos =
			// (edu.sse.ustc.database.item.Heatmap) list.get(i);
			// locations.add(pos);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return locations;
	}

}
