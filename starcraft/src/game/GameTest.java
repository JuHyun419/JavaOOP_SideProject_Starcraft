package game;

import java.util.Scanner;

import common.building.BuildingMakeTime;
import common.unit.UnitCount;
import common.unit.unitMakeTime;
import common.unit.unitPrice;
import units.Marine;
import units.Scv;

class ScvGetMoneyThread extends Terran implements Runnable{

	public ScvGetMoneyThread(int mineral, int gas, int nowPopulationCount, int maxPopulationCount) {
		super(mineral, gas, nowPopulationCount, maxPopulationCount);
	}

	@Override
	public void run() {
		try {
			 while(true) {
				 System.out.println("SCV�� ���� �����ֽ��ϴ� .......");
				 Thread.sleep(10000);
				 break;
			 }
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

public class GameTest {
	public static final Scanner scan = new Scanner(System.in);
	private static final String makingPrefixStr = "�� �ڿ� �����˴ϴ�...";
	
	static Terran terran = new Terran(500, 500, 4, 10);
	static Scv scv = new Scv();
	
	/**
	 * �ʱ� ȭ��
	 * @throws InterruptedException
	 */
	public static void showInit() throws InterruptedException {
		System.out.println("��--------------------------------------------------------------------------------��");
		System.out.println("��                                                                                ��");
		System.out.println("��                   ��Ÿũ����Ʈ                                                                                                                    ��");               
		System.out.println("��                                     Created By Lee Ju-Hyun on 2020.00.00       ��");
		System.out.println("��--------------------------------------------------------------------------------��");

		System.out.println("��Ÿũ����Ʈ ������ �����մϴ�...");
		Thread.sleep(1000);
		System.out.println("����� ������ �׶��Դϴ�.....");
		Thread.sleep(1000);
		System.out.println("�ʱ� �̳׶��� 500, ������ 500�� �־����ϴ�.");
		Thread.sleep(1000);
		System.out.println("�ʱ� �α����� 10�Դϴ�.");
		System.out.println();
	}
	
	/**
	 * �ǹ� ���� �޴�
	 * @return
	 */
	public static int setBuildingMenu() {
		System.out.println("�ǹ��� �������ּ��� ......... ");
		System.out.println("1. �跰, 2. ���丮, 3. ��Ÿ��Ʈ, 4. ����");
		return scan.nextInt();
	}
	
	/**
	 * �跰���� ������ ���� ���� 
	 * @return
	 * @throws InterruptedException
	 */
	public static int produceBarrackUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("�跰�� �����ϼ̽��ϴ�... ");
		Thread.sleep(1000);
		System.out.println("�̰��� �ϴ� ������ �������ּ���!");
		Thread.sleep(1000);
		
		/*        Mineral, Gas
		 * ����   :     50  , 0
		 * �޵�   :     50  , 25 
		 * �ĺ�   :     50  , 25
		 * ��Ʈ :     25 , 75
		 */
		System.out.println("1. ����, 2. �޵�, 3. ���̾, 4. ��Ʈ");
		return scan.nextInt();
	}
	
	/**
	 * �̳׶� �߰� �Լ� - SCV ���ּ� * 8
	 * @throws InterruptedException
	 */
	public static void addMineral() throws InterruptedException {
		System.out.println("�̳׶��� �����մϴ�... �̳׶��� ĳ�� �ֽ��ϴ�.");
		Thread.sleep(2000);
		terran.setMineral(terran.getMineral() + (scv.getUnitNum() * 8));	
		System.out.println("���� �̳׶���: " + terran.getMineral() + "�� �Դϴ�.");
	}
	
	/**
	 * ���� �α��� + �������� ������ �α����� �ִ� �α������� Ŀ����(�������� ������ ���� ��  ����)
	 * ex) ���� �α���: 16, ���� �α���: 1, �ִ� �α���: 20 ---> 16+1 > 20 (false)
	 * ���� �� ���� ���� �� ����.
	 * @return
	 */
	public static boolean checkExceedPopulation(int unitCount) {
		return terran.getMaxPopulationCount() + unitCount > terran.getMaxPopulationCount();
	}
	
	public static void addMaxPopulationCount() throws InterruptedException {
		System.out.println("���ö��� ������ " + BuildingMakeTime.SUPPLYDEPOT_TIME + makingPrefixStr);
		Thread.sleep(2000);
		
		System.out.println("�ִ� �α����� 8 ���� �Ǿ����ϴ�.");
		terran.addMaxPopulationCount(8);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		showInit();
		scv.setUnitNum(4);
		
		while(true) {
			int menu = setBuildingMenu();
			
			if(menu == 1) {
				int unitChoice = produceBarrackUnitMenu();
				
				if(unitChoice == 1) {
					if(terran.getMineral() < 50) {
						addMineral();
					} else if(checkExceedPopulation(UnitCount.MARINE_COUNT)) {
						addMaxPopulationCount();
					} else {
						terran.setMineral(terran.getMineral() - unitPrice.MARINE_M);
						System.out.println("������ " + unitMakeTime.MARINE_TIME + makingPrefixStr);
						Thread.sleep(2000);

						Marine marine = new Marine();
						marine.getProfile();	// ���� ����(???)
						terran.setNowPopulationCount(
								terran.getNowPopulationCount() + UnitCount.MARINE_COUNT); // �׶� �α� ���� ����
						System.out.println("���� �α����� ");
					}
				}
				
			} else if(menu == 2) {
				 
			} else if(menu == 3) {
				
			} else if(menu == 4) {
				System.out.println("���α׷��� �����մϴ�...");
				break;
			} else {
				System.out.println("�߸� �����̽��ϴ�..... �ǹ��� �ٽ� �������ּ���!!");
			}
			
		}
	}

}
