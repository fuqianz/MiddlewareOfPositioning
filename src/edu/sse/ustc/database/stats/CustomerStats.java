package edu.sse.ustc.database.stats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.database.returnitem.CustomerInfo;
import edu.sse.ustc.database.returnitem.Customers;
import edu.sse.ustc.database.session.HibernateSessionFactory;
import edu.sse.ustc.innerclass.TagPos;

public class CustomerStats {
	public Customers getCustomersInEnvironment(int environmentId, String datetime_start, String datetime_end,
			int months, int request_type) {
		Customers rs = new Customers();
		List<CustomerInfo> newcustomers_list = new ArrayList<CustomerInfo>();
		List<CustomerInfo> oldcustomers_list = new ArrayList<CustomerInfo>();
		// get all the customers' macs in the required range
		List<String> macList = TagPosHelper.getMacListByTimendEnvironment(environmentId, datetime_start, datetime_end);

		if (request_type == 1) {
			for (String mac : macList) {
				CustomerInfo cus = new CustomerInfo();
				cus.setMac(mac);
				if (isNewCustomerInEnvironment(mac, datetime_start, months, environmentId))
					newcustomers_list.add(cus);
			}
			rs.setNewcustomers_list(newcustomers_list);
			rs.setNewcustomers_count(newcustomers_list.size());
			return rs;
		} else if (request_type == 2) {
			for (String mac : macList) {
				CustomerInfo cus = new CustomerInfo();
				cus.setMac(mac);
				if (!isNewCustomerInEnvironment(mac, datetime_start, months, environmentId))
					oldcustomers_list.add(cus);
			}
			rs.setOldcustomers_list(oldcustomers_list);
			rs.setOldcustomers_count(oldcustomers_list.size());
			return rs;
		} else if (request_type == 3) {
			for (String mac : macList) {
				CustomerInfo cus = new CustomerInfo();
				cus.setMac(mac);
				if (isNewCustomerInEnvironment(mac, datetime_start, months, environmentId))
					newcustomers_list.add(cus);
				else
					oldcustomers_list.add(cus);
			}
			rs.setNewcustomers_list(newcustomers_list);
			rs.setNewcustomers_count(newcustomers_list.size());
			rs.setOldcustomers_list(oldcustomers_list);
			rs.setOldcustomers_count(oldcustomers_list.size());
			return rs;
		} else {
			return null;
		}

	}

	private boolean isNewCustomerInEnvironment(String mac, String datetime_start, int month, int environmentId) {
		List<TagPos> poses = new ArrayList<TagPos>();
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String datetime_before = getDateBeforeMonths(datetime_start, month);
		try {
			String hql = "from Customer where mac = '" + mac + "'and latestEnvironmentId ='" + environmentId
					+ "'and latestTime between '" + datetime_before + "'and'" + datetime_start + "'";
			Query query = session.createQuery(hql);
			List list = query.list();
			if (!list.isEmpty())
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
		return true;
	}

	public Customers getCustomersInMap(int environmentId, int mapId, String datetime_start, String datetime_end,
			int months, int request_type) {
		Customers rs = new Customers();
		List<CustomerInfo> newcustomers_list = new ArrayList<CustomerInfo>();
		List<CustomerInfo> oldcustomers_list = new ArrayList<CustomerInfo>();
		// get all the customers' macs in the required range
		List<String> macList = TagPosHelper.getMacListByTimeAndMap(environmentId, mapId, datetime_start, datetime_end);

		if (request_type == 1) {
			for (String mac : macList) {
				CustomerInfo cus = new CustomerInfo();
				cus.setMac(mac);
				if (isNewCustomerInMap(mac, datetime_start, months, environmentId, mapId))
					newcustomers_list.add(cus);
			}
			rs.setNewcustomers_list(newcustomers_list);
			rs.setNewcustomers_count(newcustomers_list.size());
			return rs;
		} else if (request_type == 2) {
			for (String mac : macList) {
				CustomerInfo cus = new CustomerInfo();
				cus.setMac(mac);
				if (!isNewCustomerInMap(mac, datetime_start, months, environmentId, mapId))
					oldcustomers_list.add(cus);
			}
			rs.setOldcustomers_list(oldcustomers_list);
			rs.setOldcustomers_count(oldcustomers_list.size());
			return rs;
		} else if (request_type == 3) {
			for (String mac : macList) {
				CustomerInfo cus = new CustomerInfo();
				cus.setMac(mac);
				if (isNewCustomerInMap(mac, datetime_start, months, environmentId, mapId))
					newcustomers_list.add(cus);
				else
					oldcustomers_list.add(cus);
			}
			rs.setNewcustomers_list(newcustomers_list);
			rs.setNewcustomers_count(newcustomers_list.size());
			rs.setOldcustomers_list(oldcustomers_list);
			rs.setOldcustomers_count(oldcustomers_list.size());
			return rs;
		} else {
			return null;
		}

	}

	private boolean isNewCustomerInMap(String mac, String datetime_start, int month, int environmentId, int mapId) {
		List<TagPos> poses = new ArrayList<TagPos>();
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String datetime_before = getDateBeforeMonths(datetime_start, month);

		try {
			String hql = "from Customer where mac = '" + mac + "'and latestEnvironmentId ='" + environmentId + "'and latestTime between '" + datetime_before + "'and'" + datetime_start + "'";
			Query query = session.createQuery(hql);
			List list = query.list();
			
			if (!list.isEmpty()){
				return false;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
		return true;
	}

	// calculate datetime before given month number
	private String getDateBeforeMonths(String datetime, int month) {

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date time = null;
		try {
			time = f.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();
		c.setTime(time);
		// System.out.println(f.format(c.getTime()));
		c.add(Calendar.MONTH, -month);
		// System.out.println(f.format(c.getTime()));
		return f.format(c.getTime());
	}
}
