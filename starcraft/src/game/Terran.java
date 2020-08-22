package game;

import common.building.BuildingMakeTime;

/**
 * Terran 클래스
 * @author 주현
 *
 */
public class Terran {
	
	private int mineral;	// 미네랄
	private int gas;		// 가스
	private int nowPopulationCount;	// 현재 인구수
	private int maxPopulationCount;	// 최대 인구수

	public Terran(int mineral, int gas, int nowPopulationCount, int maxPopulationCount) {
		this.mineral = mineral;
		this.gas = gas;
		this.nowPopulationCount = nowPopulationCount;
		this.maxPopulationCount = maxPopulationCount;
	}
	
	public int getMineral() {
		return mineral;
	}
	public void setMineral(int mineral) {
		this.mineral = mineral;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public int getNowPopulationCount() {
		return nowPopulationCount;
	}
	public void setNowPopulationCount(int nowPopulationCount) {
		this.nowPopulationCount = nowPopulationCount;
	}
	public int getMaxPopulationCount() {
		return maxPopulationCount;
	}
	public void setMaxPopulationCount(int maxPopulationCount) {
		this.maxPopulationCount = maxPopulationCount;
	}
	
	
	// addCount 만큼 Terran의 최대 인구수 증가
	public void addMaxPopulationCount(int addCount) {
		this.maxPopulationCount += addCount;
		System.out.println("최대 인구수: " + this.maxPopulationCount);
		System.out.println();
	}
	
	// addCount 만큼 Terrran의 현재 인구수 증가(유닛 뽑았을때 호출)
	public void addNowPopulationCount(int addCount) {
		this.nowPopulationCount += addCount;
	}
	
	/**
	 * 미네랄, 가스 추가 함수
	 * 미네랄: (SCV유닛 수 - 3) * 8 [3마리는 가스]
	 * 가스: (SCV 3마리) * 8
	 * @param scvUnitCount
	 */
	public void addResource(int scvUnitCount, int threadCount) {
		this.mineral += (scvUnitCount-3) * 8;
		this.gas += (3*8);
		if(threadCount % 5 == 0) {
			System.out.println("=============== SCV Thread ===============");
			System.out.println("현재 미네랄은: " + this.getMineral() + "원 이고, 현재 가스는: " + this.getGas() + "원 입니다.");
		}
	}
	
	/**
	 * 현재 인구수  + 뽑으려는 유닛의 인구수가 최대 인구수보다 작을때(같을때도 유닛을 뽑을 순  있음)
	 * ex) 현재 인구수: 16, 마린 인구수: 1, 최대 인구수: 20 ---> 16+1 < 20 (false)
	 * 따라서 위 경우는 뽑을 수 있음.
	 * @return
	 */
	public boolean isExceedPopulation(int unitCount) {
		return this.getNowPopulationCount() + unitCount > this.getMaxPopulationCount();
	}
	
	/**
	 * 현재 테란의 미네랄, 가스, 인구수 출력
	 */
	public void showNowTerranInfo() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("현재 미네랄 \t 현재 가스 \t 현재 인구수");
		System.out.println(this.getMineral() + "\t" + this.getGas() + "\t" 
					+ this.getNowPopulationCount() + "/" + this.getMaxPopulationCount());
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	
	public void addSupplydepotPopulationCount() throws InterruptedException {
		if(this.getMineral() < 100) {
			System.out.println("미네랄이 부족합니다... ");
			System.out.println("현재 미네랄: " + this.getMineral());
			System.out.println();
		}
		System.out.println("서플라이 디팟이 " + BuildingMakeTime.SUPPLYDEPOT_TIME + "초 뒤에 생성됩니다...");
		Thread.sleep(2000);
		
		System.out.println("최대 인구수가 8 증가 되었습니다.");
		this.addMaxPopulationCount(8);
	}

}
