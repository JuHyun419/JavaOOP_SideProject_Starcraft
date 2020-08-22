package common.thread;

import game.Terran;

public class ScvGetResourceThread implements Runnable{
	
	int scvUnitCount;
	Terran terran;
	int threadCount = 0;	// SCV�� 5�� �ڿ��� �������� �ڿ� ���
	
	public ScvGetResourceThread(Terran terran, int scvUnitCount) {
		this.terran = terran;
		this.scvUnitCount = scvUnitCount;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(scvUnitCount == 0) {
					System.out.println("SCV�� �����ϴ�... Thread�� �����մϴ�");
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
