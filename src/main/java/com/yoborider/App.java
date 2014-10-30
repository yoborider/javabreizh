package com.yoborider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void processPersons(List<Person> persons,
			Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : persons) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("Thomas", 19);
		Person p2 = new Person("Paul", 25);

		List<Person> persons = new ArrayList<>();

		persons.add(p1);
		persons.add(p2);

		Predicate<Person> plusVieuxQue = (p) -> {
			return p.getAge() >= 20;
		};
		Predicate<Person> plusJeuneQue = (p) -> {
			return p.getAge() < 20;
		};

		Consumer<Person> afficherPerson = (p) -> {
			p.printPerson();
		};
		Consumer<Person> ajouterUnAn = (p) -> {
			p.setAge(p.getAge() + 1);
		};


		System.out.println("Qui a plus de 20 ans ?");
		processPersons(persons, plusVieuxQue, afficherPerson);

		System.out.println("Qui a strictement moins de 20 ans ?");
		processPersons(persons, plusJeuneQue, afficherPerson);

		System.out.println("Les plus jeunes que 20 ans grandissent d'un an ...") ;
		processPersons(persons, plusJeuneQue, ajouterUnAn);

		System.out.println("Et maintenant, qui a plus de 20 ans ?");
		processPersons(persons, plusVieuxQue, afficherPerson);

	}
}
