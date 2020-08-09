package units;

import common.unit.UnitCount;
import common.unit.unitHpMp;
import common.unit.unitMakeTime;
import common.unit.unitPrice;
import unit.GroundUnit;
import unit.Healable;
import unit.Unit;


/**
 * @author ����
 * Marine Ŭ����
 */
public class Marine extends Unit implements GroundUnit, Healable{
	
	//public static int unitNum = 0;	// ������ ���� ��
	
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
	public void walk() { // AirUnit �������̽� ����
		System.out.println("������ ���� �������� ���� �Ƚ��ϴ�.");
	}
	@Override
	public void move(int x, int y) {	// unit �߻�Ŭ���� ����
		System.out.println("������ (" + x + "," + y + ")��ŭ �����Դϴ�.");
	}
	@Override
	public void stop() {	// unit �߻�Ŭ���� ����
		System.out.println("������ ����ϴ�.");		
	}
	@Override
	public void attack() {	// unit �߻�Ŭ���� ����
		System.out.println("������ �����մϴ�.");
		System.out.println("���ݷ�: " + attack + ", ����: " + defense);
	}
	@Override
	public int getMineral() {	// unit �߻�Ŭ���� ����
		return unitPrice.MARINE_M;
	}
	@Override
	public int getGas() {	// unit �߻�Ŭ���� ����
		return this.gas;
	}
	@Override
	public int getPopulationNum() {	// unit �߻�Ŭ���� ����
		return UnitCount.MARINE_COUNT;
	}
	@Override
	public int getUnitNum() {	// unit �߻�Ŭ���� ���� - ���������� ȣ��, ������ +1
		unitNum ++;
		System.out.println("���� ���� ����: " + unitNum + "���� �Դϴ�.");
		return this.unitNum;
	}
	@Override
	public int getMakeTime() {	// unit �߻�Ŭ���� ����
		return unitMakeTime.MARINE_TIME;
	}
	@Override
	public void getSound() {
		System.out.println("���� ���� !!!!!!!!!!!!!");
	}
	
	// ���� ����(???)
	@Override
	public void getProfile() throws InterruptedException{
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
		System.out.println("=====================================");
	}

}
