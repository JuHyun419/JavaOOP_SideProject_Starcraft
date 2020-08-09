package units;

import common.unit.UnitCount;
import common.unit.unitHpMp;
import common.unit.unitMakeTime;
import common.unit.unitPrice;
import unit.GroundUnit;
import unit.Healable;
import unit.Unit;


/**
 * @author 주현
 * Marine 클래스
 */
public class Marine extends Unit implements GroundUnit, Healable{
	
	//public static int unitNum = 0;	// 마린의 유닛 수
	
	/* 디폴트 생성자 
	 * hp, hp, attack, defense 초기화 
	 */
	public Marine() {
		hp = unitHpMp.MARINE_HP;
		mp = unitHpMp.MARINE_MP;
		attack = 5;
		defense = 0;
	}	
	
	@Override
	public void walk() { // AirUnit 인터페이스 구현
		System.out.println("마린은 지상 유닛으로 땅을 걷습니다.");
	}
	@Override
	public void move(int x, int y) {	// unit 추상클래스 구현
		System.out.println("마린이 (" + x + "," + y + ")만큼 움직입니다.");
	}
	@Override
	public void stop() {	// unit 추상클래스 구현
		System.out.println("마린이 멈춥니다.");		
	}
	@Override
	public void attack() {	// unit 추상클래스 구현
		System.out.println("마린이 공격합니다.");
		System.out.println("공격력: " + attack + ", 방어력: " + defense);
	}
	@Override
	public int getMineral() {	// unit 추상클래스 구현
		return unitPrice.MARINE_M;
	}
	@Override
	public int getGas() {	// unit 추상클래스 구현
		return this.gas;
	}
	@Override
	public int getPopulationNum() {	// unit 추상클래스 구현
		return UnitCount.MARINE_COUNT;
	}
	@Override
	public int getUnitNum() {	// unit 추상클래스 구현 - 마린생성시 호출, 마린수 +1
		unitNum ++;
		System.out.println("현재 마린 수는: " + unitNum + "마리 입니다.");
		return this.unitNum;
	}
	@Override
	public int getMakeTime() {	// unit 추상클래스 구현
		return unitMakeTime.MARINE_TIME;
	}
	@Override
	public void getSound() {
		System.out.println("나는 마린 !!!!!!!!!!!!!");
	}
	
	// 전략 패턴(???)
	@Override
	public void getProfile() throws InterruptedException{
		System.out.println("=====================================");
		System.out.println("마린이 생성되었습니다...");
		getUnitNum();
		System.out.println("마린의 HP는: " + this.hp + "이고, 마린의 MP는: " + this.mp + "입니다.");
		System.out.println("마린의 공격력은: " + this.attack + "이고, 마린의 방어력은: " + this.defense + "입니다.");
		getSound();
		Thread.sleep(1000);
		walk();
		Thread.sleep(1000);
		move(1, 1);
		Thread.sleep(1000);
		attack();
		Thread.sleep(1000);
		stop();
		System.out.println("=====================================");
	}

}
