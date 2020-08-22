package unit;


/**
 * @author 주현
 * 유닛 추상 클래스
 */
public abstract class Unit {
	
	protected int hp;		 // 체력
	protected int mp;		 // 마나	
	protected int attack;	 // 공격력
	protected int defense;	 // 방어력
	protected int mineral;	 // 미네랄
	protected int gas;		 // 가스
	protected int populationCount; // 인구수, 네이밍(?)
	protected int unitNum;	 // 유닛 갯수
	protected int price;	 // 가격
	protected int makeTime;  // 생산 시간
	protected String sound;	 // Unit 사운드
	
	
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

	public abstract void move(int x, int y);	// 이동
	
 	public abstract void stop();	// 정지

	public abstract void attack();	// 공격
	
	public abstract int getMineral();	 // 미네랄 가격
	
	public abstract int getGas();		 // 가스 가격
	
	public abstract int getPopulationNum(); // 인구 수
	
	public abstract int getUnitNum();	 // 유닛 개수
	
	public abstract int getMakeTime();	 // 유닛 생산시간
	
	public abstract void getSound();	 // 유닛 음악
	
	public abstract void printMarineInfo() throws InterruptedException;	 // 유닛 정보
}
