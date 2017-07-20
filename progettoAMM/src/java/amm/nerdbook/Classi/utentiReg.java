/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author martinasalis
 */
public class utentiReg {
    
    private int id;
    private String nome;
    private String cognome;
    private String descrizione;
    private String compleanno;
    private String password;
    private String urlFotoProfilo;

    public utentiReg() {
        id = 0;
        nome = "";
        cognome = "";
        descrizione = "";
        compleanno = "";
        password = "";
        urlFotoProfilo = "";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    /**
     * @return the compleanno
     */
    public String getCompleanno() {
        return compleanno;
    }

    /**
     * @param compleanno the compleanno to set
     */
    public void setCompleanno(String compleanno) {
        this.compleanno = compleanno;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }
    
    @Override
    public boolean equals(Object altroUtentiReg) {
        if (altroUtentiReg instanceof utentiReg)
            if (this.getId() == ((utentiReg)altroUtentiReg).getId()) return true;
        return false;
    }

}
