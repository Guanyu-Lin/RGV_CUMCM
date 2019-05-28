import java.util.ArrayList;

public class CNC implements Comparable<CNC>{
	private int busyTime;
	//private int kind;
	Product load;
	private int num;
	private int workTime;
	
	
	public CNC(int busyTime, int preProduct, int num, int workTime) {
		super();
		this.load = null;
		this.busyTime = busyTime;
	//	this.kind = kind;
	//	this.preProduct = preProduct;
		this.num = num;
		this.workTime = workTime;
	}
	void renew() {
		if (this.busyTime < 0)
			this.busyTime++;
	}
	//int getKind() {return this.kind;}
	void startWork() {
		this.busyTime -= workTime;
	//	finishedRecord.add(new Record(this.productNum, this.num, Time.curTime - RGV.exchangeTime[this.num % 2], 0));
	/*	if (preProduct != -1) {
			finishedRecord.get(preProduct).setEnd(Time.curTime - RGV.exchangeTime[this.num % 2]);
		}*/
		//preProduct = this.productNum;
		
	//	this.productNum++;
	}
	int getNum() {return this.num;}
	boolean isBusy() {
		if (this.busyTime < 0) return true;
		else return false;
	}
	@Override
	public int compareTo(CNC arg0) {
		// TODO Auto-generated method stub
		/*int endTime1 = Time.curTime - this.busyTime;
		int endTime2 = Time.curTime - arg0.busyTime;*/
		int loc1 = (this.num + 1) / 2;
		int loc2 = (arg0.num + 1) / 2;
	//	System.out.println(Math.abs(RGV.cur - loc1) + "cur" +RGV.cur + ", loc1" + loc1 + ", loc2" + loc2);
		
		int canReachTime1 = Math.max(  RGV.travelTime[Math.abs(RGV.cur - loc1)] + RGV.exchangeTime[this.num % 2],  - this.busyTime + RGV.exchangeTime[this.num % 2]);
		int canReachTime2 = Math.max(  RGV.travelTime[Math.abs(RGV.cur - loc2)] + RGV.exchangeTime[arg0.num % 2],  - arg0.busyTime + RGV.exchangeTime[arg0.num % 2]);
		if (canReachTime1 > canReachTime2) return 1;
		else return 0;
	}
}
