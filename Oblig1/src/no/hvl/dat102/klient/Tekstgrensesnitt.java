package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.Film;
import no.hvl.dat102.filmarkiv.Sjanger;

public class Tekstgrensesnitt {
	// lese opplysningene om en FILM fra tastatur;
	public Film lesFilm(){ 
		Scanner les = new Scanner(System.in);
		
		System.out.println("Film Nummer: ");
		int filmnr = les.nextInt();
		
		System.out.println("Produsent: ");
		String produsent = les.next();
		
		System.out.println("Tittel: ");
		String tittel = les.next();
		
		System.out.println("Lanseringsår: ");
		int lansår = les.nextInt();
		
		System.out.println("Selskap: ");
		String selskap = les.next();
		
		System.out.println("Sjanger(Bruk kun store bokstaver): ");
		String tekst = les.next();
		Sjanger sjanger = Sjanger.valueOf(tekst);
				 
		return new Film(filmnr, produsent, tittel, lansår, selskap, sjanger); 
		 } 
		 
		 // vise en film med alle opplysninger på skjerm (husk tekst for sjanger) 
	public void visFilm(Film film) { 
		System.out.println(film.getFilmnr() + "\n" + film.getProdusent()+ "\n" + film.getTittel()+ "\n" 
					+ film.getLanseringsår() + "\n" + film.getSelskap() +"\n"+ film.getSjanger());
		
		 } 
		 
		 // Skrive ut alle Filmer med en spesiell delstreng i tittelen 
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) { 
		 System.out.print(filma.soekTittel(delstreng));
		 } 
		 
		 // Skriver ut alle Filmer av en produsent / en gruppe 
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 
		 System.out.print(filma.soekProdusent(delstreng));
		 } 
		 
		 // Skrive ut en enkel statistikk som inneholder antall Filmer totalt 
		 // og hvor mange det er i hver sjanger 
	public void skrivUtStatistikk(FilmarkivADT filma) {
		
		  System.out.println("Totalt antall filmer: " + filma.antall());
		  System.out.println("Totalt antall filmer i sjangeren action: " + filma.antall(Sjanger.ACTION));
		  System.out.println("Totalt antall filmer i sjangeren drama: " + filma.antall(Sjanger.DRAMA));
		  System.out.println("Totalt antall filmer i sjangeren historie: " + filma.antall(Sjanger.HISTORY));
		  System.out.println("Totalt antall filmer i sjangeren scifi: " + filma.antall(Sjanger.SCIFI));
		 } 
}
