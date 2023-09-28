package scenario;


import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.util.NotFoundException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class DepotArgentSurCompteStepDefinitions {
    private boolean compteExiste;
    private double soldeCompte;

    @When("le compte avec l'ID {int} existe")
    public void leCompteAvecIDExiste(Integer id) {
        // Simule l'existence du compte avec l'ID spécifié (vous devrez adapter cette logique à votre application)
        if (id == 1) {
            compteExiste = true;
            soldeCompte = 100.0;
        }
    }

    @And("le solde du compte avec l'ID {int} est de {double}")
    public void leSoldeDuCompteAvecIDEstDe(int id, double solde) {
        // Vérifie le solde du compte (vous devrez adapter cette logique à votre application)
        assert id == 1 && solde == soldeCompte : "Le solde du compte n'est pas correct.";
    }

    @When("je dépose {double} sur le compte avec l'ID {int}")
    public void jeDeposeSurLeCompteAvecID(Double montant, Integer id) {
        // Effectue le dépôt sur le compte (vous devrez adapter cette logique à votre application)
        if (compteExiste && id == 1) {
            soldeCompte += montant;
        }
    }

    @Then("le solde du compte avec l'ID {int} est de {double}")
    public void leSoldeDuCompteAvecIDEstDe(Integer id, Double solde) {
        // Vérifie le solde mis à jour du compte après le dépôt (vous devrez adapter cette logique à votre application)
        assert id == 1 && solde == soldeCompte : "Le solde du compte n'est pas correct après le dépôt.";
    }


}
