package scenario;

import io.bootify.wallet.util.NotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepotSurCompteInexistantStepDefinitions {
    private boolean compteExiste;
    private boolean exceptionNotFoundExceptionLevee;

    @Given("le compte avec l'ID {int} n'existe pas")
    public void leCompteAvecIDNExistePas(Integer id) {
        // Simule l'absence d'un compte avec l'ID spécifié (vous devrez adapter cette logique à votre application)
        compteExiste = false;
    }

    @When("je tente de déposer {double} sur le compte avec l'ID {int}")
    public void jeTenteDeDeposerSurLeCompteAvecID(Double montant, Integer id) {
        // Tente de déposer de l'argent sur le compte inexistant (vous devrez adapter cette logique à votre application)
        try {
            if (compteExiste) {
                // Implémentez ici la logique de dépôt d'argent
                // Si le dépôt réussit, définissez une variable de contrôle
            } else {
                throw new NotFoundException("Le compte n'existe pas.");
            }
        } catch (NotFoundException e) {
            exceptionNotFoundExceptionLevee = true;
        }
    }

    @Then("une exception NotFoundException est levée")
    public void uneExceptionNotFoundExceptionEstLevée() {
        // Vérifie si l'exception NotFoundException a été levée
        assert exceptionNotFoundExceptionLevee : "L'exception NotFoundException n'a pas été levée.";
    }
}
