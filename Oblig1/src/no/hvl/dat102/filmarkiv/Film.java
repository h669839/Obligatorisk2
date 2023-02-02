package no.hvl.dat102.filmarkiv;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsår;
	private String selskap;
	private Sjanger sjanger;
	
	public Film() {
		
	}
	
	
	public Film(int filmnr, String produsent, String tittel, int lanseringsår, String selskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsår = lanseringsår;
		this.selskap = selskap;
		this.sjanger = sjanger;
		
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsår() {
		return lanseringsår;
	}

	public void setLanseringsår(int lanseringsår) {
		this.lanseringsår = lanseringsår;
	}

	public String getSelskap() {
		return selskap;
	}

	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}
	
	@Override
	public boolean equals(Object andre) {
		if (this == andre) {
			return true;
		}
		if (andre == null) {
			return false;

		}
		if (getClass() != andre.getClass()) {
			return false;
		}
		Film denAndre = (Film) andre;
		boolean like = this.filmnr == denAndre.getFilmnr();
		return like;
	}
	@Override 
	public int hashCode() { 
	    Integer temp = filmnr; 
	    return temp.hashCode(); 
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	} 

}
