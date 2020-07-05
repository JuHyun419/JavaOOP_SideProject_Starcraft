package gameTest;

import java.util.Scanner;

import commonUnit.unitMakeTime;
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
				 
			 }
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

public class GameTest {
	public static Scanner scan = new Scanner(System.in);
	
	public static void showInit() throws InterruptedException {
		System.out.println("��--------------------------------------------------------------------------------��");
		System.out.println("��                                                                                ��");
		System.out.println("��                   ��Ÿũ����Ʈ                                                                                                 ��");               
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
		Terran terran = new Terran(500, 500, 4, 10);
		Scv scv = new Scv();
		scv.setUnitNum(4);
		
		while(true) {
			System.out.println("�ǹ��� �������ּ��� ......... ");
			System.out.println("1. �跰, 2. ���丮, 3. ��Ÿ��Ʈ");
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
						System.out.println("���� �̳׶��� �����մϴ�........ �̳׶��� ĳ����.");
					} else {
						System.out.println("������ " + unitMakeTime.MARINE_TIME + "�� �ڿ� �����˴ϴ�...");
						Thread.sleep(2000);

						Marine marine = new Marine();
						marine.getProfile();	// ���� ����(???)
					}
				}
				
			} else if(menu == 2) {
				 
			} else if(menu == 3) {
				
			} else {
				System.out.println("�߸� �����̽��ϴ�..... �ǹ��� �ٽ� �������ּ���!!");
				continue;
			}
			
		}
	}

}
