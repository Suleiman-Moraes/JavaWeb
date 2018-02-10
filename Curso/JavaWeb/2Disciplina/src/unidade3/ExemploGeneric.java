package unidade3;

public class ExemploGeneric <T>{
	T obj;

	public ExemploGeneric(T obj) {
		super();
		this.obj = obj;
	}

	public T showType() {
		System.out.println(obj.getClass().getName());
		return null;
	}
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExemploGeneric other = (ExemploGeneric) obj;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExemploGeneric [obj=" + obj + "]";
	}
	
}
