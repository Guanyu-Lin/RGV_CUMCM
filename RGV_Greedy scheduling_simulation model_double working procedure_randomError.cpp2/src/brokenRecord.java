import java.util.ArrayList;

public class brokenRecord {
	static ArrayList<brokenRecord> br = new ArrayList<brokenRecord>();  
	private int productNum;
	private int cnc_num;
	private int start;
	private int end;
	public brokenRecord(int productNum, int cnc_num, int start, int end) {
		super();
		this.productNum = productNum;
		this.cnc_num = cnc_num;
		this.start = start;
		this.end = end;
	}
	void show() {
		System.out.println(" " + (this.productNum) + " " + this.cnc_num + " " + this.start + " " + this.end);
	}
}
