package commonBuilding;


/**
 * @author 주현
 * 빌딩 추상 클래스
 */
public abstract class Building {
	protected int hp;		// 체력
	protected int mineral;	// 미네랄
	protected int gas;		// 가스
	protected int price;	// 가격
	protected int makeTime;	// 생산 시간
	
	
	public abstract void getMineral();	// 미네랄 가격
	
	public abstract void getGas();	// 가스 가격
	
	public abstract void getMakeTime();	// 건물 생산시간
}
