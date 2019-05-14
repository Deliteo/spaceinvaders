package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class Vaisseau extends Sprite {
	
	public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
		super(dimension, positionOrigine, vitesse);
	}

public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
	
	if (dimension.longueur()<dimensionMissile.longueur())
		throw new MissileException("La longueur du vaisseau est inférieure à la longueur du missile.");
		Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);
		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
	
	
		
	}

private Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
	int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
	int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

	int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
	Position positionOrigineMissile = new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
	return positionOrigineMissile;
}
}
