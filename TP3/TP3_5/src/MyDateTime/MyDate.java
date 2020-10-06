package MyDateTime;

public class MyDate {
	protected int i_day;
	protected int i_month;
	protected int i_year;

	public MyDate() {
		this.i_day = 1;
		this.i_month = 1;
		this.i_year = 1600;
	}

	MyDate(int jour, int mois, int anne) {
		this.i_day = jour;
		this.i_month = mois;
		this.i_year = anne;
	}

	public int comparez(MyDate d1, MyDate d2) {
		if (d1.i_year > d2.i_year) {
			return -1;
		}
		if (d1.i_year < d2.i_year) {
			return 1;
		}
		if (d1.i_year == d2.i_year) {
			if (d1.i_month > d2.i_month) {
				return -1;
			} else if (d1.i_month < d2.i_month) {
				return 1;
			} else {
				if (d1.i_day > d2.i_day) {
					return -1;
				} else if (d1.i_day == d2.i_day) {
					return 0;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	public boolean checkleapYear(MyDate d) {
		if (d.i_year % 100 == 0 && d.i_year % 400 == 0) {
			return true;
		} else
			return false;
	}

	public boolean checkDate(MyDate d) {
		if (d.i_month == 1 || d.i_month == 3 || d.i_month == 5 || d.i_month == 7 || d.i_month == 8 || d.i_month == 10
				|| d.i_month == 12) {
			if (d.i_day <= 31) {
				return true;
			} else
				return false;
		}
		if (d.i_month == 4 || d.i_month == 6 || d.i_month == 9 || d.i_month == 11) {
			if (d.i_day <= 30)
				return true;
			else
				return false;
		}
		if (d.i_month == 2) {
			if (checkleapYear(d) == true) {
				if (d.i_day <= 29)
					return true;
				else
					return false;

			} else if (checkleapYear(d) == false) {
				if (d.i_day <= 29)
					return false;
				else
					return true;
			}
		}
		return false;
	}

	// Calculez la distance entre deux dates générées à partir de MyDate.
	// défaut: 365 jours par an, 30 jours par mois
	// retourne jours
	public int distance(MyDate d1, MyDate d2) {
		int dis = 0;
		if (comparez(d1, d2) == 0) {
			return 0;
		}

		if (d1.i_year == d2.i_year) {
			dis = (d2.i_month - d1.i_month) * 30 + (d2.i_day - d1.i_day);
		}
		if (d1.i_year < d2.i_year) {
			if (d1.i_month <= d2.i_month) {
				if (d1.i_day <= d2.i_day) {
					dis = (d2.i_year - d1.i_year) * 365 + (d2.i_month - d1.i_month) * 30 + d2.i_day - d1.i_day;
				} else {
					dis = (d2.i_year - d1.i_year) * 365 + (d2.i_month - d1.i_month) * 30 - (d1.i_day - d2.i_day);
				}
			} else {
				dis = (d2.i_year - d1.i_year) * 365 + (d2.i_month - d1.i_month) * 30 + d2.i_day - d1.i_day;
			}
		}

		return dis;
	}

	public String toString() {
		return this.i_day + "-" + this.i_month + "-" + this.i_year;
	}

	public String toString(String date) {
		return date;
	}
}
