package no.hvl.dat102.tabell;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.lang.*;

import no.hvl.dat102.adt.Parentessjekker;
import no.hvl.dat102.exception.EmptyCollectionException;

public class TabellParentesSjekker<Character> extends TabellStabel<Character> implements Parentessjekker {

	private Character[] expr;
	private int str;

	public TabellParentesSjekker(int maks) {
		str = 0;
		expr = (Character[]) (new Object[maks]);
	}

	@Override
	public boolean erVenstreparentes(char p) {
		boolean funnet = false;
		
	}

	@Override
	public boolean erHogreparentes(char p) {
		boolean funnet = false;

		if (peek().equals(p)) {
			funnet = true;
		}

		return funnet;

	}

	@Override
	public boolean erParentes(char p) {
		TabellStabel<Character> stabel = new TabellStabel<Character>();
		boolean funnet = false;
		for 


		return funnet;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		boolean par = false;

		if (erVenstreparentes(venstre)) {

			if (erHogreparentes(hogre)) {
				par = true;
			}
		}
		return par;
	}

	@Override
	public boolean erBalansert(String s) {
		TabellStabel<Character> stabel = new TabellStabel<Character>();

		for (int i = 0; i < s.length(); i++) {
			char e = s.charAt(i);
			Character[] charArray = stabel.toArray();

			if (e == '(' || e == '[' || e == '{') {

				stabel.push(charArray[i]);
				continue;
			}
			if (stabel.erTom())
				return false;

			char sjekk;
			Character ch;

			switch (e) {

			case ')':
				ch = stabel.pop();
				sjekk = (char) ch;
				if (sjekk == ']' || sjekk == '}')
					return false;
				break;
			case']':
				ch = stabel.pop();
				sjekk = (char) ch;
				if(sjekk == ')' || sjekk == '}') return false;
				break;
			case'}':
				ch = stabel.pop();
				sjekk = (char) ch;
				if(sjekk == ']' || sjekk ==')') return false;
				break;
			}

		}
	}

}
