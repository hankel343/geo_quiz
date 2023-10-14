package com.example.geoquizbackend.models;

import java.util.List;
import java.util.Map;

/*
    The following Object represents the data returned from the external API found at:
    https://restcountries.com/v3.1
 */
public class CountryData {
    private Name name;
    private List<String> tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Currencies currencies;
    private Idd idd;
    private List<String> capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private Translations translations;
    private List<Double> latlng;
    private boolean landlocked;
    private List<String> borders;
    private double area;
    private Demonyms demonyms;
    private String flag;
    private Maps maps;
    private int population;
    private Gini gini;
    private String fifa;
    private Car car;
    private List<String> timezones;
    private List<String> continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;

    @Override
    public String toString() {
        return "CountryData{" +
                "name=" + name +
                ", tld=" + tld +
                ", cca2='" + cca2 + '\'' +
                ", ccn3='" + ccn3 + '\'' +
                ", cca3='" + cca3 + '\'' +
                ", cioc='" + cioc + '\'' +
                ", independent=" + independent +
                ", status='" + status + '\'' +
                ", unMember=" + unMember +
                ", currencies=" + currencies +
                ", idd=" + idd +
                ", capital=" + capital +
                ", altSpellings=" + altSpellings +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", languages=" + languages +
                ", translations=" + translations +
                ", latlng=" + latlng +
                ", landlocked=" + landlocked +
                ", borders=" + borders +
                ", area=" + area +
                ", demonyms=" + demonyms +
                ", flag='" + flag + '\'' +
                ", maps=" + maps +
                ", population=" + population +
                ", gini=" + gini +
                ", fifa='" + fifa + '\'' +
                ", car=" + car +
                ", timezones=" + timezones +
                ", continents=" + continents +
                ", flags=" + flags +
                ", coatOfArms=" + coatOfArms +
                ", startOfWeek='" + startOfWeek + '\'' +
                ", capitalInfo=" + capitalInfo +
                ", postalCode=" + postalCode +
                '}';
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<String> getTld() {
        return tld;
    }

    public void setTld(List<String> tld) {
        this.tld = tld;
    }

    public String getCca2() {
        return cca2;
    }

    public void setCca2(String cca2) {
        this.cca2 = cca2;
    }

    public String getCcn3() {
        return ccn3;
    }

    public void setCcn3(String ccn3) {
        this.ccn3 = ccn3;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isUnMember() {
        return unMember;
    }

    public void setUnMember(boolean unMember) {
        this.unMember = unMember;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public Idd getIdd() {
        return idd;
    }

    public void setIdd(Idd idd) {
        this.idd = idd;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public boolean isLandlocked() {
        return landlocked;
    }

    public void setLandlocked(boolean landlocked) {
        this.landlocked = landlocked;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Demonyms getDemonyms() {
        return demonyms;
    }

    public void setDemonyms(Demonyms demonyms) {
        this.demonyms = demonyms;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Maps getMaps() {
        return maps;
    }

    public void setMaps(Maps maps) {
        this.maps = maps;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Gini getGini() {
        return gini;
    }

    public void setGini(Gini gini) {
        this.gini = gini;
    }

    public String getFifa() {
        return fifa;
    }

    public void setFifa(String fifa) {
        this.fifa = fifa;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public CoatOfArms getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(CoatOfArms coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    public String getStartOfWeek() {
        return startOfWeek;
    }

    public void setStartOfWeek(String startOfWeek) {
        this.startOfWeek = startOfWeek;
    }

    public CapitalInfo getCapitalInfo() {
        return capitalInfo;
    }

    public void setCapitalInfo(CapitalInfo capitalInfo) {
        this.capitalInfo = capitalInfo;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public static class Name {
        private String common;
        private String official;
        private NativeName nativeName;

        @Override
        public String toString() {
            return "Name{" +
                    "common='" + common + '\'' +
                    ", official='" + official + '\'' +
                    ", nativeName=" + nativeName +
                    '}';
        }

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }

        public String getOfficial() {
            return official;
        }

        public void setOfficial(String official) {
            this.official = official;
        }

        public NativeName getNativeName() {
            return nativeName;
        }

        public void setNativeName(NativeName nativeName) {
            this.nativeName = nativeName;
        }
    }

    public static class NativeName {
        private Map<String, String> deu;

        @Override
        public String toString() {
            return "NativeName{" +
                    "deu=" + deu +
                    '}';
        }

        public Map<String, String> getDeu() {
            return deu;
        }

        public void setDeu(Map<String, String> deu) {
            this.deu = deu;
        }
    }

    public static class Currencies {
        private Map<String, Currency> EUR;

        @Override
        public String toString() {
            return "Currencies{" +
                    "EUR=" + EUR +
                    '}';
        }

        public Map<String, Currency> getEUR() {
            return EUR;
        }

        public void setEUR(Map<String, Currency> EUR) {
            this.EUR = EUR;
        }
    }

    public static class Currency {
        private String name;
        private String symbol;

        @Override
        public String toString() {
            return "Currency{" +
                    "name='" + name + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public static class Idd {
        private String root;
        private List<String> suffixes;

        @Override
        public String toString() {
            return "Idd{" +
                    "root='" + root + '\'' +
                    ", suffixes=" + suffixes +
                    '}';
        }

        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

        public List<String> getSuffixes() {
            return suffixes;
        }

        public void setSuffixes(List<String> suffixes) {
            this.suffixes = suffixes;
        }
    }

    public static class Translations {
        private Map<String, String> ara;
        private Map<String, String> bre;
        private Map<String, String> ces;
        private Map<String, String> cym;
        private Map<String, String> deu;
        private Map<String, String> est;
        private Map<String, String> fin;
        private Map<String, String> fra;
        private Map<String, String> hrv;
        private Map<String, String> hun;
        private Map<String, String> ita;
        private Map<String, String> jpn;
        private Map<String, String> kor;
        private Map<String, String> nld;
        private Map<String, String> per;
        private Map<String, String> pol;
        private Map<String, String> por;
        private Map<String, String> rus;
        private Map<String, String> slk;
        private Map<String, String> spa;
        private Map<String, String> srp;
        private Map<String, String> swe;
        private Map<String, String> tur;
        private Map<String, String> urd;
        private Map<String, String> zho;

        @Override
        public String toString() {
            return "Translations{" +
                    "ara=" + ara +
                    ", bre=" + bre +
                    // Add more languages here
                    '}';
        }

        public Map<String, String> getAra() {
            return ara;
        }

        public void setAra(Map<String, String> ara) {
            this.ara = ara;
        }

        public Map<String, String> getBre() {
            return bre;
        }

        public void setBre(Map<String, String> bre) {
            this.bre = bre;
        }

        public Map<String, String> getCes() {
            return ces;
        }

        public void setCes(Map<String, String> ces) {
            this.ces = ces;
        }

        public Map<String, String> getCym() {
            return cym;
        }

        public void setCym(Map<String, String> cym) {
            this.cym = cym;
        }

        public Map<String, String> getDeu() {
            return deu;
        }

        public void setDeu(Map<String, String> deu) {
            this.deu = deu;
        }

        public Map<String, String> getEst() {
            return est;
        }

        public void setEst(Map<String, String> est) {
            this.est = est;
        }

        public Map<String, String> getFin() {
            return fin;
        }

        public void setFin(Map<String, String> fin) {
            this.fin = fin;
        }

        public Map<String, String> getFra() {
            return fra;
        }

        public void setFra(Map<String, String> fra) {
            this.fra = fra;
        }

        public Map<String, String> getHrv() {
            return hrv;
        }

        public void setHrv(Map<String, String> hrv) {
            this.hrv = hrv;
        }

        public Map<String, String> getHun() {
            return hun;
        }

        public void setHun(Map<String, String> hun) {
            this.hun = hun;
        }

        public Map<String, String> getIta() {
            return ita;
        }

        public void setIta(Map<String, String> ita) {
            this.ita = ita;
        }

        public Map<String, String> getJpn() {
            return jpn;
        }

        public void setJpn(Map<String, String> jpn) {
            this.jpn = jpn;
        }

        public Map<String, String> getKor() {
            return kor;
        }

        public void setKor(Map<String, String> kor) {
            this.kor = kor;
        }

        public Map<String, String> getNld() {
            return nld;
        }

        public void setNld(Map<String, String> nld) {
            this.nld = nld;
        }

        public Map<String, String> getPer() {
            return per;
        }

        public void setPer(Map<String, String> per) {
            this.per = per;
        }

        public Map<String, String> getPol() {
            return pol;
        }

        public void setPol(Map<String, String> pol) {
            this.pol = pol;
        }

        public Map<String, String> getPor() {
            return por;
        }

        public void setPor(Map<String, String> por) {
            this.por = por;
        }

        public Map<String, String> getRus() {
            return rus;
        }

        public void setRus(Map<String, String> rus) {
            this.rus = rus;
        }

        public Map<String, String> getSlk() {
            return slk;
        }

        public void setSlk(Map<String, String> slk) {
            this.slk = slk;
        }

        public Map<String, String> getSpa() {
            return spa;
        }

        public void setSpa(Map<String, String> spa) {
            this.spa = spa;
        }

        public Map<String, String> getSrp() {
            return srp;
        }

        public void setSrp(Map<String, String> srp) {
            this.srp = srp;
        }

        public Map<String, String> getSwe() {
            return swe;
        }

        public void setSwe(Map<String, String> swe) {
            this.swe = swe;
        }

        public Map<String, String> getTur() {
            return tur;
        }

        public void setTur(Map<String, String> tur) {
            this.tur = tur;
        }

        public Map<String, String> getUrd() {
            return urd;
        }

        public void setUrd(Map<String, String> urd) {
            this.urd = urd;
        }

        public Map<String, String> getZho() {
            return zho;
        }

        public void setZho(Map<String, String> zho) {
            this.zho = zho;
        }
    }

    public static class Demonyms {
        private Map<String, String> eng;
        private Map<String, String> fra;

        @Override
        public String toString() {
            return "Demonyms{" +
                    "eng=" + eng +
                    ", fra=" + fra +
                    // Add more languages here
                    '}';
        }

        public Map<String, String> getEng() {
            return eng;
        }

        public void setEng(Map<String, String> eng) {
            this.eng = eng;
        }

        public Map<String, String> getFra() {
            return fra;
        }

        public void setFra(Map<String, String> fra) {
            this.fra = fra;
        }
    }

    public static class Maps {
        private String googleMaps;
        private String openStreetMaps;

        @Override
        public String toString() {
            return "Maps{" +
                    "googleMaps='" + googleMaps + '\'' +
                    ", openStreetMaps='" + openStreetMaps + '\'' +
                    '}';
        }

        public String getGoogleMaps() {
            return googleMaps;
        }

        public void setGoogleMaps(String googleMaps) {
            this.googleMaps = googleMaps;
        }

        public String getOpenStreetMaps() {
            return openStreetMaps;
        }

        public void setOpenStreetMaps(String openStreetMaps) {
            this.openStreetMaps = openStreetMaps;
        }
    }

    public static class Gini {
        private double _2016;

        @Override
        public String toString() {
            return "Gini{" +
                    "_2016=" + _2016 +
                    '}';
        }

        public double get_2016() {
            return _2016;
        }

        public void set_2016(double _2016) {
            this._2016 = _2016;
        }
    }

    public static class Car {
        private List<String> signs;
        private String side;

        @Override
        public String toString() {
            return "Car{" +
                    "signs=" + signs +
                    ", side='" + side + '\'' +
                    '}';
        }

        public List<String> getSigns() {
            return signs;
        }

        public void setSigns(List<String> signs) {
            this.signs = signs;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }
    }

    public static class Flags {
        private String png;
        private String svg;
        private String alt;

        @Override
        public String toString() {
            return "Flags{" +
                    "png='" + png + '\'' +
                    ", svg='" + svg + '\'' +
                    ", alt='" + alt + '\'' +
                    '}';
        }

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }

        public String getSvg() {
            return svg;
        }

        public void setSvg(String svg) {
            this.svg = svg;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }
    }

    public static class CoatOfArms {
        private String png;
        private String svg;

        @Override
        public String toString() {
            return "CoatOfArms{" +
                    "png='" + png + '\'' +
                    ", svg='" + svg + '\'' +
                    '}';
        }

        public String getPng() {
            return png;
        }

        public void setPng(String png) {
            this.png = png;
        }

        public String getSvg() {
            return svg;
        }

        public void setSvg(String svg) {
            this.svg = svg;
        }
    }

    public static class CapitalInfo {
        private List<Double> latlng;

        @Override
        public String toString() {
            return "CapitalInfo{" +
                    "latlng=" + latlng +
                    '}';
        }

        public List<Double> getLatlng() {
            return latlng;
        }

        public void setLatlng(List<Double> latlng) {
            this.latlng = latlng;
        }
    }

    public static class PostalCode {
        private String format;
        private String regex;

        @Override
        public String toString() {
            return "PostalCode{" +
                    "format='" + format + '\'' +
                    ", regex='" + regex + '\'' +
                    '}';
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }
    }
}
