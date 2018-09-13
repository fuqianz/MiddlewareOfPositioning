package edu.sse.ustc.getlocinfo.operation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.contract.EnvironmentContract;
import edu.sse.ustc.contract.InvalidOperation;
import edu.sse.ustc.getlocinfo.operation.BasicInfo;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.services.ClassTranslator;
import edu.sse.ustc.getlocinfo.services.impl.ClassTranslatorImpl;
import edu.sse.ustc.innerclass.Environment;

public class BasicInfoImpl implements BasicInfo {
	public ClassTranslator classTranslator = new ClassTranslatorImpl();

	public BasicInfoImpl() {

	}

	@Override
	public Date getServerTime(ConnectOperation clientConnect) {

		Date date = null;

		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(clientConnect.getClient().GetServerTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		if (date != null) {
			MyLog.error("Get Server Time FAILED", this.getClass().getName());
		} else {
			MyLog.info("Get Server Time SUCCESS", this.getClass().getName());
		}

		return date;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Environment> getAllEnvironments(ConnectOperation clientConnect) {
		// TODO Auto-generated method stub
		List<EnvironmentContract> strList = null;
		List<Environment> eli = new ArrayList<Environment>();

		try {

			strList = clientConnect.getClient().GetEnvironmentsEx();
			if (strList != null) {
				eli = classTranslator.getEnvironmentList(strList);
			}
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		if (eli != null) {
			MyLog.error("Get Environment infomation FAILED", this.getClass().getName());
		} else {
			MyLog.info("Get Environment infomation SUCCESS", this.getClass().getName());
		}

		return eli;
	}

}
