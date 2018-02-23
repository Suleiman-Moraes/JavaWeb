package unidade3;

public class Login <T, V>{
	T t;
	V v;
	public Login(T t, V v) {
		super();
		this.t = t;
		this.v = v;
	}
	
	public T showType() {
		System.out.println(t.getClass().getName());
		System.out.println(v.getClass().getName());
		return null;
	}

	public T getT() {
		return t;
	}
	public V getV() {
		return v;
	}
	public void setT(T t) {
		this.t = t;
	}
	public void setV(V v) {
		this.v = v;
	}
	
}
