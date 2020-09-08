package game;

import java.util.Scanner;

import common.thread.ScvGetResourceThread;
import common.unit.UnitCount;
import common.unit.unitMakeTime;
import common.unit.unitPrice;
import units.Marine;
import units.Medic;
import units.Scv;


public class GameTest {
	public static final Scanner scan = new Scanner(System.in);
	private static final String makingSuffixStr = "�� �ڿ� �����˴ϴ�...";
	
	/* �̳׶�, ����, ���� �α�, �ִ� �α��� */
	static Terran terran = new Terran(500, 200, 7, 10);
	static Scv scv = new Scv();
	static Marine marine = new Marine();
	
	/**
	 * �ʱ� ȭ��
	 * @throws InterruptedException
	 */
	public static void showInit() throws InterruptedException {
		System.out.println("��--------------------------------------------------------------------------------��");
		System.out.println("��                                                                                ��");
		System.out.println("��                   ��Ÿũ����Ʈ                                                                                                                    ��");               
		System.out.println("��                                     Created By Lee Ju-Hyun on 2020.08.22       ��");
		System.out.println("��--------------------------------------------------------------------------------��");

		System.out.println("��Ÿũ����Ʈ ������ �����մϴ�...");
		Thread.sleep(1000);
		System.out.println("����� ������ �׶��Դϴ�.....");
		Thread.sleep(1000);
		System.out.println("�ʱ� �̳׶��� 500, ������ 100�� �־����ϴ�.");
		Thread.sleep(1000);
		System.out.println("�ʱ� SCV�� 7����, �ִ� �α����� 10�Դϴ�.");
		System.out.println();
	}
	
	/**
	 * �ǹ� ���� �޴�
	 * @return
	 */
	public static int setBuildingMenu() {
		System.out.println();
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
	
	
	public static void main(String[] args) throws InterruptedException {
		
		showInit();
		scv.setUnitNum(7);
		
		ScvGetResourceThread scvGetResource = new ScvGetResourceThread(terran, scv.getUnitNum());
		Thread scvThread = new Thread(scvGetResource);
		scvThread.start();
		
		while(true) {
			terran.showNowTerranInfo();
			int menu = setBuildingMenu();
			
			/* 1. �跰, 2. ���丮, 3. ��Ÿ��Ʈ, 4. ���� */
			if(menu == 1) {
				
				/* 1. ����, 2. �޵�, 3. ���̾, 4. ��Ʈ */
				int barrackUnitChoice = produceBarrackUnitMenu();
				
				if(barrackUnitChoice == 1) {
					if(terran.getMineral() < 50) {
						System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
					
					} else if(terran.isExceedPopulation(UnitCount.MARINE_COUNT)) {
						terran.addSupplydepotPopulationCount();
					
					} else {
						terran.setMineral(terran.getMineral() - unitPrice.MARINE_M);
						System.out.println("������ " + unitMakeTime.MARINE_TIME + makingSuffixStr);
						Thread.sleep(2000);

						marine.printMarineInfo();	// ���� ����(???)
						terran.addNowPopulationCount(UnitCount.MARINE_COUNT);
					}
					
				} else if(barrackUnitChoice == 2) {
					if(terran.getMineral() < 50) {
						System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
						
					} else if(terran.getGas() < 25) {
						System.out.println("SCV�� ������ ������ ���������� ��ٷ��ּ���...");
						
					} else if(terran.isExceedPopulation(UnitCount.MEDIC_COUNT)) {
						terran.addSupplydepotPopulationCount();
					} else {
						terran.setMineral(terran.getMineral() - unitPrice.MEDIC_M);
						terran.setGas(terran.getGas() - unitPrice.MEDIC_G);
						System.out.println("�޵��� " + unitMakeTime.MEDIC_TIME + makingSuffixStr);
						Thread.sleep(2000);
						
						Medic medic = new Medic();
						//medic.getProfile();	// ���� ����(???)
						terran.addNowPopulationCount(UnitCount.MEDIC_COUNT);
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
