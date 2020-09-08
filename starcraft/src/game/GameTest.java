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
	private static final String makingSuffixStr = "초 뒤에 생성됩니다...";
	
	/* 미네랄, 가스, 현재 인구, 최대 인구수 */
	static Terran terran = new Terran(500, 200, 7, 10);
	static Scv scv = new Scv();
	static Marine marine = new Marine();
	
	/**
	 * 초기 화면
	 * @throws InterruptedException
	 */
	public static void showInit() throws InterruptedException {
		System.out.println("┌--------------------------------------------------------------------------------┐");
		System.out.println("│                                                                                │");
		System.out.println("│                   스타크래프트                                                                                                                    │");               
		System.out.println("│                                     Created By Lee Ju-Hyun on 2020.08.22       │");
		System.out.println("└--------------------------------------------------------------------------------┘");

		System.out.println("스타크래프트 게임을 시작합니다...");
		Thread.sleep(1000);
		System.out.println("당신의 종족은 테란입니다.....");
		Thread.sleep(1000);
		System.out.println("초기 미네랄은 500, 가스는 100이 주어집니다.");
		Thread.sleep(1000);
		System.out.println("초기 SCV는 7마리, 최대 인구수는 10입니다.");
		System.out.println();
	}
	
	/**
	 * 건물 선택 메뉴
	 * @return
	 */
	public static int setBuildingMenu() {
		System.out.println();
		System.out.println("건물을 선택해주세요 ......... ");
		System.out.println("1. 배럭, 2. 팩토리, 3. 스타포트, 4. 종료");
		return scan.nextInt();
	}
	
	/**
	 * 배럭에서 생산할 유닛 선택 
	 * @return
	 * @throws InterruptedException
	 */
	public static int produceBarrackUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("배럭을 선택하셨습니다... ");
		Thread.sleep(1000);
		System.out.println("뽑고자 하는 유닛을 선택해주세요!");
		Thread.sleep(1000);
		
		/*        Mineral, Gas
		 * 마린   :     50  , 0
		 * 메딕   :     50  , 25 
		 * 파벳   :     50  , 25
		 * 고스트 :     25 , 75
		 */
		System.out.println("1. 마린, 2. 메딕, 3. 파이어벳, 4. 고스트");
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
			
			/* 1. 배럭, 2. 팩토리, 3. 스타포트, 4. 종료 */
			if(menu == 1) {
				
				/* 1. 마린, 2. 메딕, 3. 파이어벳, 4. 고스트 */
				int barrackUnitChoice = produceBarrackUnitMenu();
				
				if(barrackUnitChoice == 1) {
					if(terran.getMineral() < 50) {
						System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
					
					} else if(terran.isExceedPopulation(UnitCount.MARINE_COUNT)) {
						terran.addSupplydepotPopulationCount();
					
					} else {
						terran.setMineral(terran.getMineral() - unitPrice.MARINE_M);
						System.out.println("마린이 " + unitMakeTime.MARINE_TIME + makingSuffixStr);
						Thread.sleep(2000);

						marine.printMarineInfo();	// 전략 패턴(???)
						terran.addNowPopulationCount(UnitCount.MARINE_COUNT);
					}
					
				} else if(barrackUnitChoice == 2) {
					if(terran.getMineral() < 50) {
						System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
						
					} else if(terran.getGas() < 25) {
						System.out.println("SCV가 열심히 가스를 벌고있으니 기다려주세요...");
						
					} else if(terran.isExceedPopulation(UnitCount.MEDIC_COUNT)) {
						terran.addSupplydepotPopulationCount();
					} else {
						terran.setMineral(terran.getMineral() - unitPrice.MEDIC_M);
						terran.setGas(terran.getGas() - unitPrice.MEDIC_G);
						System.out.println("메딕이 " + unitMakeTime.MEDIC_TIME + makingSuffixStr);
						Thread.sleep(2000);
						
						Medic medic = new Medic();
						//medic.getProfile();	// 전략 패턴(???)
						terran.addNowPopulationCount(UnitCount.MEDIC_COUNT);
					}
				}
				
			} else if(menu == 2) {
				
				 
			} else if(menu == 3) {
				
			} else if(menu == 4) {
				System.out.println("프로그램을 종료합니다...");
				break;
			} else {
				System.out.println("잘못 누르셨습니다..... 건물을 다시 선택해주세요!!");
			}
			
		}
	}

}
