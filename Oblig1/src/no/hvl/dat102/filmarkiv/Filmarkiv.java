package no.hvl.dat102.filmarkiv;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmarkiv;
	private int antall;
	
	public Filmarkiv(int antall) {
		filmarkiv = new Film[antall];
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
		
		for (int i = antall; i < filmarkiv.length; i++) {
			
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
		int i = antall;
		
		while (i < filmarkiv.length) {
			
			if (filmarkiv[i] == null) {
				
				filmarkiv[i] = nyFilm;
				break;
			}
			i++;
			antall++;
		}
			
		
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false; 
		Film f = finnFilm(filmnr);
		if (f != null) {
			f = null;
			slettet = true;
		}
		filmarkiv = trimTab(filmarkiv, filmarkiv.length);
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
		Film[] tab = trimTab(filmarkiv, antall);
		int nyAntall = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].getTittel().contains(delstreng) && tab[i] != null) {
				tittel[nyAntall] = tab[i];
				nyAntall++;
			}
		}
		tittel = trimTab(tittel, nyAntall);
		return tittel;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] produsent = new Film[filmarkiv.length];
		Film[] tab = trimTab(filmarkiv, antall);
		
		int nyAntall = 0;
		for (int i = 0; i < tab.length; i++) {
			
			if (tab[i].getProdusent().contains(delstreng)) {
				
				produsent[nyAntall] = tab[i];
				nyAntall++;
			}
		}
		produsent = trimTab(produsent, nyAntall);
		
		return produsent;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		Film[] tab = trimTab(filmarkiv, antall); 
		
		for (int i = 0; i < tab.length; i++) {
			
			if (tab[i].getSjanger() == sjanger) { 
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
