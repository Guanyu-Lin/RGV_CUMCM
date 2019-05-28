
public class Time {
	static int curTime;
	static int end = 8 * 60 *60;
	static CNC cnc[];
	
	public Time(int curTime, CNC[] cnc) {
		super();
		this.curTime = curTime;
		this.cnc = cnc;
	}

	static void go() {
		for (int i = 0; i < 8; i++) {
			cnc[i].renew();
		}
		curTime++;
		//System.out.println(curTime);
		if (curTime == end) {
			for (int i = 0; i < CNC.finishedRecord.size(); i++) {
				
				CNC.finishedRecord.get(i).show();
			}
			System.exit(end);
		
		}
	}
	
}
