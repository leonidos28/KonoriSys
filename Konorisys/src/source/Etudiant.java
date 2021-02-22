package source;

public class Etudiant {
	String nom;
	String prenom;
	String adresseMail;
	String motDePasse;
	int age;
	String filiere;
	String identifiant;

public Etudiant(String nom, String prenom) {
		setNom(nom);
		setPrenom(prenom);
		
	}

public Etudiant() {
	
	
}



public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getAdresseMail() {
	return adresseMail;
}

public void setAdresseMail(String adresseMail) {
	this.adresseMail = adresseMail;
}

public String getMotDePasse() {
	return motDePasse;
}

public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getFiliere() {
	return filiere;
}

public void setFiliere(String filiere) {
	this.filiere = filiere;
}

public String getIdentifiant() {
	return identifiant;
}

public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
}




@Override
public String toString() {
	return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", adresseMail=" + adresseMail + ", motDePasse=" + motDePasse
			+ ", age=" + age + ", filiere=" + filiere + ", identifiant=" + identifiant + "]";
}


}
