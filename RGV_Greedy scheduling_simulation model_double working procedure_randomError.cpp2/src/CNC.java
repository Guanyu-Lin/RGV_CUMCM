
import java.util.ArrayList;

public class CNC implements Comparable<CNC>{
	private int busyTime;
	private int kind;
	//private int preProduct;
	Product load;
	private int num;
	private int brokenTime;
	//static int productNum = 0;
	private int workTime;
	//static Timer time;
	
	public CNC(int busyTime, int kind, int preProduct, int num, int workTime) {
		super();
		this.brokenTime = 1;
	/*	int randNum = (int)(Math.random() * 100);
		if (randNum == 0) {
			this.brokenTime = (int)(Math.random() * (80 * 6 * 6));
		}*/
		//System.out.println(this.brokenTime);
		this.load = null;
		this.busyTime = busyTime;
		this.kind = kind;
	//	this.preProduct = preProduct;
		this.num = num;
		this.workTime = workTime;
	}
	void renew() {
		/*int randNum = (int)(Math.random() * 100);
		if (randNum == 0) {
			int randTime = (int) (Math.random() * 10 * 60) + 10 * 60;
			int brokenNum = -1;
			if (this.load != null) {
				brokenNum = this.load.getNum();
			}
			brokenRecord.br.add(new brokenRecord(brokenNum, this.num, Timer.curTime, Timer.curTime + randTime));
			this.busyTime = -randTime;
			this.load = null;
		}*/
		/*if (Timer.curTime == this.brokenTime) {
			int randTime = (int) (Math.random() * 10 * 60) + 10 * 60;
			int brokenNum = -1;
			if (this.load != null) {
				brokenNum = this.load.getNum();
			}
			brokenRecord.br.add(new brokenRecord(brokenNum, this.num, Timer.curTime, Timer.curTime + randTime));
			this.busyTime = -randTime;
			this.load = null;
		}
*/		
		if (this.busyTime < 0)
		{
			if (this.busyTime == this.brokenTime) {
				int randTime = (int) (Math.random() * 10 * 60) + 10 * 60;
				int brokenNum = -1;
				if (this.load != null) {
					brokenNum = this.load.getNum() + 1;
				}
				brokenRecord.br.add(new brokenRecord(brokenNum, this.num, Timer.curTime, Timer.curTime + randTime));
				this.busyTime = -randTime;
				this.load = null;
				this.brokenTime = 1;
			}
			else this.busyTime++;
		}
			
	}
	int getKind() {return this.kind;}
	void startWork() {
		
		this.busyTime -= workTime;
		int randNum = (int)(Math.random() * 100);
		if (randNum == 0) {
			this.brokenTime = -(int)(workTime * Math.random());
		}
	
	}
	int getNum() {return this.num;}
	boolean isBusy() {
		if (this.busyTime < 0) return true;
		else return false;
	}
	@Override
	public int compareTo(CNC arg0) {
		// TODO Auto-generated method stub
		int endTime1 = Timer.curTime - this.busyTime;
		int endTime2 = Timer.curTime - arg0.busyTime;
		int loc1 = (this.num + 1) / 2;
		int loc2 = (arg0.num + 1) / 2;
	//	System.out.println(Math.abs(RGV.cur - loc1) + "cur" +RGV.cur + ", loc1" + loc1 + ", loc2" + loc2);
		
		int canReachTime1 = Math.max(Timer.curTime + RGV.travelTime[Math.abs(RGV.cur - loc1)] + RGV.exchangeTime[this.num % 2], Timer.curTime - this.busyTime + RGV.exchangeTime[this.num % 2]);
		int canReachTime2 = Math.max(Timer.curTime + RGV.travelTime[Math.abs(RGV.cur - loc2)] + RGV.exchangeTime[arg0.num % 2], Timer.curTime - arg0.busyTime + RGV.exchangeTime[arg0.num % 2]);
		if (canReachTime1 > canReachTime2) return 1;
		else return 0;
	}
}
