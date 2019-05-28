import java.util.Queue;
import java.util.Scanner;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int travelTime[] = new int [4];
		int workTime = 0, clearTime = 0, target = -1, cur = 1;
		int exchangeTime[] = new int [2];
		//boolean hasTarget = false;
		Scanner in = new Scanner(System.in);
		travelTime[0] = 0;
		for (int i = 1; i <= 3; i++) travelTime[i] = in.nextInt();
		workTime = in.nextInt();
		exchangeTime[1] = in.nextInt();
		exchangeTime[0] = in.nextInt();
		clearTime = in.nextInt();
		RGV rgv = new RGV(0, clearTime, target, cur);
		CNC cnc[] = new CNC[8];
		for (int i = 0; i < 8; i++) {
			cnc[i] = new CNC(0, -1, i + 1);
		}
		CNC.workTime = workTime;
		RGV.travelTime = travelTime;
		RGV.exchangeTime = exchangeTime;
		Time.cnc = cnc;
		
		Queue<CNC> CNC_Queue = new java.util.PriorityQueue(8);
		for (int i = 0; i < 8; i++) {
			CNC_Queue.add(cnc[i]);
		}
		while (true) {
			if (!rgv.hasTarget()) {
				rgv.setTarget(CNC_Queue.poll().getNum());
			}
			if (rgv.isReach() ) {
				if (!cnc[rgv.getTarget() - 1].isBusy()) {
					rgv.exchange();					
					cnc[rgv.getTarget() - 1].startWork();
					int preTarget = rgv.getTarget();
					rgv.setTarget(-1);
					rgv.clean();
					CNC_Queue.add(cnc[preTarget - 1]);
				}
				else Time.go();
				
			}
			else rgv.run();
			//System.out.println(rgv.isReach());
			
		}
	}

}
