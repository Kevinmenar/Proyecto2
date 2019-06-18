package model;

public class CharacterFactory implements AbstractFactory {
	public Character factoryMethod(String pName, Element pElement, Element pWeekness) {
		return new Character(pName, pElement, pWeekness);
	};
}
