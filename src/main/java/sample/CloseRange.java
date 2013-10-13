package sample;

public class CloseRange extends Range{
	public CloseRange(int lower, int upper) {
		super(lower, upper);
	}

	public boolean contains(int lower,int upper) {
		return this.lower <= upper && lower <= this.upper;
	}

	@Override
	public String toString() {
		return String.format("[%d,%d]", lower, upper);
	}
	
}
