package mx.com.geekflu.thread;

public class Item {
	private Integer id;
	private String data;
	
	public Item(Integer id, String data) {
		super();
		this.id = id;
		this.data = data;
	}
	
	public Item(Integer id) {
		super();
		this.id = id;
		this.data = " - " + id + " - ";
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", data=" + data + "]";
	}
	
	
	
}
