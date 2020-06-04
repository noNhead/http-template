package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Pokemon;

public class SimplePokemonFightingClubService implements PokemonFightingClubService {
    HttpConn httpConn = new HttpConn();

    @Override
    public Pokemon doBattle(Pokemon p1, Pokemon p2) {
        while((p1.getHp() > 0) && (p2.getHp() > 0)){
            doDamage(p1, p2);
            if (p2.getHp() <= 0) {
                showWinner(p1);
                System.out.println(p1.getPokemonName());
                return p1;
            }
            doDamage(p2, p1);
            if (p1.getHp() <= 0) {
                showWinner(p2);
                System.out.println(p2.getPokemonName());
                return p2;
            }
        }
        return null;
    }

    @Override
    public void showWinner(Pokemon winner) {
        httpConn.getImage(winner.getImgUrl());
    }

    @Override
    public void doDamage(Pokemon from, Pokemon to) {
        to.setHp((short) (to.getHp() - (from.getAttack() * to.getDefense()/100)));
    }
}
