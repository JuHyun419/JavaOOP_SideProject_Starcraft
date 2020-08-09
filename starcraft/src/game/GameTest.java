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

	public static void main(String[] args) throws InterruptedException {
		showInit();
		
		
		/*
		 * Param: �̳׶�, ����, ���� �α���, �ִ� �α���
		 */
		Terran terran = new Terran(500, 500, 4, 10);
		Scv scv = new Scv();
		scv.setUnitNum(4);
		
		while(true) {
			System.out.println("�ǹ��� �������ּ��� ......... ");
			System.out.println("1. �跰, 2. ���丮, 3. ��Ÿ��Ʈ, 4. ����");
			int menu = scan.nextInt();
			
			if(menu == 1) {
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
				
				int unitChoice = scan.nextInt();
				if(unitChoice == 1) {	
					if(terran.getMineral() < 50) {
						System.out.println("�̳׶��� �����մϴ�... �̳׶��� ĳ�� �ֽ��ϴ�.");
						Thread.sleep(2000);
						terran.setMineral(terran.getMineral() + (scv.getUnitNum() * 8));	// SCV �� * 8��ŭ �̳׶� ȹ��
						System.out.println("���� �̳׶���: " + terran.getMineral() + "�� �Դϴ�.");
						
					/*
					 * ���� �α��� + �������� ������ �α����� �ִ� �α������� Ŀ����(���� ��쵵 ���� ���� �� ����)
					 */
					} else if(terran.getNowPopulationCount() + UnitCount.MARINE_COUNT > terran.getMaxPopulationCount()) {
						System.out.println("additional Supply Depots is required...");
						
						// Ŀ�ǵ弾�� or ���ö��̵��� ����
						System.out.println("Ŀ�ǵ弾�� or ���ö��̵����� �������ּ���.(Ŀ�ǵ弾��: 1, ���ö��̵���: 2");
						int selectDepots = scan.nextInt();
						
						if(selectDepots == 1) {
							System.out.println("Ŀ�ǵ弾�Ͱ� " + BuildingMakeTime.COMMANDCENTER_TIME + makingPrefixStr);
							Thread.sleep(3000);
							
							System.out.println("�ִ� �α����� 10 ���� �Ǿ����ϴ�.");
							terran.addMaxPopulationCount(10);
						} else if(selectDepots == 2) {
							System.out.println("���ö��� ������ " + BuildingMakeTime.SUPPLYDEPOT_TIME + makingPrefixStr);
							Thread.sleep(2000);
							
							System.out.println("�ִ� �α����� 8 ���� �Ǿ����ϴ�.");
							terran.addMaxPopulationCount(8);
						}
					}
					
					else {
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
