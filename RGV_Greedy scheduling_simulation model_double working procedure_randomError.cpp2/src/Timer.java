
public class Timer {

	static int end = 8 * 60 *60;
	static CNC cnc[];
	static int curTime;
	
	
	static void go() {
		for (int i = 0; i < 8; i++) {
			cnc[i].renew();
		}
		curTime++;
		//System.out.println(curTime);
		if (curTime == end) {
			for (int i = 0; i < Record.finished.size(); i++) {	
				Record.finished.get(i).show();
			}
			for (int i = 0; i < brokenRecord.br.size(); i++) {
				brokenRecord.br.get(i).show();
			}
			System.exit(end);
		
		}
	}
	int getTime() {return curTime;} 
	
}
