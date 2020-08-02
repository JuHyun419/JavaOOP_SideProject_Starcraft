package game;

/* 테란 */
public class Terran {
	private int mineral;	// 미네랄
	
	private int gas;		// 가스
	
	private int nowPopulationCount;	// 현재 인구수
	
	private int maxPopulationCount;	// 최대 인구수


	/* 테란 객체 초기화
	 * 미네랄 = 500, 가스 = 500, 현재 인구 = 4(SCV 4마리), 최대 인구 = 10(커맨드센터 1개)
	 */
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
	}

}
