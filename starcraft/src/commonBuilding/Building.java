package commonBuilding;


/**
 * @author ����
 * ���� �߻� Ŭ����
 */
public abstract class Building {
	protected int hp;		// ü��
	protected int mineral;	// �̳׶�
	protected int gas;		// ����
	protected int price;	// ����
	protected int makeTime;	// ���� �ð�
	
	
	public abstract void getMineral();	// �̳׶� ����
	
	public abstract void getGas();	// ���� ����
	
	public abstract void getMakeTime();	// �ǹ� ����ð�
}
