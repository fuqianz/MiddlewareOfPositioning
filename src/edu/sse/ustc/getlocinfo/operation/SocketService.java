package edu.sse.ustc.getlocinfo.operation;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.save.SaveToDataBase;
import edu.sse.ustc.database.save.TagPositionQueue;
import edu.sse.ustc.database.save.impl.SaveToDataBaseImpl;
import edu.sse.ustc.getlocinfo.common.ArrayConcat;
import edu.sse.ustc.getlocinfo.common.FormatTransfer;
import edu.sse.ustc.getlocinfo.socenum.MsgType;

public class SocketService {

	private final short MAX_SHORT = (short) (32767);

	private final short NaKLen = 6;
	private final short AcKLen = 2;
	private final short REQLEN = 6;
	private final int MsgTypeLen = 2;
	private final int MsgLen = 2;

	private final int SeqNoLen = 2;
	private final int ErrorCodeLen = 4;
	private final int MAX_LEN = 1000;

	private DatagramSocket ds = null;

	public void bindServer() throws SocketException, UnknownHostException {

		ds = new DatagramSocket();
	}

	public void close() {

		ds.close();
	}

	public boolean requestForBind(ConnectOperation clientConnect, int port, String ip) {

		MsgType mt = MsgType.REGISTERREQ;// msgType
		byte[] first = FormatTransfer.toHH(mt.getValue());

		byte[] second = FormatTransfer.toHH(REQLEN);

		byte[] three = FormatTransfer.toHH(clientConnect.getRegID());

		short sequenceNumber = (short) (clientConnect.getRegID() % MAX_SHORT);// sequenceNumber

		byte[] four = FormatTransfer.toHH(sequenceNumber);

		byte[] req = ArrayConcat.concat(first, second, three, four);

		// System.out.println(req);
		/**
		 * send request packet to server
		 */
		DatagramPacket dp = null;
		dp = new DatagramPacket(req, req.length, new InetSocketAddress(ip, port));

		try {
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			// e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// System.out.println("error in request for bind 2");
			// e.printStackTrace();
			MyLog.error(e.toString(), this.getClass().getName());
		}
		/**
		 * receive reply packet(AcK or NaK) from server
		 * 
		 */

		boolean flag = true;// true:ACK, false :NaK

		byte[] rbuff = new byte[10];
		try {
			ds.receive(new DatagramPacket(rbuff, rbuff.length));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// System.out.println("error in request for bind 3");
			// e.printStackTrace();
			MyLog.error(e.toString(), this.getClass().getName());
		}

		// System.out.println(rbuff);
		MsgType msgType = MsgType.REGISTERACK;// Msgtype
		short ml = (short) 0;// msgLen
		short seqNumber = sequenceNumber;// sequence No.
		Integer errorCode = null;// error code
		int offset = 0;
		msgType.setValue(FormatTransfer.hBytesToShort(rbuff, offset, MsgTypeLen));

		offset += MsgTypeLen;

		if (msgType == MsgType.REGISTERACK) {
			// msgtype correct
			ml = FormatTransfer.hBytesToShort(rbuff, offset, MsgLen);// msgLen

			if (ml == AcKLen) {
				// msgLen correct
				offset += MsgLen;
				// System.out.println(seqNumber + " " +
				// FormatTransfer.hBytesToShort(rbuff, offset, SeqNoLen));
				if (seqNumber != FormatTransfer.hBytesToShort(rbuff, offset, SeqNoLen)) {
					// seqNumber wrong
					flag = false;
					// System.out.println("1");
				}
				// System.out.println("2");
			} else {
				flag = false;
				// msg's length is wrong
				// System.out.println("3");
			}
		} else if (msgType == MsgType.REGISTERNAK) {
			flag = false;
			// System.out.println("4");
			// msg's Type is wrong
			ml = FormatTransfer.hBytesToShort(rbuff, offset, MsgLen);// msgLen
			offset += MsgLen;
			if (FormatTransfer.reverseShort(ml) == NaKLen
					&& FormatTransfer.reverseShort(seqNumber) == FormatTransfer.hBytesToShort(rbuff, offset, SeqNoLen)) {
				offset += SeqNoLen;
				// System.out.println("5");
				// get error code for other use
				errorCode = FormatTransfer.hBytesToInt(rbuff, offset, ErrorCodeLen);
			}
		} else {
			// packet wrong
			// System.out.println("6");
			flag = false;
		}

		if (flag) {
			MyLog.info("Socket Request for bind SUCCESS!", this.getClass().getName());
		}
		return flag;
	}

	public void getAndSavePathInfo(ConnectOperation clientConnect) {

		// ExecutorService threadPool = Executors.newFixedThreadPool(30);
		while (clientConnect.ping()) {

			// System.out.println(clientConnect.ping());

			byte[] recv = new byte[MAX_LEN];

			try {

				ds.receive(new DatagramPacket(recv, recv.length));

				TagPositionQueue.tagPathQ.add(recv);
				System.out.println(recv.toString());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				MyLog.error(e.toString(), this.getClass().getName());
			}

		}
	}
}
