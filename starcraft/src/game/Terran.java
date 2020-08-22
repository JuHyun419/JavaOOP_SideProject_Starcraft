package game;

import common.building.BuildingMakeTime;

/**
 * Terran Ŭ����
 * @author ����
 *
 */
public class Terran {
	
	private int mineral;	// �̳׶�
	private int gas;		// ����
	private int nowPopulationCount;	// ���� �α���
	private int maxPopulationCount;	// �ִ� �α���

	public Terran(int mineral, int gas, int nowPopulationCount, int maxPopulationCount) {
		this.mineral = mineral;
		this.gas = gas;
		this.nowPopulationCount = nowPopulationCount;
		this.maxPopulationCount = maxPopulationCount;
	}
	
	public int getMineral() {
		return mineral;
	}
	public void setMineral(int mineral) {
		this.mineral = mineral;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public int getNowPopulationCount() {
		return nowPopulationCount;
	}
	public void setNowPopulationCount(int nowPopulationCount) {
		this.nowPopulationCount = nowPopulationCount;
	}
	public int getMaxPopulationCount() {
		return maxPopulationCount;
	}
	public void setMaxPopulationCount(int maxPopulationCount) {
		this.maxPopulationCount = maxPopulationCount;
	}
	
	
	// addCount ��ŭ Terran�� �ִ� �α��� ����
	public void addMaxPopulationCount(int addCount) {
		this.maxPopulationCount += addCount;
		System.out.println("�ִ� �α���: " + this.maxPopulationCount);
		System.out.println();
	}
	
	// addCount ��ŭ Terrran�� ���� �α��� ����(���� �̾����� ȣ��)
	public void addNowPopulationCount(int addCount) {
		this.nowPopulationCount += addCount;
	}
	
	/**
	 * �̳׶�, ���� �߰� �Լ�
	 * �̳׶�: (SCV���� �� - 3) * 8 [3������ ����]
	 * ����: (SCV 3����) * 8
	 * @param scvUnitCount
	 */
	public void addResource(int scvUnitCount, int threadCount) {
		this.mineral += (scvUnitCount-3) * 8;
		this.gas += (3*8);
		if(threadCount % 5 == 0) {
			System.out.println("=============== SCV Thread ===============");
			System.out.println("���� �̳׶���: " + this.getMineral() + "�� �̰�, ���� ������: " + this.getGas() + "�� �Դϴ�.");
		}
	}
	
	/**
	 * ���� �α���  + �������� ������ �α����� �ִ� �α������� ������(�������� ������ ���� ��  ����)
	 * ex) ���� �α���: 16, ���� �α���: 1, �ִ� �α���: 20 ---> 16+1 < 20 (false)
	 * ���� �� ���� ���� �� ����.
	 * @return
	 */
	public boolean isExceedPopulation(int unitCount) {
		return this.getNowPopulationCount() + unitCount > this.getMaxPopulationCount();
	}
	
	/**
	 * ���� �׶��� �̳׶�, ����, �α��� ���
	 */
	public void showNowTerranInfo() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("���� �̳׶� \t ���� ���� \t ���� �α���");
		System.out.println(this.getMineral() + "\t" + this.getGas() + "\t" 
					+ this.getNowPopulationCount() + "/" + this.getMaxPopulationCount());
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	
	public void addSupplydepotPopulationCount() throws InterruptedException {
		if(this.getMineral() < 100) {
			System.out.println("�̳׶��� �����մϴ�... ");
			System.out.println("���� �̳׶�: " + this.getMineral());
			System.out.println();
		}
		System.out.println("���ö��� ������ " + BuildingMakeTime.SUPPLYDEPOT_TIME + "�� �ڿ� �����˴ϴ�...");
		Thread.sleep(2000);
		
		System.out.println("�ִ� �α����� 8 ���� �Ǿ����ϴ�.");
		this.addMaxPopulationCount(8);
	}

}
