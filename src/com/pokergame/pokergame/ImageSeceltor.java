package com.pokergame.pokergame;

public class ImageSeceltor {
	private Card card;
	private int number;
	private String path = "../public/CardImage/gif/";
	
	public ImageSeceltor(Card card) {
		this.card = card;
		number = card.getNumber();
	}
	
	public String getImageIcon() {
		if(!card.isOpen) {
			return path+"z02.gif";
		} else {
			if (card.getClass().equals(Spade.class)) {
				switch (number) {
					case 1:
						return path+"s01.gif";
					case 2:
						return path+"s02.gif";
					case 3:
						return path+"s03.gif";
					case 4:
						return path+"s04.gif";
					case 5:
						return path+"s05.gif";
					case 6:
						return path+"s06.gif";
					case 7:
						return path+"s07.gif";
					case 8:
						return path+"s08.gif";
					case 9:
						return path+"s09.gif";
					case 10:
						return path+"s10.gif";
					case 11:
						return path+"s11.gif";
					case 12:
						return path+"s12.gif";
					default:
						return path+"s13.gif";
				}
			} else if (card.getClass().equals(Diamond.class)) {
				switch (number) {
					case 1:
						return path+"d01.gif";
					case 2:
						return path+"d02.gif";
					case 3:
						return path+"d03.gif";
					case 4:
						return path+"d04.gif";
					case 5:
						return path+"d05.gif";
					case 6:
						return path+"d06.gif";
					case 7:
						return path+"d07.gif";
					case 8:
						return path+"d08.gif";
					case 9:
						return path+"d09.gif";
					case 10:
						return path+"d10.gif";
					case 11:
						return path+"d11.gif";
					case 12:
						return path+"d12.gif";
					default:
						return path+"d13.gif";
				}
			} else if (card.getClass().equals(Heart.class)) {
				switch (number) {
					case 1:
						return path+"h01.gif";
					case 2:
						return path+"h02.gif";
					case 3:
						return path+"h03.gif";
					case 4:
						return path+"h04.gif";
					case 5:
						return path+"h05.gif";
					case 6:
						return path+"h06.gif";
					case 7:
						return path+"h07.gif";
					case 8:
						return path+"h08.gif";
					case 9:
						return path+"h09.gif";
					case 10:
						return path+"h10.gif";
					case 11:
						return path+"h11.gif";
					case 12:
						return path+"h12.gif";
					default:
						return path+"h13.gif";
				}
			} else if (card.getClass().equals(Club.class)) {
				switch (number) {
					case 1:
						return path+"c01.gif";
					case 2:
						return path+"c02.gif";
					case 3:
						return path+"c03.gif";
					case 4:
						return path+"c04.gif";
					case 5:
						return path+"c05.gif";
					case 6:
						return path+"c06.gif";
					case 7:
						return path+"c07.gif";
					case 8:
						return path+"c08.gif";
					case 9:
						return path+"c09.gif";
					case 10:
						return path+"c10.gif";
					case 11:
						return path+"c11.gif";
					case 12:
						return path+"c12.gif";
					default:
						return path+"c13.gif";
				}
			} else {
				return path+"x01.gif";
			}
		}
	}
}
