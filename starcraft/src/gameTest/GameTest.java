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
				 System.out.println("SCV가 돈을 벌고있습니다 .......");
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
		System.out.println("┌--------------------------------------------------------------------------------┐");
		System.out.println("│                                                                                │");
		System.out.println("│                   스타크래프트                                                                                                 │");               
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

	public static void main(String[] args) throws InterruptedException {
		showInit();
		Terran terran = new Terran(500, 500, 4, 10);
		Scv scv = new Scv();
		scv.setUnitNum(4);
		
		while(true) {
			System.out.println("건물을 선택해주세요 ......... ");
			System.out.println("1. 배럭, 2. 팩토리, 3. 스타포트");
			int menu = scan.nextInt();
			
			if(menu == 1) {
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
				
				int unitChoice = scan.nextInt();
				if(unitChoice == 1) {	
					if(terran.getMineral() < 50) {
						System.out.println("현재 미네랄이 부족합니다........ 미네랄을 캐세요.");
					} else {
						System.out.println("마린이 " + unitMakeTime.MARINE_TIME + "초 뒤에 생성됩니다...");
						Thread.sleep(2000);

						Marine marine = new Marine();
						marine.getProfile();	// 전략 패턴(???)
					}
				}
				
			} else if(menu == 2) {
				 
			} else if(menu == 3) {
				
			} else {
				System.out.println("잘못 누르셨습니다..... 건물을 다시 선택해주세요!!");
				continue;
			}
			
		}
	}

}
