
public class Product {
	private int num;
	private int cnc_num[];
	private int start[];
	private int end[];
	private int kind;
	static int productNum = 0;
	
	public Product() {
		super();
		num = productNum++;
		cnc_num = new int [2];
		start = new int [2];
		end = new int [2];
		kind = 1;
	}
	int getNum() {return this.num;}
	void setEnd(int time) {
		if (kind == 1) 
			this.end[0] = time;
		else if (this.kind == 2)
			this.end[1] = time;
	}
	void setStart(int time) {
		if (kind == 1) {
			this.start[0] = time;
		}
		else if (this.kind == 2) this.start[1] = time;
	}
	void afterMachining() {this.kind++;}
	void setCNC(int target) {
		if (this.kind == 1) cnc_num[0] =target; 
		else if (this.kind == 2)cnc_num[1] =target;
	}
	int getKind() {return this.kind;}
	void show() {
		System.out.println(" " + (this.num + 1) + " " + this.cnc_num[0] + " " + this.start[0] + " " + this.end[0] +" " + cnc_num[1] + " " + this.start[1] + " " + this.end[1] );
	}
}
