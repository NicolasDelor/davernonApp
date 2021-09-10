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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailCard extends AppCompatActivity {
    Card selectedCard;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);
        getSelectedCard();
        setValues();

    }

    private void getSelectedCard() {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedCard = MainActivity.cardList.get(Integer.valueOf(parsedStringID));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setValues() {
        TextView tv = (TextView) findViewById(R.id.cardName);
        ImageView iv = (ImageView) findViewById(R.id.cardImage);

        tv.setText(selectedCard.getmName());
        iv.setImageResource(selectedCard.getmImage());

        TextView stamina = (TextView) findViewById(R.id.stamina);
        TextView vitesse = (TextView) findViewById(R.id.vitesse);
        TextView description = (TextView) findViewById(R.id.description);
        TextView descriptionBax = (TextView) findViewById(R.id.descriptionBax);

        stamina.setText(Integer.toString(selectedCard.getmStamina()));
        vitesse.setText(Integer.toString(selectedCard.getmVitesse()));
        description.setText(selectedCard.getmDescription());
        descriptionBax.setText(selectedCard.getmDescriptionBax());

        ImageView aDistance = (ImageView) findViewById(R.id.aDistance);
        ImageView auContact = (ImageView) findViewById(R.id.auContact);
        ImageView debout = (ImageView) findViewById(R.id.debout);
        ImageView maintenuAuSol = (ImageView) findViewById(R.id.maintenuAuSol);
        ImageView maintenantAuSol = (ImageView) findViewById(R.id.maintenantAuSol);
        ImageView aGenoux = (ImageView) findViewById(R.id.aGenoux);
        ImageView maintenuDeDos = (ImageView) findViewById(R.id.maintenuDeDos);
        ImageView maintenantDeDos = (ImageView) findViewById(R.id.maintenantDeDos);
        ImageView auSol = (ImageView) findViewById(R.id.auSol);
        ImageView entrave = (ImageView) findViewById(R.id.entrave);

        aDistance.setImageResource(R.drawable.adistance);
        auContact.setImageResource(R.drawable.aucontact);
        debout.setImageResource(R.drawable.debout);
        maintenuAuSol.setImageResource(R.drawable.maintenuausol);
        maintenantAuSol.setImageResource(R.drawable.maintenantausol);
        aGenoux.setImageResource(R.drawable.agenoux);
        maintenuDeDos.setImageResource(R.drawable.maintenudedos);
        maintenantDeDos.setImageResource(R.drawable.maintenantdedos);
        auSol.setImageResource(R.drawable.ausol);
        entrave.setImageResource(R.drawable.entrave);

        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 1)) {
            aDistance.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 2)) {
            auContact.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 3)) {
            debout.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 4)) {
            maintenuAuSol.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 5)) {
            maintenantAuSol.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 6)) {
            aGenoux.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 7)) {
            maintenuDeDos.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 8)) {
            maintenantDeDos.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 9)) {
            auSol.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmStances()).anyMatch(x -> x.mId == 10)) {
            entrave.setColorFilter(R.color.design_default_color_error);
        }

        ImageView concentration = (ImageView) findViewById(R.id.concentration);
        ImageView pacifique = (ImageView) findViewById(R.id.pacifique);
        ImageView balanced = (ImageView) findViewById(R.id.balanced);
        ImageView fureur = (ImageView) findViewById(R.id.fureur);
        ImageView sournoiserie = (ImageView) findViewById(R.id.sournoiserie);


        concentration.setImageResource(R.drawable.concentration);
        pacifique.setImageResource(R.drawable.pacifism);
        balanced.setImageResource(R.drawable.balance);
        fureur.setImageResource(R.drawable.fureur);
        sournoiserie.setImageResource(R.drawable.sournoiserie);


        if (!Arrays.stream(selectedCard.getmMindSets()).anyMatch(x -> x.mId == 0)) {
            concentration.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmMindSets()).anyMatch(x -> x.mId == 1)) {
            pacifique.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmMindSets()).anyMatch(x -> x.mId == 2)) {
            balanced.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmMindSets()).anyMatch(x -> x.mId == 3)) {
            fureur.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(selectedCard.getmMindSets()).anyMatch(x -> x.mId == 4)) {
            sournoiserie.setColorFilter(R.color.design_default_color_error);
        }


    }
}