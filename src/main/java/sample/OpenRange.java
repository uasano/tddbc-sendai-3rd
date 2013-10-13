package sample;

public class OpenRange extends Range{
	
	public OpenRange(int lower, int upper) {
		super(lower, upper);
	}

	@Override
	public boolean contains(int lower,int upper) {
		return this.lower < upper && lower < this.upper;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", lower, upper);
	}
}
