
public class Product {
	private int num;
	private int cnc_num;
	private int start;
	private int end;
	private int kind;
	static int productNum = 0;
	
	public Product() {
		super();
		num = productNum++;
		kind = 1;
	}
	void setEnd(int time) {
		if (kind == 1) 
			this.end = time;
		
	}
	void setStart(int time) {
		if (kind == 1) {
			this.start = time;
		}
		
	}
	void afterMachining() {this.kind++;}
	void setCNC(int target) {
		if (this.kind == 1) cnc_num =target; 
		
	}
	int getKind() {return this.kind;}
	void show() {
		System.out.println( (this.num + 1) + " " + this.cnc_num + " " + this.start+ " " + this.end );
	}
}
