
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
	void setTarget(int target) {this.target = target;}
	int getTarget() {return target;}
	boolean isReach() {return (target + 1) / 2 == cur;}
	void exchange() {
		if (Timer.cnc[this.target - 1].load != null) {
			Timer.cnc[this.target - 1].load.setEnd(Timer.curTime);
			Timer.cnc[this.target - 1].load.afterMachining();
		}
		this.load.setStart(Timer.curTime);
		
		this.load.setCNC(this.target);
		Product tmp = Timer.cnc[this.target - 1].load;
		Timer.cnc[this.target - 1].load = this.load;
		this.load = tmp;
		for (int i = 0; i < exchangeTime[target % 2]; i++) {
			Timer.go();
		}
		if (this.load == null) {
			this.loadNew();
		}
		
	}
	void clean() {
		for (int i = 0; i < this.clearTime; i++) {
			Timer.go();
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

			Timer.go();
		}
		this.cur = loc;
	
				
	}
}
