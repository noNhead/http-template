package com.epam.izh.rd.online.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

/**
 * Покемон. Поля должны заполняться из JSON, который возвратит внешний REST-service
 * Для маппинка значений из массива stats рекомендуется использовать отдельный класс Stat и аннотацию @JsonCreator
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {


    /**
     * Уникальный идентификатор, маппится из поля pokemonId
     */
    private int pokemonId;

    /**
     * Имя покемона, маппится из поля pokemonName
     */
    private String pokemonName;

    /**
     * Здоровье покемона, маппится из массива объектов stats со значением name: "hp"
     */
    @JsonIgnore
    private int hp;

    /**
     * Атака покемона, маппится из массива объектов stats со значением name: "attack"
     */
    @JsonIgnore
    private int attack;

    /**
     * Защита покемона, маппится из массива объектов stats со значением name: "defense"
     */
    @JsonIgnore
    private int defense;

    private String imgUrl;

    @JsonCreator
    public Pokemon(
            @JsonProperty("game_indices") Object[] game_indices,
            @JsonProperty("name") String name,
            @JsonProperty("stats") Object[] stats,
            @JsonProperty("sprites") Map<String, String> spritesMap) {
        Map<String, Object> subIndices = (Map<String, Object>) game_indices[19];
        this.pokemonId = (int) subIndices.get("game_index");
        Map<String, Object> subStats;
        subStats = (Map<String, Object>) stats[0];
        this.hp = (int) subStats.get("base_stat");
        subStats = (Map<String, Object>) stats[1];
        this.attack = (int) subStats.get("base_stat");
        subStats = (Map<String, Object>) stats[2];
        this.defense = (int) subStats.get("base_stat");
        this.pokemonName = name;
        this.imgUrl = spritesMap.get("front_default");
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(short hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(short attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(short defense) {
        this.defense = defense;
    }
}

