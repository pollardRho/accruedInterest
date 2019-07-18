package domain.service.validator;

public abstract class BondModellValdidator {

	private Validator start;

	BondModellValdidator(Validator start) {
		this.start = start;
	};

	protected Validator successor;

	public void validate() {
		start.validate();
		successor.validate();
	};

	void setSuccessor(Validator successor) {
		this.successor = successor;
	}
}
