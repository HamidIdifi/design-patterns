package com.ensaa.builders;



import com.ensaa.entities.impl.BasicCountry;
import com.ensaa.entities.impl.BasicKing;
import com.ensaa.entities.impl.SoldiersInEdges;
import com.ensaa.factories.AbstractFactory;
import com.ensaa.factories.impl.CountryFactoryImpl;
import com.ensaa.factories.impl.KingFactoryImpl;
import com.ensaa.factories.impl.SoldierFactoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class KingDom {
    private final BasicKing basicKing;
    private final List<BasicCountry> countries;
    private PeopleMood peopleMood;

    private KingDom(KingDomBuilder kingDomBuilder) {
        this.basicKing = kingDomBuilder.basicKing;
        this.countries = kingDomBuilder.countries;
        this.countries.forEach(c -> c.setSoldiersInEdges(kingDomBuilder.soldiersInEdges));
    }

    public boolean isContainsCountry(String countryName) {
        return this.countries.stream().anyMatch(c -> c.getName().equals(countryName));
    }

    public Optional<BasicCountry> findCountryByName(String countryName) {
        return this.countries.stream()
                .filter(country -> country.getName().equals(countryName))
                .findAny();
    }

    public int currentPower() {
        return
                this.countries.stream().mapToInt(BasicCountry::currentPower).sum();
    }

    public String report() {
        String collect = this.countries.stream()
                .map(BasicCountry::report)
                .collect(Collectors.joining(", "));
        return this.basicKing.getName() + ":|" + collect + "|";
    }

    public int prepareAttack(BasicCountry country) {
        this.peopleMood = PeopleMood.GOOD;
        return country.prepareAttack();
    }

    public void movingArmyToEdges(BasicCountry country, int nbr) {
        country.movingArmyToEdges(nbr);
    }

    public String peopleMood() {
        return peopleMood.toString();
    }

    public void startWar(BasicCountry country, int nbrOfArmy) {
        country.startWar(nbrOfArmy);
    }

    public int gettingAttacked(BasicCountry country) {
        this.peopleMood = PeopleMood.BAD;
        return country.gettingAttacked();
    }

    enum PeopleMood {
        GOOD,
        BAD
    }

    public static class KingDomBuilder {
        private final List<BasicCountry> countries = new ArrayList<>();
        private BasicKing basicKing;
        private SoldiersInEdges soldiersInEdges;

        public KingDomBuilder addCountry(String... strings) {
            BasicCountry country = AbstractFactory.getCountry(new CountryFactoryImpl(strings));
            this.countries.add(country);
            return this;
        }

        public KingDomBuilder addKing(String name) {
            this.basicKing = AbstractFactory.getKing(new KingFactoryImpl(name));
            return this;
        }

        public KingDomBuilder addSoldiersOnEdges(String nbrOfSoldiersOnEdges) {
            this.soldiersInEdges = AbstractFactory.getSoldier(new SoldierFactoryImpl(nbrOfSoldiersOnEdges));
            return this;
        }

        public KingDom build() {
            return new KingDom(this);
        }
    }
}
