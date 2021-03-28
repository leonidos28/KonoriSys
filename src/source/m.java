package source;

import java.util.Scanner;

public class m {

	public static void saisieInfo() {
		String buffer;
		Coordinateur c = new Coordinateur();
		Scanner sc = new Scanner(System.in);

		System.out.println("veillez saisir:");

		System.out.println("Nom:");
		c.nom = sc.nextLine();

		System.out.println("Prénom:");
		c.prenom = sc.nextLine();

		System.out.println("Adresse Electronique:");
		c.adresseMail = sc.nextLine();

		System.out.println("Filliere:");
		c.nom = sc.nextLine();

		System.out.println("Choisissez un identifiant:");
		c.nom = sc.nextLine();

		System.out.println("Mot de passe:");
		c.motDePasse = sc.nextLine();

		System.out.println("Confirmer votre mot de passe:");
		buffer = sc.nextLine();

		if (c.motDePasse.equals(buffer)) {
			System.out.println("Matching Password");
		} else {
			System.out.println("ERROR Not mAtcHing");
		}
	}

}
