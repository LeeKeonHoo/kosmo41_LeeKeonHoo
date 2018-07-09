package com.study.pattern.stretegy2;

public class Main {

	public static void main(String[] args) {
		GameCharactor character = new GameCharactor();
		character.fire();
		
		character.setWeapon(new Arrow());
		character.fire();
		
		character.setWeapon(new Bullet());
		character.fire();

		character.setWeapon(new Missile());
		character.fire();

	}
}