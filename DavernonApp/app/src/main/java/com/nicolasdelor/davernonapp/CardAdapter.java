package com.nicolasdelor.davernonapp;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.List;

public class CardAdapter extends ArrayAdapter<Card> {
    public CardAdapter(Context context, int resource, List<Card> cardList) {
        super(context, resource, cardList);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Card card = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_cell, parent, false);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.cardName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.cardImage);

        tv.setText(card.getmName());
        iv.setImageResource(card.getmImage());


        ImageView aDistance = (ImageView) convertView.findViewById(R.id.aDistance);
        ImageView auContact = (ImageView) convertView.findViewById(R.id.auContact);
        ImageView debout = (ImageView) convertView.findViewById(R.id.debout);
        ImageView maintenuAuSol = (ImageView) convertView.findViewById(R.id.maintenuAuSol);
        ImageView maintenantAuSol = (ImageView) convertView.findViewById(R.id.maintenantAuSol);
        ImageView aGenoux = (ImageView) convertView.findViewById(R.id.aGenoux);
        ImageView maintenuDeDos = (ImageView) convertView.findViewById(R.id.maintenuDeDos);
        ImageView maintenantDeDos = (ImageView) convertView.findViewById(R.id.maintenantDeDos);
        ImageView auSol = (ImageView) convertView.findViewById(R.id.auSol);
        ImageView entrave = (ImageView) convertView.findViewById(R.id.entrave);

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

        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 1)) {
            aDistance.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 2)) {
            auContact.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 3)) {
            debout.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 4)) {
            maintenuAuSol.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 5)) {
            maintenantAuSol.setColorFilter(R.color.design_default_color_on_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 6)) {
            aGenoux.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 7)) {
            maintenuDeDos.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 8)) {
            maintenantDeDos.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 9)) {
            auSol.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmStances()).anyMatch(x -> x.mId == 10)) {
            entrave.setColorFilter(R.color.design_default_color_error);
        }

        ImageView concentration = (ImageView) convertView.findViewById(R.id.concentration);
        ImageView pacifique = (ImageView) convertView.findViewById(R.id.pacifique);
        ImageView balanced = (ImageView) convertView.findViewById(R.id.balanced);
        ImageView fureur = (ImageView) convertView.findViewById(R.id.fureur);
        ImageView sournoiserie = (ImageView) convertView.findViewById(R.id.sournoiserie);


        concentration.setImageResource(R.drawable.concentration);
        pacifique.setImageResource(R.drawable.pacifism);
        balanced.setImageResource(R.drawable.balance);
        fureur.setImageResource(R.drawable.fureur);
        sournoiserie.setImageResource(R.drawable.sournoiserie);


        if (!Arrays.stream(card.getmMindSets()).anyMatch(x -> x.mId == 0)) {
            concentration.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmMindSets()).anyMatch(x -> x.mId == 1)) {
            pacifique.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmMindSets()).anyMatch(x -> x.mId == 2)) {
            balanced.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmMindSets()).anyMatch(x -> x.mId == 3)) {
            fureur.setColorFilter(R.color.design_default_color_error);
        }
        if (!Arrays.stream(card.getmMindSets()).anyMatch(x -> x.mId == 4)) {
            sournoiserie.setColorFilter(R.color.design_default_color_error);
        }

        return convertView;
    }
}
