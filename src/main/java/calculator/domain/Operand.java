package calculator.domain;

public class Operand {

	private static final int MIN_BOUND = 0;

	private int number;

	public Operand(int number) {
		validateBounds(number);
		this.number = number;
	}

	public static Operand valueOf(String input) {
		try {
			return new Operand(Integer.parseInt(input));
		} catch (NumberFormatException e) {
			throw new OperandException(OperandException.NOT_NUMBER);
		}
	}

	private void validateBounds(int num) {
		if (num < MIN_BOUND) {
			throw new OperandException(OperandException.NOT_NEGATVIE);
		}
	}

	public Operand sum(Operand next) {
		return new Operand(Math.addExact(this.number, next.number));
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass()) {
			return false;
		}
		Operand operand = (Operand)obj;
		return this.number == operand.number;
	}
}
