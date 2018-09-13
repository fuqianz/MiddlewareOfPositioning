package edu.sse.ustc.database.stats;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.database.returnitem.Totalcustomers;
import edu.sse.ustc.database.returnitem.VisitedRecords;
import edu.sse.ustc.database.returnitem.VisitedTimes;
import edu.sse.ustc.database.session.HibernateSessionFactory;

public class VisitedStats {
public VisitedTimes getVisitedTimesinEnvironment(int environmentId,String datetime_start,String datetime_end){
		
		List<Totalcustomers> totalcustomers_list =new ArrayList<Totalcustomers>();
	
		List<String> tags = TagPosHelper.getMacListByTimendEnvironment(environmentId, datetime_start, datetime_end);
		for(String ts:tags){
			List<VisitedRecords> visited_records = new ArrayList<VisitedRecords>();
			visited_records = this.getVisitedRecordinEnvironment(ts,environmentId, datetime_start, datetime_end);
			Totalcustomers totalcustomers = new Totalcustomers();
			
			totalcustomers.setSta_mac(ts);
			totalcustomers.setVisited_records(visited_records);
			totalcustomers.setVisited_time(visited_records.size());
			
			totalcustomers_list.add(totalcustomers);
		}
		VisitedTimes rs = new VisitedTimes();
		rs.setTotalcustomers_list(totalcustomers_list);
		rs.setTotalcustomers_count(totalcustomers_list.size());
		return rs;
	}
	
	private List<VisitedRecords> getVisitedRecordinEnvironment(String mac,int environmentId,String datetime_start,String datetime_end){
		List<VisitedRecords> records = new ArrayList<VisitedRecords>();
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        try
        {
            String sql = "SELECT date_format(time,'%Y-%m-%d') days, min(time)firstenter_time,max(time)lastleave_time from Tagpos where mac='"+mac+"'and environmentId='"+environmentId+"'"
            		+ "and time between '"+datetime_start+"' and '"+datetime_end+"'group by days";
       
            Query query = session.createSQLQuery(sql).addScalar("visited_date", Hibernate.STRING).addScalar("firstenter_time", Hibernate.STRING).
            		addScalar("lastleave_time", Hibernate.STRING);
            query.setResultTransformer(Transformers.aliasToBean(edu.sse.ustc.database.returnitem.VisitedRecords.class)); 

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
		return records;
	}
	
	public VisitedTimes getVisitedTimesinMap(int environmentId,int mapId,String datetime_start,String datetime_end){
		
		List<Totalcustomers> totalcustomers_list =new ArrayList<Totalcustomers>();
	
		List<String> tags = TagPosHelper.getMacListByTimeAndMap(environmentId, mapId, datetime_start, datetime_end);
		for(String ts:tags){
			List<VisitedRecords> visited_records = new ArrayList<VisitedRecords>();
			visited_records = this.getVisitedRecordInMap(ts, environmentId, mapId, datetime_start, datetime_end);
			Totalcustomers totalcustomers = new Totalcustomers();
			
			totalcustomers.setSta_mac(ts);
			totalcustomers.setVisited_records(visited_records);
			totalcustomers.setVisited_time(visited_records.size());
			
			totalcustomers_list.add(totalcustomers);
		}
		VisitedTimes rs = new VisitedTimes();
		rs.setTotalcustomers_list(totalcustomers_list);
		rs.setTotalcustomers_count(totalcustomers_list.size());
		return rs;
	}
	
	private List<VisitedRecords> getVisitedRecordInMap(String mac,int environmentId,int mapId,String datetime_start,String datetime_end){
		List<VisitedRecords> records = new ArrayList<VisitedRecords>();
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        try
        {
            String sql = "SELECT date_format(time,'%Y-%m-%d') visited_date, min(time)firstenter_time,max(time)lastleave_time from Tagpos where mac='"+mac+"'and environmentId='"+environmentId+"'and"
            		+ " mapId= '"+mapId+"'and time between '"+datetime_start+"' and '"+datetime_end+"'group by visited_date";
       
            Query query = session.createSQLQuery(sql).addScalar("visited_date", Hibernate.STRING).addScalar("firstenter_time", Hibernate.STRING).
            		addScalar("lastleave_time", Hibernate.STRING);
            query.setResultTransformer(Transformers.aliasToBean(edu.sse.ustc.database.returnitem.VisitedRecords.class)); 

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
		return records;
	}
	

	
}
