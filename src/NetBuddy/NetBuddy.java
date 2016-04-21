package NetBuddy;

import java.util.concurrent.ThreadLocalRandom;
// import com.sun.nio.sctp.*;

public class NetBuddy implements Runnable{
	
	private boolean active = false;
	private NetBuddyListener netLis;
	private Thread netLisThread;
	
	public NetBuddy(){
		System.out.printf("NetBuddy O N L I N E\n");
		this.netLis = new NetBuddyListener();
		this.netLisThread = new Thread(netLis);
	}
	
	public void run() {
		netLisThread.start();
		this.active = true;
		try {
			while(active){
				Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
				System.out.println("Bubububu");
			}
			netLis.deactivate();
			netLisThread.join();
		} catch (InterruptedException e) {
			System.err.println("Interupted the bud");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	public synchronized void deactivate() {
		this.active = false;
	}
}
