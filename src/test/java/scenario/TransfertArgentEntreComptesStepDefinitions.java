package scenario;

import io.bootify.wallet.util.NotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransfertArgentEntreComptesStepDefinitions {
    private boolean compte1Existe;
    private boolean compte2Existe;
    private double soldeCompte1;
    private double soldeCompte2;

    @Given("le compte avec l'ID {int} existe avec un solde de {double}")
    public void leCompteAvecIDExisteAvecUnSolde(Integer id, Double solde) {
        // Simule l'existence des comptes avec les ID spécifiés et les soldes (vous devrez adapter cette logique à votre application)
        if (id == 1) {
            compte1Existe = true;
            soldeCompte1 = solde;
        } else if (id == 2) {
            compte2Existe = true;
            soldeCompte2 = solde;
        }
    }

    @When("je transfère {double} du compte {int} au compte {int}")
    public void jeTransfereDuCompteAuCompte(Double montant, Integer compteSource, Integer compteDestination) {
        // Effectue le transfert d'argent entre les comptes (vous devrez adapter cette logique à votre application)
        try {
            if (compte1Existe && compte2Existe) {
                if (compteSource == 1 && compteDestination == 2) {
                    if (montant > 0 && montant <= soldeCompte1) {
                        soldeCompte1 -= montant;
                        soldeCompte2 += montant;
                    } else {
                        throw new IllegalArgumentException("Le montant du transfert est invalide.");
                    }
                } else {
                    throw new IllegalArgumentException("Les comptes source et destination ne sont pas valides.");
                }
            } else {
                throw new NotFoundException("Certains comptes n'existent pas.");
            }
        } catch (Exception e) {
            // Gérer l'exception ici (par exemple, NotFoundException, IllegalArgumentException)
        }
    }

    @Then("la solde du compte {int} est de {double}")
    public void laSoldeDuCompteEstDe(Integer id, Double solde) {
        // Vérifie le solde mis à jour du compte après le transfert (vous devrez adapter cette logique à votre application)
        if (id == 1) {
            assert soldeCompte1 == solde : "Le solde du compte 1 n'est pas correct après le transfert.";
        } else if (id == 2) {
            assert soldeCompte2 == solde : "Le solde du compte 2 n'est pas correct après le transfert.";
        }
    }

}
