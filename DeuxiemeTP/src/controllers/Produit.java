package controllers;

public class Produit {
		private String intitule;
		private double prix;
		private int qt;
		
		public Produit(String intitule, double prix, int qt) {
			this.intitule = intitule;
			this.prix = prix;
			this.qt = qt;
		}

		public String getIntitule() {
			return intitule;
		}

		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public int getQt() {
			return qt;
		}

		public void setQt(int qt) {
			this.qt = qt;
		}

		@Override
		public String toString() {
			return "Produit [ intitule : " + intitule + ", prix = " + prix + ", quantite = "
					+ qt + "]";
		}
		
}
