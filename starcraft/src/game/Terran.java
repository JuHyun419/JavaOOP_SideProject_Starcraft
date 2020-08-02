package game;

/* �׶� */
public class Terran {
	private int mineral;	// �̳׶�
	
	private int gas;		// ����
	
	private int nowPopulationCount;	// ���� �α���
	
	private int maxPopulationCount;	// �ִ� �α���


	/* �׶� ��ü �ʱ�ȭ
	 * �̳׶� = 500, ���� = 500, ���� �α� = 4(SCV 4����), �ִ� �α� = 10(Ŀ�ǵ弾�� 1��)
	 */
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
	}

}
