package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Produto implements Serializable {

    @Id
    private int _id;
    private  String nome;

    public Produto(){

    }

    public Produto(int _id, String nome) {
        this._id = _id;
        this.nome = nome;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
