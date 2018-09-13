package edu.sse.ustc.database.stats;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import edu.sse.ustc.database.returnitem.DayMac;
import edu.sse.ustc.database.session.HibernateSessionFactory;


public class DayMacCount {
	public List<DayMac> getEverydayMacCountInMap(int environmentId,int mapId,int type,double r1,double r2,double r3,double r4,String datetime_start,String datetime_end){
		HashMap<String,Integer> dc= new HashMap<String,Integer>();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar buffer = Calendar.getInstance();
		Date start = null;
		Date end = null ;
		try {
			 start = fmt.parse(datetime_start) ;
			 end = fmt.parse(datetime_end) ;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(type==0){
			dc=this.getEverydayMacCountRecordsInMap(environmentId, mapId,datetime_start, datetime_end);
		}
		else if(type==1){
			dc=this.getEverydayMacCountRecordsInMap2(environmentId, mapId, r1, r2, r3, r4, datetime_start, datetime_end);
		}
		else if(type==2){
			dc=this.getEverydayMacCountRecordsInMap3(environmentId, mapId, r1, r2, r3, r4,datetime_start, datetime_end);
		}
		
		List<DayMac> res = new ArrayList<DayMac>();
		buffer.setTime(start);
		for(;buffer.getTime().before(end);buffer.add(Calendar.DATE, 1)){
			DayMac dm =new DayMac();
			dm.setDay(fmt2.format(buffer.getTime())); 
			if(dc.containsKey(dm.getDay()))dm.setMaccount(dc.get(dm.getDay()));
			else dm.setMaccount(0);
			res.add(dm);
		}

		return res;
	}


	//SQL方法部分
	private HashMap<String,Integer> getEverydayMacCountRecordsInMap(int environmentId,int mapId,String datetime_start,String datetime_end){
		List<DayMac> records = new ArrayList<DayMac>();
	    SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    
	    try
	    {
	        String sql = "SELECT count(distinct mac) maccount,date_format(time,'%Y-%m-%d') day from Tagpos where environmentId='"+environmentId+"'and"
	        		+ " mapId= '"+mapId+"'and time between '"+datetime_start+"' and '"+datetime_end+"'group by day order by day asc";	   
	        Query query = session.createSQLQuery(sql).addScalar("maccount", Hibernate.INTEGER).addScalar("day", Hibernate.STRING);
	        		
	        query.setResultTransformer(Transformers.aliasToBean(edu.sse.ustc.database.returnitem.DayMac.class)); 

	        records = query.list();
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
	    HashMap<String,Integer> res = new HashMap<String,Integer>();
	    for(DayMac item : records){
	    	res.put(item.getDay(), item.getMaccount());
	    }
	    
		return res;
	}
	
	private HashMap<String,Integer> getEverydayMacCountRecordsInMap2(int environmentId,int mapId,double r1,double r2,double r3,double r4,String datetime_start,String datetime_end){
		List<DayMac> records = new ArrayList<DayMac>();
	    SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    
	    try
	    {
	        String sql = "SELECT count(distinct mac) maccount,date_format(time,'%Y-%m-%d') day from Tagpos where environmentId='"+environmentId+"'and"
	        		+ " mapId= '"+mapId+"'and x_pos between '"+r3+"' and '"+r1+"'and y_pos between '"+r4+"'and '"+r2+"' and time between '"+datetime_start+"' and '"+datetime_end+"'group by day order by day asc";
	   
	        Query query = session.createSQLQuery(sql).addScalar("maccount", Hibernate.INTEGER).addScalar("day", Hibernate.STRING);
	        		
	        query.setResultTransformer(Transformers.aliasToBean(edu.sse.ustc.database.returnitem.DayMac.class)); 

	        records = query.list();
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
	    HashMap<String,Integer> res = new HashMap<String,Integer>();
	    for(DayMac item : records){
	    	res.put(item.getDay(), item.getMaccount());
	    }
	    
		return res;
	}
	
	private HashMap<String,Integer> getEverydayMacCountRecordsInMap3(int environmentId,int mapId,double r1,double r2,double r3,double r4,String datetime_start,String datetime_end){
		List<DayMac> records = new ArrayList<DayMac>();
	    SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    
	    try
	    {
	        String sql = "SELECT count(distinct mac) maccount,date_format(time,'%Y-%m-%d') day from Tagpos where environmentId='"+environmentId+"'and"
	        		+ " mapId= '"+mapId+"'and x_pos between '"+r3+"' and '"+r1+"'and y_pos between '"+r4+"'and '"+r2+"'and time between '"+datetime_start+"' and '"+datetime_end+"'group by day order by day asc";
	   
	        Query query = session.createSQLQuery(sql).addScalar("maccount", Hibernate.INTEGER).addScalar("day", Hibernate.STRING);
	        		
	        query.setResultTransformer(Transformers.aliasToBean(edu.sse.ustc.database.returnitem.DayMac.class)); 

	        records = query.list();
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
	    HashMap<String,Integer> res = new HashMap<String,Integer>();
	    for(DayMac item : records){
	    	res.put(item.getDay(), item.getMaccount());
	    }
	    
		return res;
	}

}
