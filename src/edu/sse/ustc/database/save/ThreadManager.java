package edu.sse.ustc.database.save;


public class ThreadManager {

	public final static Integer MAX_THREADS = 4;

	public static void tagPositionManager() {
		
		for(int i = 0 ; i < MAX_THREADS ; i ++){
			new Thread(new TagPositionQueueThreads()).start();;
		}		

	}
}
