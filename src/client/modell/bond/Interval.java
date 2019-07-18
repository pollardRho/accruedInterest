package client.modell.bond;

import java.time.LocalDate;

public class Interval {

	public Interval(LocalDate begin, LocalDate end) {
		this.begin = begin;
		this.end = end;
	}

	private LocalDate begin;
	private LocalDate end;

	public LocalDate getBegin() {
		return begin;
	}

	public LocalDate getEnd() {
		return end;
	}

	public boolean contains(LocalDate date) {

		if (date.isEqual(begin)) {
			return true;
		}

		if (date.isBefore(begin) || date.isAfter(end)) {
			return false;
		}

		return true;
	}

}
