import java.util.ArrayList;

public class CNC implements Comparable<CNC>{
	private int busyTime;
	private int preProduct;
	private int num;
	static int productNum = 0;
	static int workTime;
	static ArrayList<Record> finishedRecord = new ArrayList<Record>();

	public CNC(int busyTime, int preProduct, int num) {
		super();
		this.busyTime = busyTime;
		this.preProduct = -1;
		this.num = num;
	}
	void renew() {
		if (this.busyTime < 0)
			this.busyTime++;
	}
	void startWork() {
		this.busyTime -= workTime;
		finishedRecord.add(new Record(this.productNum, this.num, Time.curTime - RGV.exchangeTime[this.num % 2], 0));
		if (preProduct != -1) {
			finishedRecord.get(preProduct).setEnd(Time.curTime - RGV.exchangeTime[this.num % 2]);
		}
		preProduct = this.productNum;
		this.productNum++;
	}
	int getNum() {return this.num;}
	boolean isBusy() {
		if (this.busyTime < 0) return true;
		else return false;
	}
	@Override
	public int compareTo(CNC arg0) {
		// TODO Auto-generated method stub
		int endTime1 = Time.curTime - this.busyTime;
		int endTime2 = Time.curTime - arg0.busyTime;
		int loc1 = (this.num + 1) / 2;
		int loc2 = (arg0.num + 1) / 2;
	//	System.out.println(Math.abs(RGV.cur - loc1) + "cur" +RGV.cur + ", loc1" + loc1 + ", loc2" + loc2);
		
		int canReachTime1 = Math.max(Time.curTime + RGV.travelTime[Math.abs(RGV.cur - loc1)] + RGV.exchangeTime[this.num % 2], Time.curTime - this.busyTime + RGV.exchangeTime[this.num % 2]);
		int canReachTime2 = Math.max(Time.curTime + RGV.travelTime[Math.abs(RGV.cur - loc2)] + RGV.exchangeTime[arg0.num % 2], Time.curTime - arg0.busyTime + RGV.exchangeTime[arg0.num % 2]);
		if (canReachTime1 > canReachTime2) return 1;
		else return 0;
	}
}
