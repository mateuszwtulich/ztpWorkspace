public class Osoba {
	private String imie;
	private String nazwisko = "Kowalski";
	private int czyZdrowy = 20;
	private boolean wiek = true;

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public int getCzyZdrowy() {
		return czyZdrowy;
	}

	public boolean getWiek() {
		return wiek;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setCzyZdrowy(int czyZdrowy) {
		this.czyZdrowy = czyZdrowy;
	}

	public void setWiek(boolean wiek) {
		this.wiek = wiek;
	}

	private Osoba(OsobaBuilder builder) {
		this.imie = builder.imie;
		this.nazwisko = builder.nazwisko;
		this.czyZdrowy = builder.czyZdrowy;
		this.wiek = builder.wiek;
	}

	public static class OsobaBuilder {
		private String imie;
		private String nazwisko = "Kowalski";
		private int czyZdrowy = 20;
		private boolean wiek = true;

		public OsobaBuilder() {
		}

		OsobaBuilder imie(String imie) {
			this.imie = imie;
			return this;
		}

		OsobaBuilder nazwisko(String nazwisko) {
			this.nazwisko = nazwisko;
			return this;
		}

		OsobaBuilder czyZdrowy(int czyZdrowy) {
			this.czyZdrowy = czyZdrowy;
			return this;
		}

		OsobaBuilder wiek(boolean wiek) {
			this.wiek = wiek;
			return this;
		}

		public Osoba build(){
			return new Osoba(this);
		}
	}
}