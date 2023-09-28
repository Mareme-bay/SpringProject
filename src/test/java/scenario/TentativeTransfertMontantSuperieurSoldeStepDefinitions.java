package scenario;

import io.bootify.wallet.util.NotFoundException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class TentativeTransfertMontantSuperieurSoldeStepDefinitions {

    private boolean compte1Existe;
    private boolean compte2Existe;
    private double soldeCompte1;
    private double soldeCompte2;
    private boolean exceptionSoldeInsuffisantLevee;

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

    @When("je tente de transférer {double} du compte {int} au compte {int}")
    public void jeTenteDeTransférerDuCompteAuCompte(Double montant, Integer compteSource, Integer compteDestination) {
        // Tente de transférer un montant supérieur au solde (vous devrez adapter cette logique à votre application)
        try {
            if (compte1Existe && compte2Existe) {
                if (compteSource == 1 && compteDestination == 2) {
                    if (montant > 0 && montant <= soldeCompte1) {
                        soldeCompte1 -= montant;
                        soldeCompte2 += montant;
                    } else {
                        throw new SoldeInsuffisantException("Le montant du transfert est supérieur au solde du compte source.");

                    }
                } else {
                    throw new IllegalArgumentException("Les comptes source et destination ne sont pas valides.");
                }
            } else {
                throw new NotFoundException("Certains comptes n'existent pas.");
            }
        } catch (SoldeInsuffisantException e) {
            exceptionSoldeInsuffisantLevee = true;
        } catch (Exception e) {
            // Gérer d'autres exceptions si nécessaire
        }
    }

    @Then("une exception SoldeInsuffisantException est levée")
    public void uneExceptionSoldeInsuffisantExceptionEstLevée() {
        // Vérifie si l'exception SoldeInsuffisantException a été levée
        assert exceptionSoldeInsuffisantLevee : "L'exception SoldeInsuffisantException n'a pas été levée.";
    }

    @And("la solde du compte {int} est de {double}")
    public void laSoldeDuCompteEstDe(Integer id, Double solde) {
        // Vérifie le solde du compte après le transfert
        if (id == 1) {
            assert soldeCompte1 == solde : "Le solde du compte 1 n'est pas correct après le transfert.";
        } else if (id == 2) {
            assert soldeCompte2 == solde : "Le solde du compte 2 n'est pas correct après le transfert.";
        }
    }

}
