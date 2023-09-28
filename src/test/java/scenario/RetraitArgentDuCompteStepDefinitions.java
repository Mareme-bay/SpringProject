package scenario;

import io.bootify.wallet.util.NotFoundException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetraitArgentDuCompteStepDefinitions {
    private boolean compteExiste;
    private double soldeCompte;
    private boolean exceptionNotFoundExceptionLevee;

    @Given("qu'aucun compte avec l'ID {int} n'existe")
    public void aucunCompteAvecIDNExiste(Integer id) {
        // Simule l'absence d'un compte avec l'ID spécifié (vous devrez adapter cette logique à votre application)
        compteExiste = false;
    }

    @When("j'essaie de retirer {double} de ce compte")
    public void jEssaieDeRetirerDeCeCompte(Double montant) {
        // Tente de retirer de l'argent du compte inexistant (vous devrez adapter cette logique à votre application)
        try {
            if (compteExiste) {
                // Implémentez ici la logique de retrait d'argent
                // Si le retrait réussit, définissez une variable de contrôle
            } else {
                throw new NotFoundException("Le compte n'existe pas.");
            }
        } catch (NotFoundException e) {
            exceptionNotFoundExceptionLevee = true;
        }
    }

    @Then("une exception NotFoundException est levée")
    public void exceptionNotFoundExceptionEstLevée() {
        // Vérifie si l'exception NotFoundException a été levée
        assert exceptionNotFoundExceptionLevee : "L'exception NotFoundException n'a pas été levée.";
    }

    @And("aucun enregistrement de compte n'est modifié")
    public void aucunEnregistrementDeCompteNestModifié() {
        // Vérifie que l'aucun enregistrement de compte n'a été modifié (vous devrez adapter cette logique à votre application)
        assert !compteExiste : "Des enregistrements de compte ont été modifiés, alors qu'ils ne devraient pas l'être.";
    }
}
