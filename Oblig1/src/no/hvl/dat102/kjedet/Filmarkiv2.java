package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.Film;
import no.hvl.dat102.filmarkiv.Sjanger;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall;
	private LinearNode<Film> start; 
	
	public Filmarkiv2 () {
		antall = 0;
		start = null;
	}

	@Override
	public Film finnFilm(int nr) {
		boolean funnet = false;
		LinearNode<Film> node = null;
 		LinearNode<Film> aktuell = start;
 		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().getFilmnr() == nr) {
				node = aktuell;
				funnet = true;
				} else {
				aktuell = aktuell.getNeste();
				}
		}
		return node.getElement();
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> film = new LinearNode<Film>(nyFilm);
		film.setNeste(start);
		start = film;
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		Film resultat = null;
		
		LinearNode<Film> node = new LinearNode<Film>(finnFilm(filmnr));
		
		if(node != null) {
			resultat = node.getElement();
			Film forsteFilm = start.getElement();
			node.setElement(forsteFilm);
			start = start.getNeste();
			antall--;
			slettet = true;
		}
		return slettet;
		
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tittel = new Film[antall];
		int count = 0;
		LinearNode<Film> aktuell = start;
		for(int i =0; i < antall; i++) {
			if(aktuell.getElement().getTittel().contains(delstreng)) {
				tittel[i] = aktuell.getElement();
				count++;
				
			}
			aktuell = aktuell.getNeste();
		}
		trimTab(tittel,count);
		
		return tittel;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] prod = new Film[antall];
		int count = 0;
		LinearNode<Film> aktuell = start;
		for(int i =0; i < antall; i++) {
			if(aktuell.getElement().getProdusent().contains(delstreng)) {
				prod[i] = aktuell.getElement();
				count++;
				
			}
			aktuell = aktuell.getNeste();
		}
		trimTab(prod,count);
		
		return prod;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int ant = 0;
		LinearNode<Film> aktuell = start;
		
		for (int i = 0; i<antall; i++) {
			if(aktuell.getElement().getSjanger() == sjanger) {
				ant++;
			}
		}
		return ant;
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
