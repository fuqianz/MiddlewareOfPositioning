package edu.sse.ustc.database.save;

public class TagPositionQueueThreads implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		TagPositionQueue.save();
	}

}
