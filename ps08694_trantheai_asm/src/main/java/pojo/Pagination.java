package pojo;

public class Pagination {
	private int rows;
	private int max;
	private int currentPage;
	
	public Pagination() {}
	public Pagination(int currentPage) {
		
		this.currentPage = currentPage;
	}
	public Pagination(int rows, int max, int currentPage) {
		super();
		this.rows = rows;
		this.max = max;
		this.currentPage = currentPage;
	}

	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPages() {
		return (int)Math.ceil((float)rows/max);
	}
}
