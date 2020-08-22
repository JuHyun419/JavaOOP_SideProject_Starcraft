package unit;


/**
 * @author ����
 * ���� �߻� Ŭ����
 */
public abstract class Unit {
	
	protected int hp;		 // ü��
	protected int mp;		 // ����	
	protected int attack;	 // ���ݷ�
	protected int defense;	 // ����
	protected int mineral;	 // �̳׶�
	protected int gas;		 // ����
	protected int populationCount; // �α���, ���̹�(?)
	protected int unitNum;	 // ���� ����
	protected int price;	 // ����
	protected int makeTime;  // ���� �ð�
	protected String sound;	 // Unit ����
	
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPopulationCount() {
		return populationCount;
	}

	public void setPopulationCount(int populationCount) {
		this.populationCount = populationCount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setMineral(int mineral) {
		this.mineral = mineral;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	public void setUnitNum(int unitNum) {
		this.unitNum = unitNum;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public abstract void move(int x, int y);	// �̵�
	
 	public abstract void stop();	// ����

	public abstract void attack();	// ����
	
	public abstract int getMineral();	 // �̳׶� ����
	
	public abstract int getGas();		 // ���� ����
	
	public abstract int getPopulationNum(); // �α� ��
	
	public abstract int getUnitNum();	 // ���� ����
	
	public abstract int getMakeTime();	 // ���� ����ð�
	
	public abstract void getSound();	 // ���� ����
	
	public abstract void printMarineInfo() throws InterruptedException;	 // ���� ����
}
