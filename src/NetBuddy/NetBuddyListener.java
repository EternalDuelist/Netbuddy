package NetBuddy;

import java.util.concurrent.ThreadLocalRandom;

public class NetBuddyListener implements Runnable{
	
	private boolean active = false;
	
	public NetBuddyListener(){
		System.out.println("Listener reporting for duty!");
	}
	
	public void run() {
		try {
			active = true;
			while (active){
					Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
					System.out.println("Omnomnom");
			}
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public synchronized void deactivate() {
		this.active = false;
	}
}
