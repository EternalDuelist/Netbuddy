/*
 * Possible errors:
 * I'm going to be reading in this thread and writing in another thread
 * check to see if this doesn't cause shenanigans;
 * 
 */

package NetBuddy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.ThreadLocalRandom;
import com.sun.nio.sctp.HandlerResult;

import com.sun.nio.sctp.SctpMultiChannel;

public class NetBuddyListener implements Runnable{
	
	private boolean active = false;
	private SctpMultiChannel smc;
	
	public NetBuddyListener(SctpMultiChannel smc){
		System.out.println("Listener reporting for duty!");
		this.smc = smc;
	}
	
	public void run() {
		ByteBuffer buf = ByteBuffer.allocateDirect(60);
		String line;
		this.active = true;
		while (this.active){
			try {
				smc.receive(buf, null, (notification, t) -> HandlerResult.CONTINUE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				line = new String(buf.array(), Charset.forName("UTC-8"));
				System.out.println("Message Received!: " + line);
		}
	}

	public synchronized void deactivate() {
		this.active = false;
	}
}
