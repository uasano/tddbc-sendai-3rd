package sample;

public abstract class Range {
	protected final int lower;
	protected final int upper;

	public Range(int lower, int upper) {
		if (upper < lower) {
			throw new IllegalArgumentException("上端点が下端点よりも小さいです");
		}
		this.lower = lower;
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public int getUpper() {
		return upper;
	}

	public boolean contains(int point){
		return contains(point,point);
	}
	
	public abstract boolean contains(int lower,int upper);

	/**
	　 * Eclipseによる自動生成コード。(non-Javadoc) 　
	 　*  @see java.lang.Object#hashCode()
	 　*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lower;
		result = prime * result + upper;
		return result;
	}

	/**
	　 * Eclipseによる自動生成コード。(non-Javadoc) 　
	 　*  @see java.lang.Object#equals()
	 　*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (lower != other.lower)
			return false;
		if (upper != other.upper)
			return false;
		return true;
	}

	@Override
	public abstract String toString();
//FIXME formatterの違いが吸収できればいいかも
	//		return String.format("[%d,%d]", lower, upper);
//	}
	
	public boolean isConnectedTo(Range r) {
		if(contains(r.lower, r.upper)){
			return true;
		}
		
		if(r.contains(lower,upper)){
			return true;
		}
		
		return false;
	}
}
