package NetBuddy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.nio.sctp.*;

public class NetBuddy implements Runnable {
	
	private boolean active = false;
	private NetBuddyListener netLis;
	private Thread netLisThread;
	private SctpMultiChannel smc;
	private InetSocketAddress address;
	
	public NetBuddy(){
		try {
			System.out.printf("NetBuddy O N L I N E\n");
			
			address = new InetSocketAddress("localhost", 0);
			smc = SctpMultiChannel.open();
			smc.bind(address, 10);
			netLis = new NetBuddyListener(smc);
			netLisThread = new Thread(netLis);
			
		} catch (IllegalArgumentException e){
			System.err.println("Multi Channel Problems... amirite?");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO stuff?");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	//use a condition variable to put this thread to sleep until someone
	// calls broadcast and gives this guy a message to send
	public void run() {
		try {
			netLisThread.start();
			active = true;
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
	
	public void broadcast(String message){
		
	}
	
	public void printAddressInfo(){
		
	}

	public synchronized void deactivate() {
		active = false;
	}
}
