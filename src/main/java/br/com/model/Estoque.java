package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Estoque  implements Serializable {

    @Id
    private int _id;
    private float qtdProduto;
    private Produto produto;

    public Estoque(int _id, float qtdProduto, Produto produto) {
        this._id = _id;
        this.qtdProduto = qtdProduto;
        this.produto = produto;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
