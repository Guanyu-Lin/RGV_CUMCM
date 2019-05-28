
public class RGV {
	private int isBusy;
	private int clearTime;
	private int target;
	static int cur;
	//private boolean hasTarget;
	static int exchangeTime[];
	static int travelTime[];
	public RGV(int isBusy, int clearTime, int target, int cur) {
		super();
		this.isBusy = isBusy;
		this.clearTime = clearTime;
		this.target = target;
		this.cur = cur;
		//this.hasTarget = hasTarget;
		
	}


	boolean hasTarget() {
		if (target == -1) return false;
		else return true;
	}
	void setTarget(int target) {this.target = target;}
	int getTarget() {return target;}
	boolean isReach() {return (target + 1) / 2 == cur;}
	void exchange() {
		
		for (int i = 0; i < exchangeTime[target % 2]; i++) {
			Time.go();
		}
	}
	void clean() {
		for (int i = 0; i < this.clearTime; i++) {
			Time.go();
		}
	}
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
