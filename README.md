CREATE TABLE AffectationStage(
    stage_id int NOT NULL,
    etudiant_id int NOT NULL,
    encadrant_id int NOT NULL,
    PRIMARY KEY(stage_id,etudiant_id,encadrant_id),
    FOREIGN KEY(stage_id) REFERENCES Stage(id),
    FOREIGN KEY(etudiant_id) REFERENCES Etudiant(id),
    FOREIGN KEY(encadrant_id) REFERENCES Encadrant(id)
    );

CREATE TABLE Stage(
    id int PRIMARY KEY AUTO_INCREMENT,
    entreprise varchar(100),
    sujet varchar(100),
    date_debut date,
    date_fin date
    );
    
CREATE TABLE Etudiant(
    id int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(50),
    prenom varchar(50),
    email varchar(50)
    );

CREATE TABLE Encadrant(
id int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(50),
    prenom varchar(50),
    email varchar(50)
    );

INSERT INTO `user` (`login`, `password`) VALUES ('amine', SHA1('123'));
    id int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(50),
    prenom varchar(50),
    email varchar(50)
    );
