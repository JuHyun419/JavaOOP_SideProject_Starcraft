package units;

import common.unit.unitHpMp;
import unit.GroundUnit;
import unit.Unit;

public class Scv extends Unit implements GroundUnit{
	
	
	public Scv() {
		hp = unitHpMp.SCV_HP;
		mp = unitHpMp.SCV_MP;
		attack = 5;
		defense = 1;
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMineral() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPopulationNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUnitNum() {
		return this.unitNum;
	}

	@Override
	public int getMakeTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMarineInfo() {
		// TODO Auto-generated method stub
		
	}

}
