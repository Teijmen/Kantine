package KantineSimulatieBasis.src.main.java;

public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor
	 */
	public Datum(int dag, int maand, int jaar) {
		this();
		if(bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}

	/**
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString(int dag, int maand, int jaar) {
		String datum = String.valueOf(this.dag) + " - " + String.valueOf(this.maand) + " - " + String.valueOf(this.jaar) ;
		return datum;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public int getDag() {
		return dag;
	}

	public int getMaand() {
		return maand;
	}

	public int getJaar() {
		return jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar) {
		if(dag < 1) {
			return false;
		} if(maand < 1 && maand > 12) {
			return false;
		} if(jaar < 1900 && jaar > 2100) {
			return false;
		} if(maand == 1 && dag > 31) {
			return false;
		} if (maand == 3 && dag > 31) {
			return false;
		} if (maand == 5 && dag > 31) {
			return false;
		} if (maand == 7 && dag > 31) {
			return false;
		} if (maand == 8 && dag > 31) {
			return false;
		} if (maand == 10 && dag > 31) {
			return false;
		} if (maand == 12 && dag > 31) {
			return false;
		} if(maand == 2 && dag > 28 && isSchrikkelJaar(jaar) == false) {
			return false;
		} if(maand == 2 && dag > 29 && isSchrikkelJaar(jaar) == true) {
			return false;
		} if (maand == 4 && dag > 30) {
			return false;
		} if (maand == 6 && dag > 30) {
			return false;
		} if (maand == 9 && dag > 30) {
			return false;
		} if (maand == 11 && dag > 30) {
			return false;
		}
		return true;
	}

	public boolean isSchrikkelJaar(int jaar) {
		if(jaar %4 != 0) {
			return false;
		}

		if(jaar %100 == 0 && jaar %400 != 0) {
			return false;
		}
		return true;
	}
}
