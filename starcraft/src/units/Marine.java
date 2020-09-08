package units;

import common.unit.UnitCount;
import common.unit.unitHpMp;
import common.unit.unitMakeTime;
import common.unit.unitPrice;
import unit.GroundUnit;
import unit.Healable;
import unit.Unit;


/**
 * Marine Ŭ����
 * @author ����
 */
public class Marine extends Unit implements GroundUnit, Healable {
	
	/* ����Ʈ ������ 
	 * hp, hp, attack, defense �ʱ�ȭ 
	 */
	public Marine() {
		hp = unitHpMp.MARINE_HP;
		mp = unitHpMp.MARINE_MP;
		attack = 5;
		defense = 0;
	}	
	
	@Override
	public void walk() { 
		System.out.println("������ ���� �������� ���� �Ƚ��ϴ�.");
	}
	@Override
	public void move(int x, int y) {	
		System.out.println("������ (" + x + "," + y + ")��ŭ �����Դϴ�.");
	}
	@Override
	public void stop() {	
		System.out.println("������ ����ϴ�.");		
	}
	@Override
	public void attack() {	
		System.out.println("������ �����մϴ�.");
		System.out.println("���ݷ�: " + attack + ", ����: " + defense);
	}
	@Override
	public int getMineral() {	
		return unitPrice.MARINE_M;
	}
	@Override
	public int getGas() {	
		return this.gas;
	}
	@Override
	public int getPopulationNum() {	
		return UnitCount.MARINE_COUNT;
	}
	@Override
	public int getUnitNum() {	// ���������� ȣ��, ������ +1
		this.unitNum ++;
		System.out.println("���� ���� ����: " + unitNum + "���� �Դϴ�.");
		return this.unitNum;
	}
	@Override
	public int getMakeTime() {	
		return unitMakeTime.MARINE_TIME;
	}
	@Override
	public void getSound() {
		System.out.println("���� ���� !!!!!!!!!!!!!");
	}
	
	// ���� ����(???)
	@Override
	public void printMarineInfo() throws InterruptedException{
		System.out.println("=====================================");
		System.out.println("������ �����Ǿ����ϴ�...");
		getUnitNum();
		System.out.println("������ HP��: " + this.hp + "�̰�, ������ MP��: " + this.mp + "�Դϴ�.");
		System.out.println("������ ���ݷ���: " + this.attack + "�̰�, ������ ������: " + this.defense + "�Դϴ�.");
		getSound();
		Thread.sleep(1000);
		walk();
		Thread.sleep(1000);
		move(1, 1);
		Thread.sleep(1000);
		attack();
		Thread.sleep(1000);
		stop();
		System.out.println("=====================================\n");
	}

}
