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
		 filmarkiv.leggTilFilm(new Film(1, "Konrad Ågesen", "Lost Beast", 2020, "Warner Bros", Sjanger.ACTION));
		 filmarkiv.leggTilFilm(new Film(2, "Eric Garcia", "Art of Centerback", 2023, "Paramount Global", Sjanger.DRAMA));
		 filmarkiv.leggTilFilm(new Film(3, "Henrik Fjortland", "DD-Day", 1990, "Sony Pictures", Sjanger.HISTORY));
		 filmarkiv.leggTilFilm(new Film(4, "Gunnar Lange", "My love, don`t leave", 2004, "Universal Studios", Sjanger.DRAMA));
		 filmarkiv.leggTilFilm(new Film(5, "Bruce Kramer", "Space Cowboys", 2021, "Warner Bros", Sjanger.SCIFI));
		 filmarkiv.leggTilFilm(new Film(6, "Konrad Ågesen", "The Russian Spy", 2013, "Universal Studios", Sjanger.ACTION));
		 Film a = tekstgr.lesFilm();
		 filmarkiv.leggTilFilm(a);
		 tekstgr.visFilm(a);
		  tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Sp");
		  tekstgr.skrivUtFilmProdusent(filmarkiv, "Ågesen");
		  tekstgr.skrivUtStatistikk(filmarkiv);
	      
	 } 
	 
}
