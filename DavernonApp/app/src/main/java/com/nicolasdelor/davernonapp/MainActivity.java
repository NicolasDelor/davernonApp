package com.nicolasdelor.davernonapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Card> cardList = new ArrayList<Card>();

    private ListView listView;

    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;

    private boolean ifConcentrationButton = false;
    private boolean ifPacifiqueButton = false;
    private boolean ifBalancedButton = false;
    private boolean ifFureurButton = false;
    private boolean ifSournoiserieButton = false;

    private boolean ifADistance = false;
    private boolean ifAuContact = false;
    private boolean ifDebout = false;
    private boolean ifMaintenuAuSol = false;
    private boolean ifMaintenantAuSol = false;
    private boolean ifAGenoux = false;
    private boolean ifMaintenuDeDos = false;
    private boolean ifMaintenantDeDos = false;
    private boolean ifAuSol = false;
    private boolean ifEntrave = false;


    ImageView sournoiserieImage;
    ImageView fureurImage;
    ImageView balanceImage;
    ImageView pacifiqueImage;
    ImageView concentrationImage;

    ImageView aDistanceImage;
    ImageView auContactImage;
    ImageView deboutImage;
    ImageView maintenuAuSolImage;
    ImageView maintenantAuSolImage;
    ImageView aGenouxImage;
    ImageView maintenuDeDosImage;
    ImageView maintenantDeDosImage;
    ImageView auSolImage;
    ImageView entraveImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSearchWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void initSearchWidgets() {


        concentrationImage = (ImageView) findViewById(R.id.concentrationFilter);
        concentrationImage.setImageResource(R.drawable.concentration);

        pacifiqueImage = (ImageView) findViewById(R.id.pacifiqueFilter);
        pacifiqueImage.setImageResource(R.drawable.pacifism);

        balanceImage = (ImageView) findViewById(R.id.balancedFilter);
        balanceImage.setImageResource(R.drawable.balance);

        fureurImage = (ImageView) findViewById(R.id.fureurFilter);
        fureurImage.setImageResource(R.drawable.fureur);

        sournoiserieImage = (ImageView) findViewById(R.id.sournoiserieFilter);
        sournoiserieImage.setImageResource(R.drawable.sournoiserie);

        // Stance

        aDistanceImage = (ImageView) findViewById(R.id.aDistanceFilter);
        aDistanceImage.setImageResource(R.drawable.adistance);

        auContactImage = (ImageView) findViewById(R.id.auContactFilter);
        auContactImage.setImageResource(R.drawable.aucontact);

        deboutImage = (ImageView) findViewById(R.id.deboutFilter);
        deboutImage.setImageResource(R.drawable.debout);

        maintenuAuSolImage = (ImageView) findViewById(R.id.maintenuAuSolFilter);
        maintenuAuSolImage.setImageResource(R.drawable.maintenuausol);

        maintenantAuSolImage = (ImageView) findViewById(R.id.maintenantAuSolFilter);
        maintenantAuSolImage.setImageResource(R.drawable.maintenantausol);

        aGenouxImage = (ImageView) findViewById(R.id.aGenouxFilter);
        aGenouxImage.setImageResource(R.drawable.agenoux);

        maintenuDeDosImage = (ImageView) findViewById(R.id.maintenuDeDosFilter);
        maintenuDeDosImage.setImageResource(R.drawable.maintenudedos);

        maintenantDeDosImage = (ImageView) findViewById(R.id.maintenantDeDosFilter);
        maintenantDeDosImage.setImageResource(R.drawable.maintenantdedos);

        auSolImage = (ImageView) findViewById(R.id.auSolFilter);
        auSolImage.setImageResource(R.drawable.ausol);

        entraveImage = (ImageView) findViewById(R.id.entraveFilter);
        entraveImage.setImageResource(R.drawable.entrave);


        searchView = (SearchView) findViewById(R.id.cardListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentSearchText = s;
                ArrayList<Card> filteredCards = new ArrayList<Card>();

                for (Card card : cardList) {
                    if (card.getmName().toLowerCase().contains(s.toLowerCase())) {
                        if (selectedFilter.equals("all")) {
                            filteredCards.add(card);
                        } else {
                            if (card.getmName().toLowerCase().contains(selectedFilter)) {
                                filteredCards.add(card);
                            }
                        }
                    }
                }
                CardAdapter adapter = new CardAdapter(getApplicationContext(), 0, filteredCards);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }

    private void setupData() {

        // SetUp Stance
        Stance aDistance = new Stance(1, "A distance", R.drawable.adistance);
        Stance auContact = new Stance(2, "Au contact", R.drawable.aucontact);
        Stance debout = new Stance(3, "Debout", R.drawable.debout);

        Stance maintenuAuSol = new Stance(4, "Maintennu au sol", R.drawable.maintenuausol);
        Stance maintenantAuSol = new Stance(5, "Maintenant au sol", R.drawable.maintenantausol);
        Stance aGenoux = new Stance(6, "A genoux", R.drawable.agenoux);

        Stance maintenuDeDos = new Stance(7, "Maintennu de dos", R.drawable.maintenudedos);
        Stance maintenantDeDos = new Stance(8, "Maintenant de dos", R.drawable.maintenantdedos);

        Stance auSol = new Stance(9, "Au sol", R.drawable.ausol);
        Stance entrave = new Stance(10, "Entrave", R.drawable.entrave);

        // SetUp MindSet
        MindSet mPacifique = new MindSet(0, "Pacifique", R.drawable.pacifism);
        MindSet mConcentration = new MindSet(1, "Concentration", R.drawable.concentration);
        MindSet mBalance = new MindSet(2, "Balanced", R.drawable.balance);
        MindSet mFureur = new MindSet(3, "Fureur", R.drawable.fureur);
        MindSet mSournoiserie = new MindSet(4, "Sournoiserie", R.drawable.sournoiserie);

        // Card


        Card attenteSalvatrice = new Card(
                "0",
                "Attente salvatrice",
                0,
                0,
                "Vous récupérez 6 points de Stamina",
                "Vous récupérez 12 points de Stamina",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, auSol, entrave},
                new MindSet[]{mConcentration, mPacifique, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card briseCrane = new Card(
                "2",
                "Brise Crâne",
                11,
                0,
                "Infligez 20 points de dégâts.",
                "Infligez 20 points de dégâts. Votre adversaire perd 8 points de Stamina.",
                new Stance[]{auContact, debout},
                new MindSet[]{mFureur},
                R.drawable.brisecrane_vert_bax);

        Card briserLintimite = new Card(
                "3",
                "Briser L'intimité",
                5,
                0,
                "Infligez 15 points de dégâts. Placez un marqueur humiliation sur votre adversaire.",
                "Infligez 15 points de dégâts. Placez un marqueur humiliation et un étourdissement sur votre adversaire, il passe en Stance Au Sol.",
                new Stance[]{auContact, debout, maintenantAuSol, aGenoux},
                new MindSet[]{mSournoiserie},
                R.drawable.briser_intimite_vert_bax);
        Card briserSesFers = new Card(
                "4",
                "Briser ses fers",
                10,
                0,
                "Vous et votre adversaire passez en Stance Debout.",
                "Vous et votre adversaire passez en stance DEbout. Infligez 9 points de dégâts.",
                new Stance[]{maintenantAuSol, maintenantDeDos, entrave},
                new MindSet[]{mConcentration, mFureur, mBalance},
                R.drawable.retraite_vert_bax);
        Card changementDeStrategie = new Card(
                "5",
                "Changement de Stratégie",
                3,
                -1,
                "Changez obligatoirement de Mindset.",
                "Changez obligatoirement de Mindset. Votre action du prochain tour a un bonus de +2 en vitesse.",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, auSol, entrave},
                new MindSet[]{mConcentration, mPacifique, mBalance, mSournoiserie},
                R.drawable.chang_strategie_vert_bax);
        Card crachat = new Card(
                "6",
                "Crachat",
                0,
                0,
                "Placez un marqueur humiliation sur votre adversaire. Cette action échoue si votre adversaire a changé de Stance pendant ce tour.",
                "Placez un marqueur humiliation sur votre adversaire.",
                new Stance[]{auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, entrave},
                new MindSet[]{mSournoiserie},
                R.drawable.crachat_vert_bax);
        Card decollageImminent = new Card(
                "7",
                "Decollage Imminent",
                7,
                2,
                "Passez immédiatement en Stance Debout. Si vous étiez Maintenu au Sol, n'effectuez cette action que si vous battez votre adversaire à un jeté de d6. il passe alors en Stance Debout.",
                "Passez immédiatement en Stance Debout. Si vous étiez Maintenu au Sol, votre adversaire passe en stance Debout. Votre action du prochain tour a un bonus de +2 en vitesse.",
                new Stance[]{maintenuAuSol, auSol},
                new MindSet[]{mConcentration, mPacifique, mFureur, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card engagement = new Card(
                "8",
                "Engagement",
                6,
                1,
                "Vous et votre adversaire passez en Stance Au Contact.  vous ne pouvez changer de Stance jusqu'à la fin du prochain tour.",
                "Infligez 7 points de dégâts. Vous et votre adversaire passez en Stance Au Contact. Vous ne pouvez changer de Stance jusqu'à la fin du prochain tour.",
                new Stance[]{aDistance, debout},
                new MindSet[]{mConcentration, mFureur, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card feindrePourRenverser = new Card(
                "9",
                "Feindre pour renverser",
                4,
                0,
                "Votre adversaire passe en Stance Au Sol. Vous passez en sTance Debout.",
                "Votre adversaire passe en Stance Au Sol. Vous passez en Stance Debout. Votre adversaire ne peut changer de Stance jusqu'à la fin du prochain tour.",
                new Stance[]{auContact, debout, maintenuAuSol, aGenoux, auSol},
                new MindSet[]{mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card frappeBasique = new Card(
                "10",
                "Frappe Basique",
                6,
                1,
                "Infligez 8 points de dégâts.",
                "Infligez 12 points de dégâts.",
                new Stance[]{auContact, debout, maintenuAuSol, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mConcentration, mFureur, mBalance},
                R.drawable.frappe_simple_vert_bax);
        Card frapperPourTuer = new Card(
                "11",
                "Frapper pour Tuer (Finisher)",
                4,
                2,
                "Si votre adervsaire a 0 pdv, vous le tuez. De manière violente. Finisher.",
                "Si votre adversaire a 0 pdv, vous le tuez. De manière violente. Ignorez le coût en Stamina. Finisher.",
                new Stance[]{auContact, debout, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mFureur, mBalance},
                R.drawable.retraite_vert_bax);
        Card fuiteTactique = new Card(
                "12",
                "Fuite Tactique",
                7,
                3,
                "Vous et votre adversaire passez en Stance A Distance.",
                "Vous et votre adversaire passez en Stance A Distance. Vous pouvez changer de Mindset.",
                new Stance[]{auContact, debout,},
                new MindSet[]{mConcentration, mPacifique, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card laceration = new Card(
                "13",
                "Lacération",
                8,
                1,
                "Infligez 4 points de dégâts. Placez un marqueur Plaie sur votre adversaire.",
                "Infligez 4 points de dégâts. Placez un marqueur Plaie sur votre adversaire. Il ne peut déclarer d'action infligeant des dégâts au prochain tour.",
                new Stance[]{auContact, debout, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mConcentration, mFureur, mBalance},
                R.drawable.retraite_vert_bax);
        Card libererSaProie = new Card(
                "14",
                "Libérer sa proie",
                3,
                -1,
                "Vous passez en Stance Debout. Votre adversaire passe en Stance Debout s'il était Maintenu de Dos et Au Sol s'il était Maintenu au Sol.",
                "Vous passez en Stance Debout. Votre adversaire prends un marqueur humiliation et passe en Stance Debout s'il était Maintenu de Dos et Au Sol s'il était Maintenu au Sol.",
                new Stance[]{maintenantAuSol, maintenantDeDos},
                new MindSet[]{mConcentration, mPacifique, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card maitriseTotale = new Card(
                "15",
                "Maitrise Totale (Finisher)",
                2,
                0,
                "Si votre adversaire a moins de 10 pdv et ne vous a pas infligé de dégâts depuis deux actions, vous le mettez hors d'état de nuire. Finisher. Si cette compétence échoue, elle n'est plus utilisable pendant 3 tours",
                "Si votre adversaire a moins de la moitié de ses pdv et ne vous a pas infligé de dégâts depuis deux actions, vous le mettez hors d'état de nuire. Finisher.",
                new Stance[]{auContact, debout, maintenantAuSol, aGenoux, maintenantDeDos},
                new MindSet[]{mConcentration, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card maitriserLaBete = new Card(
                "16",
                "Maîtriser la bête",
                7,
                -1,
                "Votre adversaire passe en Maintenu au Sol s'il était à Genoux Au Sol, Maintenu de Dos ou Entravé, et Maintenu de Dos dans le cas contraire.",
                "Votre adversaire passe en Maintenu au Sol. Il perd 5 points de Stamina.",
                new Stance[]{auContact, debout, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mConcentration, mPacifique, mFureur, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);

        Card meurtrirLego = new Card(
                "17",
                "Meurtrir l'Ego",
                2,
                0,
                "Placez un marqueur humiliation sur votre adversaire. Vous passez en Mindset Balanced.",
                "Placez un marqueur humiliation sur votre adversaire. S'il le peut, il est obligé d'annoncer une action infligeant des dégâts au prochain tour.",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, auSol, entrave},
                new MindSet[]{mPacifique, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card planifier = new Card(
                "18",
                "Planifier",
                2,
                -2,
                "Votre action du prochain tour a un bonus de +5 en vitesse.",
                "Votre action du prochain tour a un bonus de +5 en vitesse et votre adversaire doit annoncer son action avant que vous ne choisissiez la votre.",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, auSol, entrave},
                new MindSet[]{mConcentration},
                R.drawable.retraite_vert_bax);
        Card prendreDeLaDistance = new Card(
                "19",
                "Prendre de la distance",
                5,
                0,
                "Vous et votre adversaire passez en Stance A Distance.",
                "Vous et votre adversaire passez en Stance A Distance. Regagnez 5 points de Stamina.",
                new Stance[]{auContact, debout},
                new MindSet[]{mConcentration, mPacifique, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card provoquerLeDesir = new Card(
                "20",
                "Provoquer le désir",
                5,
                0,
                "Cette action ne peut être utilisée que si vous êtes compatible avec les intérêts amoureux de votre adversaire. Choisissez sa prochaine action (qui doit être utliséee, ne pas produire un 'ne peut pas jouer').",
                "Cette action ne peut être utilisée que si vous êtes compatible avec les intérêts amoureux de votre adversaire. Changez votre Stance et celle de votre adversaire.",
                new Stance[]{auContact, debout, maintenuAuSol, aGenoux},
                new MindSet[]{mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card reprendreSonSouffle = new Card(
                "21",
                "Reprendre son souffle",
                0,
                0,
                "Regagnez 4 points de Stamina et passez en Mindset Balanced.",
                "Regagnez 8 points de Stamina et passez en Mindset Balanced.",
                new Stance[]{aDistance, auContact, debout, aGenoux, auSol, entrave},
                new MindSet[]{mConcentration, mPacifique, mBalance, mSournoiserie},
                R.drawable.souffle_vert_bax);
        Card repriseDappuis = new Card(
                "22",
                "Reprise d'appuis",
                2,
                -1,
                "Vous passez en Stance Debout.",
                "Vous passez en Stance Debout. Vous pouvez changer de Mindset si vous le désirez.",
                new Stance[]{aGenoux},
                new MindSet[]{mConcentration, mPacifique, mFureur, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card seDebattre = new Card(
                "23",
                "Se débattre",
                4,
                0,
                "Si vous gagnez strictement un lancer de d6 contre votre adversaire, passez tous les deux en Stance debout.",
                "Si vous gagnez un lancer de d6 contre votre adversaire, passez tous les deux en Stance debout. Placez un jeton étourdissement sur votre adversaire.",
                new Stance[]{maintenuAuSol, maintenuDeDos, entrave},
                new MindSet[]{mConcentration, mPacifique, mFureur, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card seRelever = new Card(
                "24",
                "Se relever",
                3,
                -1,
                "Passez immédiatement en Stance A Genoux. Si vous étiez Maintenu au Sol, n'effectuez cette action que si vous battez votre adversaire à un jeté de d6. Il passe alors en Stance Debout.",
                "Passez immédiatement en Stance Debout. Si vous étiez Maintenu au Sol, passez en Stance A Genoux à la place. Votre adversaire passe en Stance Debout.",
                new Stance[]{maintenuAuSol, auSol},
                new MindSet[]{mConcentration, mPacifique, mFureur, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card soumission = new Card(
                "25",
                "Soumission",
                0,
                0,
                "Placez un marqueur humiliation sur vous. Votre action du prochain tour a +2 en vitesse. Ne placez pas de marqueur si vous êtes en Sournoiserie.",
                "Placez un marqueur humiliation sur vous et votre adversaire. Ne placez pas de marqueur si vous êtes en Sournoiserie.",
                new Stance[]{maintenuAuSol, aGenoux, maintenuDeDos, auSol, entrave},
                new MindSet[]{mPacifique, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card tenirSaPosition = new Card(
                "26",
                "Tenir sa Position",
                0,
                2,
                "Regagnez 2 points de Stamina. Les dégâts pris sur ce tour sont réduits de moitié (quart pour concentration).",
                "Regagnez 5 points de Stamina. Les dégâts pris sur ce tour réduits de moitié (quart pour concentration).",
                new Stance[]{aDistance, auContact, debout},
                new MindSet[]{mConcentration, mBalance},
                R.drawable.retraite_vert_bax);
        Card trebucher = new Card(
                "27",
                "Trébucher",
                6,
                -2,
                "Vous passez en Stance Au Sol. Vous ne pouvez pas changer de Mindset jusqu'à la fin du prochain tour.",
                "Vous passez en Stance Au Sol. Vous ne pouvez pas changer de Mindset jusqu'à la fin du prochain tour. voitre action du prochain tour a un bonus de +2 en vitesse.",
                new Stance[]{auContact, debout, aGenoux},
                new MindSet[]{mConcentration, mBalance, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card treve = new Card(
                "28",
                "Trêve (Finisher)",
                1,
                -2,
                "Vous et votre adversaire ne recevez aucun dommage jusqu'à la fin du prochain tour.",
                "Si votre adversaire a 5 marqueurs identiques, vous stoppez ce combat, d'un commun accord. Finisher",
                new Stance[]{aDistance, auContact, debout, aGenoux, auSol},
                new MindSet[]{mPacifique},
                R.drawable.retraite_vert_bax);
        Card uppercutVengeur = new Card(
                "29",
                "Uppercut Vengeur",
                6,
                0,
                "Infligez 13 points de dégâts. Vous passez en stance Debout et votre adversaire en Stance au Sol.",
                "infligez 13 points de dégâts. Vous passez en sTance Debout et votre adversaire en Stance au Sol. Vous pouvez changer de Mindset si vous le souhaitez.",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, aGenoux, auSol},
                new MindSet[]{mFureur},
                R.drawable.retraite_vert_bax);
        Card viserLaOuCaFaitMal = new Card(
                "30",
                "Viser là où ça fait mal",
                9,
                1,
                "Infligez 12 points de dégâts.",
                "Infligez 12 points de dégâts. Placez un marqueur étourdissement sur votre adversaire.",
                new Stance[]{auContact, debout, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mFureur, mBalance},
                R.drawable.retraite_vert_bax);
        Card masochisme = new Card(
                "31",
                "Masochisme",
                2,
                -3,
                "Si vous avez reçu des dégâts pendant ce tourn reprenez votre Mindset de début de tour. Il ne peut pas changer pour les 3 prochains tours.",
                "Si vous avez reçu des dégâts pendant ce tourn reprenez votre Mindset de début de tour. Il ne peut pas changer pour les 5 prochains tours.",
                new Stance[]{auContact, debout, maintenuAuSol, aGenoux, maintenuDeDos, auSol, entrave},
                new MindSet[]{mFureur, mConcentration},
                R.drawable.retraite_vert_bax);
        Card provoquerLaColere = new Card(
                "32",
                "Provoquer la colère",
                3,
                -2,
                "Votre adversaire doit, si ses conditions le permettent, déclarer une action infligeant des dégâts au prochain tour.",
                "Votre adversaire passe immédiatement en Mindset de Fureur.",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, auSol, entrave},
                new MindSet[]{mConcentration, mBalance, mFureur, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card analyserLeComportement = new Card(
                "33",
                "Analyser le comportement",
                4,
                -3,
                "Si la compétence de votre adversaire a été effectuée ce tour, il ne peut plus l'utiliser pendant 6 tours",
                "Si la compétence de votre adversaire a été effectuée ce tour, il ne peut plus l'utiliser pendant 6 tours",
                new Stance[]{aDistance, auContact, debout, maintenuAuSol, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, auSol, entrave},
                new MindSet[]{mPacifique, mConcentration, mSournoiserie},
                R.drawable.retraite_vert_bax);
        Card degainerSaLame = new Card(
                "34",
                "Dégainer sa lame",
                4,
                1,
                "Si votre personnage possède une lame, il peut désormais l'utiliser lors du combat.",
                "Si votre personnage possède une lame, il peut désormais l'utiliser lors du combat. Inflige 12 points de dégâts.",
                new Stance[]{auContact, debout, auSol},
                new MindSet[]{mBalance, mSournoiserie, mFureur},
                R.drawable.retraite_vert_bax);
        Card poignarder = new Card(
                "35",
                "Poignarder",
                6,
                1,
                "Ne peut être utilise que si vous avez une lame courte. Inflige 15 points de dégâts.",
                "Ne peut être utilise que si vous avez une lame courte. Inflige 15 points de dégâts. Placez deux marqueurs saignements sur l'adversaire.",
                new Stance[]{auContact, debout, maintenantAuSol, aGenoux, maintenantDeDos},
                new MindSet[]{mSournoiserie, mFureur},
                R.drawable.retraite_vert_bax);
        Card lancerDePoignard = new Card(
                "36",
                "Lancer de poignard",
                7,
                0,
                "Ne peut être utilise que si vous avez une lame courte. Inflige 15 points de dégâts. Placez deux marqueurs saignements sur l'adversaire.",
                "Ne peut être utilise que si vous avez une lame courte. Inflige 15 points de dégâts. Placez deux marqueurs saignements sur l'adversaire. Il passe en Stance Au Sol et vous en Stance Debout.",
                new Stance[]{debout, aDistance},
                new MindSet[]{mConcentration, mBalance, mFureur},
                R.drawable.retraite_vert_bax);
        Card perseverence = new Card(
                "37",
                "Persévérence",
                5,
                2,
                "La prochaine compétence l'infligeant pas de dégâts que vous effectuez se réeffectuera au tour suivant (en plus de la compétence de ce tour-là).",
                "La prochaine compétence l'infligeant pas de dégâts que vous effectuez se réeffectuera au tour suivant (en plus de la compétence de ce tour-là). Vous pouvez changer de Mindset immédiatement.",
                new Stance[]{aDistance, auContact, debout, maintenantAuSol, aGenoux, maintenuDeDos, maintenantDeDos, entrave},
                new MindSet[]{mPacifique, mConcentration, mBalance},
                R.drawable.retraite_vert_bax);
        Card priseDInitiative = new Card(
                "38",
                "Prise d'initiative",
                3,
                -2,
                "Votre prochaine compétence effectuée se déroulera avant celle de l'adversaire, en ignorant les statistique de vitesse.",
                "Votre prochaine compétence effectuée se déroulera avant celle de l'adversaire, en ignorant les statistique de vitesse. Vous pouvez changer de Mindset gratuitement après le choix de la prochaine compétence.",
                new Stance[]{aDistance, auContact, debout, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mPacifique, mConcentration},
                R.drawable.retraite_vert_bax);
        Card Délayer = new Card(
                "39",
                "Délayer",
                4,
                -1,
                "Votre prochaine compétence effectuée peut être annulée pour être effectuée à un autre tour (en plus de la compétence de ce tour là).",
                "La prochaine compétence effectuée de votre adversaire est annulée pour être effectuée à un autre tour en ignorant les conditions d'activation (maximum 5 tours plus tard).",
                new Stance[]{aDistance, auContact, debout, maintenantAuSol, maintenantDeDos},
                new MindSet[]{mPacifique, mConcentration},
                R.drawable.retraite_vert_bax);

        cardList.add(attenteSalvatrice);
        cardList.add(briseCrane);
        cardList.add(briserLintimite);
        cardList.add(briserSesFers);
        cardList.add(changementDeStrategie);
        cardList.add(crachat);
        cardList.add(decollageImminent);
        cardList.add(engagement);
        cardList.add(feindrePourRenverser);
        cardList.add(frappeBasique);
        cardList.add(frapperPourTuer);
        cardList.add(fuiteTactique);
        cardList.add(laceration);
        cardList.add(libererSaProie);
        cardList.add(maitriseTotale);
        cardList.add(maitriserLaBete);
        cardList.add(meurtrirLego);
        cardList.add(planifier);
        cardList.add(prendreDeLaDistance);
        cardList.add(provoquerLeDesir);
        cardList.add(reprendreSonSouffle);
        cardList.add(repriseDappuis);
        cardList.add(seDebattre);
        cardList.add(seRelever);
        cardList.add(soumission);
        cardList.add(tenirSaPosition);
        cardList.add(trebucher);
        cardList.add(treve);
        cardList.add(uppercutVengeur);
        cardList.add(viserLaOuCaFaitMal);

        cardList.add(masochisme);
        cardList.add(provoquerLaColere);
        cardList.add(analyserLeComportement);
        cardList.add(degainerSaLame);
        cardList.add(poignarder);
        cardList.add(lancerDePoignard);
        cardList.add(perseverence);
        cardList.add(priseDInitiative);
        cardList.add(Délayer);

    }

    private void setUpList() {
        listView = (ListView) findViewById(R.id.cardsListView);

        CardAdapter adapter = new CardAdapter(getApplicationContext(), 0, cardList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Card selectCard = (Card) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailCard.class);
                showDetail.putExtra("id", selectCard.getId());
                startActivity(showDetail);
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void filterList() {
        ArrayList<Card> filteredCards = (ArrayList<Card>) cardList.clone();

        if (ifPacifiqueButton) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmMindSets()).anyMatch(mindSet -> mindSet.mId == 0));
        }
        if (ifConcentrationButton) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmMindSets()).anyMatch(mindSet -> mindSet.mId == 1));
        }
        if (ifBalancedButton) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmMindSets()).anyMatch(mindSet -> mindSet.mId == 2));
        }
        if (ifFureurButton) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmMindSets()).anyMatch(mindSet -> mindSet.mId == 3));
        }
        if (ifSournoiserieButton) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmMindSets()).anyMatch(mindSet -> mindSet.mId == 4));
        }

        // Stance
        if (ifADistance) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 1));
        }
        if (ifAuContact) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 2));
        }
        if (ifDebout) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 3));
        }
        if (ifMaintenuAuSol) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 4));
        }
        if (ifMaintenantAuSol) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 5));
        }
        if (ifAGenoux) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 6));
        }
        if (ifMaintenuDeDos) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 7));
        }
        if (ifMaintenantDeDos) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 8));
        }
        if (ifAuSol) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 9));
        }
        if (ifEntrave) {
            filteredCards.removeIf(card -> !Arrays.stream(card.getmStances()).anyMatch(stance -> stance.mId == 10));
        }


        CardAdapter adapter = new CardAdapter(getApplicationContext(), 0, filteredCards);

        listView.setAdapter(adapter);
        setMindSetImage();
        setStanceImage();
    }

    private void setStanceImage() {
        if (!ifADistance) {
            aDistanceImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            aDistanceImage.setColorFilter(null);
        }

        if (!ifAuContact) {
            auContactImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            auContactImage.setColorFilter(null);
        }

        if (!ifDebout) {
            deboutImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            deboutImage.setColorFilter(null);
        }

        if (!ifMaintenuAuSol) {
            maintenuAuSolImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            maintenuAuSolImage.setColorFilter(null);
        }

        if (!ifMaintenantAuSol) {
            maintenantAuSolImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            maintenantAuSolImage.setColorFilter(null);
        }

        if (!ifAGenoux) {
            aGenouxImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            aGenouxImage.setColorFilter(null);
        }

        if (!ifMaintenuDeDos) {
            maintenuDeDosImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            maintenuDeDosImage.setColorFilter(null);
        }

        if (!ifMaintenantDeDos) {
            maintenantDeDosImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            maintenantDeDosImage.setColorFilter(null);
        }

        if (!ifAuSol) {
            auSolImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            auSolImage.setColorFilter(null);
        }

        if (!ifEntrave) {
            entraveImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            entraveImage.setColorFilter(null);
        }

        if (!ifADistance && !ifAuContact && !ifDebout && !ifMaintenuAuSol && !ifMaintenantAuSol &&
                !ifAGenoux && ifMaintenuDeDos && ifMaintenantDeDos && ifAuSol && ifEntrave) {
            aDistanceImage.setColorFilter(null);
            auContactImage.setColorFilter(null);
            deboutImage.setColorFilter(null);
            maintenuAuSolImage.setColorFilter(null);
            maintenantAuSolImage.setColorFilter(null);
            aGenouxImage.setColorFilter(null);
            maintenuDeDosImage.setColorFilter(null);
            maintenantDeDosImage.setColorFilter(null);
            auSolImage.setColorFilter(null);
            entraveImage.setColorFilter(null);
        }
        if (ifSournoiserieButton && ifPacifiqueButton && ifConcentrationButton && ifBalancedButton && ifFureurButton) {
            aDistanceImage.setColorFilter(R.color.design_default_color_on_error);
            auContactImage.setColorFilter(R.color.design_default_color_on_error);
            deboutImage.setColorFilter(R.color.design_default_color_on_error);
            maintenuAuSolImage.setColorFilter(R.color.design_default_color_on_error);
            maintenantAuSolImage.setColorFilter(R.color.design_default_color_on_error);
            aGenouxImage.setColorFilter(R.color.design_default_color_on_error);
            maintenuDeDosImage.setColorFilter(R.color.design_default_color_on_error);
            maintenantDeDosImage.setColorFilter(R.color.design_default_color_on_error);
            auSolImage.setColorFilter(R.color.design_default_color_on_error);
            entraveImage.setColorFilter(R.color.design_default_color_on_error);
        }
    }

    private void setMindSetImage() {
        if (!ifSournoiserieButton) {
            sournoiserieImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            sournoiserieImage.setColorFilter(null);
        }

        if (!ifPacifiqueButton) {
            pacifiqueImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            pacifiqueImage.setColorFilter(null);
        }

        if (!ifConcentrationButton) {
            concentrationImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            concentrationImage.setColorFilter(null);
        }

        if (!ifBalancedButton) {
            balanceImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            balanceImage.setColorFilter(null);
        }
        if (!ifFureurButton) {
            fureurImage.setColorFilter(R.color.design_default_color_on_error);
        } else {
            fureurImage.setColorFilter(null);
        }
        if (!ifSournoiserieButton && !ifPacifiqueButton && !ifConcentrationButton && !ifBalancedButton && !ifFureurButton) {
            sournoiserieImage.setColorFilter(null);
            pacifiqueImage.setColorFilter(null);
            concentrationImage.setColorFilter(null);
            balanceImage.setColorFilter(null);
            fureurImage.setColorFilter(null);
        }
        if (ifSournoiserieButton && ifPacifiqueButton && ifConcentrationButton && ifBalancedButton && ifFureurButton) {
            sournoiserieImage.setColorFilter(R.color.design_default_color_on_error);
            pacifiqueImage.setColorFilter(R.color.design_default_color_on_error);
            concentrationImage.setColorFilter(R.color.design_default_color_on_error);
            balanceImage.setColorFilter(R.color.design_default_color_on_error);
            fureurImage.setColorFilter(R.color.design_default_color_on_error);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void allFilterMindSetTapped(View view) {
        if (ifBalancedButton && ifFureurButton && ifConcentrationButton && ifPacifiqueButton && ifSournoiserieButton) {

            ifBalancedButton = false;
            ifFureurButton = false;
            ifConcentrationButton = false;
            ifPacifiqueButton = false;
            ifSournoiserieButton = false;
        } else {
            ifBalancedButton = true;
            ifFureurButton = true;
            ifConcentrationButton = true;
            ifPacifiqueButton = true;
            ifSournoiserieButton = true;
        }
        filterList();
    }

    // Button MindSet

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void concentrationFilterTapped(View view) {
        ifConcentrationButton = !ifConcentrationButton;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void pacifiqueFilterTapped(View view) {
        ifPacifiqueButton = !ifPacifiqueButton;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void balancedFilterTapped(View view) {
        ifBalancedButton = !ifBalancedButton;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void fureurFilterTapped(View view) {
        ifFureurButton = !ifFureurButton;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sournoiserieFilterTapped(View view) {
        ifSournoiserieButton = !ifSournoiserieButton;
        filterList();
    }

    // Button Stance

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void allFilterStanceTapped(View view) {
        if (ifADistance && ifAuContact && ifDebout && ifMaintenuAuSol && ifMaintenantAuSol &&
                ifAGenoux && ifMaintenuDeDos && ifMaintenantDeDos && ifAuSol && ifEntrave) {
            ifADistance = false;
            ifAuContact = false;
            ifDebout = false;
            ifMaintenuAuSol = false;
            ifMaintenantAuSol = false;
            ifAGenoux = false;
            ifMaintenuDeDos = false;
            ifMaintenantDeDos = false;
            ifAuSol = false;
            ifEntrave = false;
        } else {
            ifADistance = true;
            ifAuContact = true;
            ifDebout = true;
            ifMaintenuAuSol = true;
            ifMaintenantAuSol = true;
            ifAGenoux = true;
            ifMaintenuDeDos = true;
            ifMaintenantDeDos = true;
            ifAuSol = true;
            ifEntrave = true;
        }
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void aDistanceFilterTapped(View view) {
        ifADistance = !ifADistance;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void auContactFilterTapped(View view) {
        ifAuContact = !ifAuContact;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void deboutFilterTapped(View view) {
        ifDebout = !ifDebout;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void maintenuAuSolFilterTapped(View view) {
        ifMaintenuAuSol = !ifMaintenuAuSol;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void maintenantAuSolFilterTapped(View view) {
        ifMaintenantAuSol = !ifMaintenantAuSol;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void aGenouxFilterTapped(View view) {
        ifAGenoux = !ifAGenoux;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void maintenuDeDosFilterTapped(View view) {
        ifMaintenuDeDos = !ifMaintenuDeDos;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void maintenantDeDosFilterTapped(View view) {
        ifMaintenantDeDos = !ifMaintenantDeDos;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void auSolFilterTapped(View view) {
        ifAuSol = !ifAuSol;
        filterList();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void entraveFilterTapped(View view) {
        ifEntrave = !ifEntrave;
        filterList();
    }


}