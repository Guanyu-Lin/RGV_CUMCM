
public class RGV {
	private int isBusy;
//	private int loadKind;
	private int clearTime;
	private int target;
	private Product load;
	static int cur;
	//private boolean hasTarget;
	static int exchangeTime[];
	static int travelTime[];



	public RGV(int isBusy, int clearTime, int target) {
		super();
		this.load = null;
		this.isBusy = isBusy;
	//	this.loadKind = loadKind;
		this.clearTime = clearTime;
		this.target = target;
		this.cur = 1;
	}
	void loadNew() {
		if (this.load != null) {
			Record.finished.add(this.load);
		}
		this.load = new Product();
		
	}
	boolean hasTarget() {
		if (target == -1) return false;
		else return true;
	}
//	int getLoadKind() {return this.loadKind;}
	void setTarget(int target) {this.target = target;}
	int getTarget() {return target;}
	boolean isReach() {return (target + 1) / 2 == cur;}
	void exchange() {
		if (Time.cnc[this.target - 1].load != null) {
			Time.cnc[this.target - 1].load.setEnd(Time.curTime);
			Time.cnc[this.target - 1].load.afterMachining();
		}
		this.load.setStart(Time.curTime);	
		this.load.setCNC(this.target);
		
		Product tmp = Time.cnc[this.target - 1].load;
		Time.cnc[this.target - 1].load = this.load;
		this.load = tmp;
		
		for (int i = 0; i < exchangeTime[target % 2]; i++) {
			Time.go();
		}
		if (this.load == null) {
			this.loadNew();
		}
		
	}
	void clean() {
		for (int i = 0; i < this.clearTime; i++) {
			Time.go();
		}
	}
	Product getLoad() {return this.load;}
	void run() { 
		int loc = (this.target + 1) / 2;
		//int direction = this.target - this.cur;
		int t = travelTime[Math.abs(loc - this.cur)];
	/*	int runDriection = 0 ;
		if (direction > 0) {
			runDriection = 1;
		}
		else if (direction < 0) {
			runDriection = -1;
		}*/
		for (int i = 0; i < t; i++) {

			Time.go();
		}
		this.cur = loc;
	
				
	}
}
