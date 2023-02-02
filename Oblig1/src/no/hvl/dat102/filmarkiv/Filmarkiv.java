package no.hvl.dat102.filmarkiv;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmarkiv;
	private int antall;
	
	public Filmarkiv(int antall) {
		this.filmarkiv = new Film[antall];
		this.antall = 0;
		
		
	}
	
	public Film[] getFilmarkiv() {
		
		return filmarkiv;
		
	}
	public void setFilmarkiv(Film[] filmarkiv) {
		
		this.filmarkiv = filmarkiv;
		
	}

	@Override
	public Film finnFilm(int nr) {
		Film funnet = new Film();
		
		for (int i = 0; i < filmarkiv.length; i++) {
			
			if (filmarkiv[i].getFilmnr() == nr) {
				
				funnet = filmarkiv[i];
				
			} else {
				
				funnet = null;
			}
		}
		return funnet;
	}
	

	@Override
	public void leggTilFilm(Film nyFilm) {
		int i = 0;
		while (i<=antall) {
			if(filmarkiv[i] == null) {
				filmarkiv[i] = nyFilm;
			} else {
				i++;
			}
		}
			
		
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false; 
		
		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getFilmnr() == filmnr) {
				filmarkiv[i] = null;
				slettet = true;
			}
		}
		trimTab(filmarkiv, antall);
		
		return slettet;
		
	}
//	private Film[] utvid() {
//		Film[] utvidet = new Film[filmarkiv.length*2];
//		
//				for (int i = 0; i < utvidet.length; i ++) {
//					utvidet[i] = filmarkiv[i];
//				}
//		return utvidet;
//	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tittel = new Film[filmarkiv.length];
		int nyAntall = 0;
		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getTittel().contains(delstreng)) {
				tittel[nyAntall] = filmarkiv[i];
				nyAntall++;
			}
		}
		trimTab(tittel, nyAntall);
		return tittel;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] produsent = new Film[filmarkiv.length];
		int nyAntall = 0;
		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getProdusent().contains(delstreng)) {
				produsent[nyAntall] = filmarkiv[i];
				nyAntall++;
			}
		}
		trimTab(produsent, nyAntall);
		return produsent;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getSjanger() == sjanger) { 
				antall++;
			} 
		}
		return antall;
		
		
		
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) { 
		  // n er antall elementer 
		  Film[] nytab = new Film[n]; 
		  int i = 0; 
		  while (i < n) { 
		   nytab[i] = tab[i]; 
		   i++; 
		  } 
		  return nytab; 
		 } 

}
