package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class Venda implements Serializable {

    @Id
    private int _id;
    private float qtdProdutoVenda;
    private String formaPagamento;
    private String date;
    private Produto produto;


    public Venda() {
    }

    public Venda(int _id, float qtdProdutoVenda, String formaPagamento, String date,  Produto produto) {
        this._id = _id;
        this.qtdProdutoVenda = qtdProdutoVenda;
        this.formaPagamento = formaPagamento;
        this.date = date;
        this.produto = produto;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public float getQtdProdutoVenda() {
        return qtdProdutoVenda;
    }

    public void setQtdProdutoVenda(float qtdProdutoVenda) {
        this.qtdProdutoVenda = qtdProdutoVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
