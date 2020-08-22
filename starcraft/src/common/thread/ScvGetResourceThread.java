package common.thread;

import game.Terran;

public class ScvGetResourceThread implements Runnable{
	
	int scvUnitCount;
	Terran terran;
	int threadCount = 0;	// SCV가 5번 자원을 벌때마다 자원 출력
	
	public ScvGetResourceThread(Terran terran, int scvUnitCount) {
		this.terran = terran;
		this.scvUnitCount = scvUnitCount;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(scvUnitCount == 0) {
					System.out.println("SCV가 없습니다... Thread를 종료합니다");
					break;
				}
				
				Thread.sleep(5000);
				terran.addResource(scvUnitCount, threadCount);
				threadCount ++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
