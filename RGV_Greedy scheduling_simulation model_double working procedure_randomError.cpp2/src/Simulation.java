import java.util.Queue;
import java.util.Scanner;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Timer time = new Timer();
		int travelTime[] = new int [4];
		int workTime[] = new int [2];
		int clearTime = 0, target = -1, cur = 1;
		int exchangeTime[] = new int [2];
		//boolean hasTarget = false;
		Scanner in = new Scanner(System.in);
		travelTime[0] = 0;
		for (int i = 1; i <= 3; i++) travelTime[i] = in.nextInt();
		workTime[0] = in.nextInt();
		workTime[1] = in.nextInt();
		exchangeTime[1] = in.nextInt();
		exchangeTime[0] = in.nextInt();
		clearTime = in.nextInt();
	//	RGV rgv = new RGV(0, clearTime, target, cur);
		RGV rgv = new RGV(0, clearTime, target);
		int CNC_1 = in.nextInt();
		int CNC_2 = in.nextInt();
		int kind1[] = new int[CNC_1];
		int kind2[] = new int[CNC_2];
		
		CNC cnc[] = new CNC[8];
		for (int i = 0; i < CNC_1; i++) {
			kind1[i] = in.nextInt();
			cnc[kind1[i] - 1] = new CNC(0, 1, -1, kind1[i], workTime[0]);
		}
		for (int i = 0; i < CNC_2; i++) {
			kind2[i] = in.nextInt();
			cnc[kind2[i] - 1] = new CNC(0, 2, -1, kind2[i], workTime[1]);
		}
		
		
		
		
		RGV.travelTime = travelTime;
		RGV.exchangeTime = exchangeTime;
		Timer.cnc = cnc;
		//cnc[0].time = time;
		
		Queue<CNC> CNC_Queue[] = new java.util.PriorityQueue[2];
		CNC_Queue[0] = new java.util.PriorityQueue(CNC_1);
		CNC_Queue[1] = new java.util.PriorityQueue(CNC_2);
		for (int i = 0; i < 8; i++) {
			CNC_Queue[cnc[i].getKind() - 1].add(cnc[i]);
		}
		rgv.loadNew();
		while (true) {
			if (!rgv.hasTarget()) {
				rgv.setTarget(CNC_Queue[rgv.getLoad().getKind() - 1].poll().getNum());
			}
			if (rgv.isReach() ) {
				if (!cnc[rgv.getTarget() - 1].isBusy()) {
					rgv.exchange();
					cnc[rgv.getTarget() - 1].startWork();
					int preTarget = rgv.getTarget();
					rgv.setTarget(-1);
					if (rgv.getLoad().getKind() == 3) {
						rgv.clean();
						rgv.loadNew();
					}
					CNC_Queue[cnc[preTarget - 1].getKind() - 1].add(cnc[preTarget - 1]);
				}
				else Timer.go();
				
			}
			else rgv.run();
			
			
		}
	}

}
