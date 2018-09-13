package edu.sse.ustc.database.save;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.save.impl.SaveToDataBaseImpl;
import edu.sse.ustc.getlocinfo.common.FormatTransfer;
import edu.sse.ustc.getlocinfo.operation.PacketTranslator;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;

public class TagPositionQueue {
	
	public static BlockingQueue<byte[]> tagPathQ = new LinkedBlockingQueue<byte[]>();
	private static final int Max_Len = 1000;

	private static synchronized byte[] getTop() {

		if (tagPathQ.isEmpty())
			return null;

		return tagPathQ.remove();
	}

	private static List<byte[]> getQueue() {

		List<byte[]> lb = new ArrayList<byte[]>();

		int cnt = 0;
		for (int i = 0; i < Max_Len; i++) {
			byte[] top = getTop();

			if (top == null) {
				cnt++;
			} else {
				lb.add(top);
				cnt = 0;
			}

			if (cnt >= 10)
				break;
		}

		return lb;
	}

	public static void save() {

		SaveToDataBase stdb = new SaveToDataBaseImpl();

		while (true) {

			List<byte[]> lb = getQueue();

			List<TagPath> tpath = new ArrayList<TagPath>();
			List<TagPos> tpos = new ArrayList<TagPos>();
			for (int i = 0; i < lb.size(); i++) {

				short mtype = FormatTransfer.hBytesToShort(lb.get(i), 0, 2);

				if (mtype == 4) {

					tpos.add(PacketTranslator.targetPositionInfo(lb.get(i)));

				} else if (mtype == 5) {
					tpath.add(PacketTranslator.targetPathInfo(lb.get(i)));

				} else {

					MyLog.error("packet error", "TagPositionQueue");
				}

			}

			if (tpos.size() > 0)
				if (!stdb.saveTagCurLoc(tpos)) {
					MyLog.error("Failed save: TagPosList", "TagPositionQueue");
				}
			if (tpath.size() > 0)
				if (!stdb.saveMoveTagPath(tpath)) {
					MyLog.error("Failed save: TagPathList", "TagPositionQueue");
				}
		}
	}
}
