package com.subdefender.game.Players;

import com.subdefender.game.itens.Submarinos;
import com.subdefender.game.itens.Tiro;

public class Player {
    private String playerName;
    private int lifeCounter = 10;
    private int score = 1000;
    private int selectedBullet;
    public Tiro[] balas = new Tiro[3];
    public Submarinos[] submarinos = new Submarinos[5];
    private int frota;

    public Player(){
        for (int i=0; i < 5; i++){
            this.submarinos[i] = new Submarinos(i+1);
        }

        for (int i=0; i < 3; i++){
            this.balas[i] = new Tiro();
        }
        this.selectedBullet = 0;
        this.frota = 5;
    }

    //NOME
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public String getPlayerName() { return this.playerName; }
    public boolean validateName(String playerName) {
        if (playerName.length() > 17 || playerName.length() == 0) {
            System.out.println("Nome muito grande ou nao foi inserido.");    //TODO - implementar o aviso de nome excedendo o limite de caracteres ou nome nao inserido
            return false;
        }
        return true;
    }

    //VIDA
    public void setLifeCounter(int lifeCounter) { this.lifeCounter = lifeCounter; }
    public int getLifeCounter() { return this.lifeCounter; }

    //PONTUACAO
    public void setScore(int score) { this.score += score; }
    public int getScore() { return this.score; }

    //SUBMARINOS
    public boolean isSubAlocado(int index) {
        return this.submarinos[index].isAlocado();
    }
    public void alocateSub(int index, int[] subCords) {
        //Coordenadas inicio
        int inicioFila = subCords[0];
        int inicioColuna = subCords[1];

        //Coordenadas fim
        int fimFila = subCords[2];
        int fimColuna = subCords[3];

         this.submarinos[index].alocateSubs(inicioFila, inicioColuna, fimFila, fimColuna);
    }
    public void submarinoAbatido() {
        frota--;
    }
    public int getFrota() { return this.frota; }

    //BALAS
    public int getSelectedBullet() {
        return selectedBullet;
    }
    public void setSelectedBullet(int index) {
        this.selectedBullet = index;
    }


}
