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
import edu.sse.ustc.innerclass.Tag;

@SuppressWarnings("unchecked")
public class TagContentDao {
	private SessionFactory sessionFactory;

	public List<Tag> getTag() {
		List<Tag> tags = new ArrayList<Tag>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "from Tag";
			Query query = session.createQuery(hql);
			tags = query.list();
			// if (!list.isEmpty()) {
			// for (int i = 0; i < list.size(); i++) {
			// Tag tag = (Tag) list.get(i);
			// tags.add(tag);
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return tags;
	}

	public List<byte[]> getTagId() {
		List<byte[]> tagIds = new ArrayList<byte[]>();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "select tagId from Tag";
			Query query = session.createSQLQuery(hql);
			tagIds = query.list();
			// if (!list.isEmpty()) {
			// for (int i = 0; i < list.size(); i++) {
			// Tag tag = (Tag) list.get(i);
			// tagIds.add(tag.getTagId());
			// }
			// }

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}

		return tagIds;
	}

	public boolean newTag(List<Tag> res) {
		
		if(res == null || res.isEmpty())
		{
			return false;
		}
		
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		boolean flag = true;

		for (int i = 0; i < res.size(); i++) {

			Tag tag = res.get(i);
			if (this.isExist(tag)) {
				flag = false;
				MyLog.info(tag.toString() + " is Existed", this.getClass().getName());
				continue;

			}
			// System.out.println(tag.toString());
			try {
				session.save(tag);

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

		session.close();
		return flag;

	}

	public boolean newTag(Tag tag) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (isExist(tag)) {
			MyLog.info(tag.toString() + " is Existed", this.getClass().getName());
			return false;

		} else {
			session.save(tag);
			tx.commit();
		}

		session.close();

		return true;

	}

	private boolean isExist(Tag tag) {
		List<Tag> res = this.getTag();

		if (res.isEmpty()) {
			return false;
		} else {
			for (Tag rtag : res) {
				// System.out.println(rtag.getMac()+" "+tag.getMac());
				if (tag.getMac().equals(rtag.getMac())) {
					return true;
				}
			}
			return false;
		}

	}

	public Tag getTagByTagId(byte[] tagId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tag tag = new Tag();
		try {
			String hql = "from Tag where tagId ='" + tagId + "'";
			Query query = session.createQuery(hql);
			List list = query.list();
			if (!list.isEmpty())
				tag = (Tag) list.get(0);
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return tag;
	}

	public Tag getTagByMac(String mac) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tag tag = new Tag();
		try {
			String hql = "from Tag where mac ='" + mac + "'";
			Query query = session.createQuery(hql);
			List list = query.list();
			if (!list.isEmpty())
				tag = (Tag) list.get(0);
		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
		return tag;
	}

	// public void updateMap(byte[] tagId, String name, int tagType, String
	// remark, boolean enable, String charageTime, String rate, String model,
	// String mac)
	// {
	// Tag tag = getTagByTagId(tagId);
	// tag.setName(name);
	// tag.setTagType(tagType);
	// tag.setRemark(remark);
	// tag.setEnable(enable);
	// tag.setCharageTime(charageTime);
	// tag.setRate(rate);
	// tag.setModel(model);
	// tag.setMac(mac);
	// sessionFactory = HibernateSessionFactory.getSessionFactory();
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// try
	// {
	// session.update(tag);
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

	public void delTags(byte[] tagId) {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "delete Tag where tagId ='" + tagId + "'";
			Query query = session.createQuery(hql);
			// query.setInteger(0, 1);
			query.executeUpdate();

		} catch (Exception e) {
			MyLog.error(e.toString(), this.getClass().getName());
		} finally {
			tx.commit();
			session.close();
		}
	}

}
