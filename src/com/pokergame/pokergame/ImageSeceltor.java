package com.pokergame.pokergame;

public class ImageSeceltor {
	private Card card;
	private int number;
	
	public ImageSeceltor(Card card) {
		this.card = card;
		number = card.getNumber();
	}
	
	public String getImageIcon() {
		if(!card.isOpen) {
			return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/z02.gif";
		} else {
			if (card.getClass().equals(Spade.class)) {
				switch (number) {
					case 1:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s01.gif";
					case 2:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s02.gif";
					case 3:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s03.gif";
					case 4:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s04.gif";
					case 5:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s05.gif";
					case 6:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s06.gif";
					case 7:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s07.gif";
					case 8:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s08.gif";
					case 9:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s09.gif";
					case 10:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s10.gif";
					case 11:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s11.gif";
					case 12:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s12.gif";
					default:
						return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/s13.gif";
				}
			} else if (card.getClass().equals(Diamond.class)) {
				switch (number) {
				case 1:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d01.gif";
				case 2:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d02.gif";
				case 3:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d03.gif";
				case 4:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d04.gif";
				case 5:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d05.gif";
				case 6:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d06.gif";
				case 7:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d07.gif";
				case 8:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d08.gif";
				case 9:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d09.gif";
				case 10:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d10.gif";
				case 11:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d11.gif";
				case 12:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d12.gif";
				default:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/d13.gif";
				}
			
			} else if (card.getClass().equals(Heart.class)) {
				switch (number) {
				case 1:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h01.gif";
				case 2:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h02.gif";
				case 3:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h03.gif";
				case 4:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h04.gif";
				case 5:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h05.gif";
				case 6:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h06.gif";
				case 7:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h07.gif";
				case 8:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h08.gif";
				case 9:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h09.gif";
				case 10:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h10.gif";
				case 11:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h11.gif";
				case 12:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h12.gif";
				default:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/h13.gif";
				}
			
			} else if (card.getClass().equals(Club.class)) {
				switch (number) {
				case 1:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c01.gif";
				case 2:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c02.gif";
				case 3:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c03.gif";
				case 4:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c04.gif";
				case 5:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c05.gif";
				case 6:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c06.gif";
				case 7:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c07.gif";
				case 8:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c08.gif";
				case 9:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c09.gif";
				case 10:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c10.gif";
				case 11:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c11.gif";
				case 12:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c12.gif";
				default:
					return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/c13.gif";
				}
			} else {
				return "/Users/yuuto-ookawa/Documents/Programming/java/poker_game/src/com/pokergame/pokergame/CardImage/gif/x01.gif";
			}
		}
	}
}
	
