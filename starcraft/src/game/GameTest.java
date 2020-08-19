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
				 System.out.println("SCV가 돈을 벌고있습니다 .......");
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
	private static final String makingPrefixStr = "초 뒤에 생성됩니다...";
	
	static Terran terran = new Terran(500, 500, 4, 10);
	static Scv scv = new Scv();
	
	/**
	 * 초기 화면
	 * @throws InterruptedException
	 */
	public static void showInit() throws InterruptedException {
		System.out.println("┌--------------------------------------------------------------------------------┐");
		System.out.println("│                                                                                │");
		System.out.println("│                   스타크래프트                                                                                                                    │");               
		System.out.println("│                                     Created By Lee Ju-Hyun on 2020.00.00       │");
		System.out.println("└--------------------------------------------------------------------------------┘");

		System.out.println("스타크래프트 게임을 시작합니다...");
		Thread.sleep(1000);
		System.out.println("당신의 종족은 테란입니다.....");
		Thread.sleep(1000);
		System.out.println("초기 미네랄은 500, 가스는 500이 주어집니다.");
		Thread.sleep(1000);
		System.out.println("초기 인구수는 10입니다.");
		System.out.println();
	}
	
	/**
	 * 건물 선택 메뉴
	 * @return
	 */
	public static int setBuildingMenu() {
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
	
	/**
	 * 미네랄 추가 함수 - SCV 유닛수 * 8
	 * @throws InterruptedException
	 */
	public static void addMineral() throws InterruptedException {
		System.out.println("미네랄이 부족합니다... 미네랄을 캐고 있습니다.");
		Thread.sleep(2000);
		terran.setMineral(terran.getMineral() + (scv.getUnitNum() * 8));	
		System.out.println("현재 미네랄은: " + terran.getMineral() + "원 입니다.");
	}
	
	/**
	 * 현재 인구수 + 뽑으려는 유닛의 인구수가 최대 인구수보다 커질때(같을때도 유닛을 뽑을 순  있음)
	 * ex) 현재 인구수: 16, 마린 인구수: 1, 최대 인구수: 20 ---> 16+1 > 20 (false)
	 * 따라서 위 경우는 뽑을 수 있음.
	 * @return
	 */
	public static boolean checkExceedPopulation(int unitCount) {
		return terran.getMaxPopulationCount() + unitCount > terran.getMaxPopulationCount();
	}
	
	public static void addMaxPopulationCount() throws InterruptedException {
		System.out.println("서플라이 디팟이 " + BuildingMakeTime.SUPPLYDEPOT_TIME + makingPrefixStr);
		Thread.sleep(2000);
		
		System.out.println("최대 인구수가 8 증가 되었습니다.");
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
						System.out.println("마린이 " + unitMakeTime.MARINE_TIME + makingPrefixStr);
						Thread.sleep(2000);

						Marine marine = new Marine();
						marine.getProfile();	// 전략 패턴(???)
						terran.setNowPopulationCount(
								terran.getNowPopulationCount() + UnitCount.MARINE_COUNT); // 테란 인구 유닛 증가
						System.out.println("현재 인구수는 ");
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
