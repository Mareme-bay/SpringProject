package io.bootify.wallet.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class DemandeAnnulation {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private Long idEmet;

    @Column(nullable = false)
    private Long idRecept;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    private String etatDemande;

    @Column(nullable = false)
    private OffsetDateTime heureDemande;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getIdEmet() {
        return idEmet;
    }

    public void setIdEmet(final Long idEmet) {
        this.idEmet = idEmet;
    }

    public Long getIdRecept() {
        return idRecept;
    }

    public void setIdRecept(final Long idRecept) {
        this.idRecept = idRecept;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(final Double montant) {
        this.montant = montant;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(final String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public OffsetDateTime getHeureDemande() {
        return heureDemande;
    }

    public void setHeureDemande(final OffsetDateTime heureDemande) {
        this.heureDemande = heureDemande;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
