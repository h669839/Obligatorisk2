package no.hvl.dat102.klient;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.*;
import no.hvl.dat102.filmarkiv.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;  
	private FilmarkivADT filmarkiv;  
	  
	 public Meny(FilmarkivADT filmarkiv){ 
	  tekstgr = new Tekstgrensesnitt();  
	  this.filmarkiv = filmarkiv; 
	 } 
	  
	 public void start(){ 
		 Film n1 = new Film(1, "Konrad Ågesen", "Lost Beast", 2020, "Warner Bros", Sjanger.ACTION);
		 Film n2 = new Film(2, "Eric Garcia", "Art of Centerback", 2023, "Paramount Global", Sjanger.DRAMA);
		 Film n3 = new Film(3, "Henrik Fjortland", "DD-Day", 1990, "Sony Pictures", Sjanger.HISTORY);
		 Film n4 = new Film(4, "Gunnar Lange", "My love, don`t leave", 2004, "Universal Studios", Sjanger.DRAMA);
		 Film n5 = new Film(5, "Bruce Kramer", "Space Cowboys", 2021, "Warner Bros", Sjanger.SCIFI);
		 Film n6 = new Film(6, "Konrad Ågesen", "The Russian Spy", 2013, "Universal Studios", Sjanger.ACTION);
		 
		 filmarkiv.leggTilFilm(n1);
		 filmarkiv.leggTilFilm(n2);
		 filmarkiv.leggTilFilm(n3);
		 filmarkiv.leggTilFilm(n4);
		 filmarkiv.leggTilFilm(n5);
		 filmarkiv.leggTilFilm(n6);
		 
		 Film n7 = tekstgr.lesFilm();
		 filmarkiv.leggTilFilm(n7);
		 
		 tekstgr.visFilm(n3);
		 tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Sp");
		 tekstgr.skrivUtFilmProdusent(filmarkiv, "Ågesen");
		 tekstgr.skrivUtStatistikk(filmarkiv);
	      
	 } 
	 
}
