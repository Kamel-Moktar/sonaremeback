package sonaremettakwine.commercial.dao.benifit;

import java.math.BigDecimal;

public enum  Tva {
     NORMAL(new BigDecimal("0.19"),  "TVA normale"),
     REDUITE(new BigDecimal("0.09"), "Tva réduite");
    private final BigDecimal taux;
    private final String libelle;

    Tva(BigDecimal taux, String libelle) {
        this.taux = taux;
        this.libelle = libelle;
    }

    public BigDecimal getTaux() {
        return this.taux;
    }

    public String getLibelle() {
        return this.libelle;
    }

}

