package it.aulab.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.aulab.Dao;

@Component
public class ProdottoDao implements Dao<Prodotto> {
    @Autowired
    private JdbcTemplate jdbcTemplate;




    public List<Prodotto> getGreatherThanPrezzo(Float minPrezzo) {
        return jdbcTemplate.query("SELECT * FROM prodotti WHERE prezzo > ?", 
        new BeanPropertyRowMapper<Prodotto>(Prodotto.class), minPrezzo);
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM prodotti", Integer.class);
    }


    @Override
    public Prodotto getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM prodotti WHERE id = ?", 
        new BeanPropertyRowMapper<Prodotto>(Prodotto.class), id);
    }

    @Override
    public List<Prodotto> getData() {
        return jdbcTemplate.query("SELECT * FROM prodotti", 
        new BeanPropertyRowMapper<Prodotto>(Prodotto.class));
    }

    @Override
    public boolean insert(Prodotto model) {
        int result = jdbcTemplate.update("INSERT INTO prodotti (nome, descrizione, prezzo) value (?, ?, ?)", model.getNome(), 
        model.getDescrizione(), model.getPrezzo());
        return result > 0;
    }

    @Override
    public boolean update(Long id, Prodotto model) {
        int result = jdbcTemplate.update("UPDATE prodotti SET nome = ?, descrizione = ?, prezzo = ? WHERE id = ?",
        model.getNome(), model.getDescrizione(), model.getPrezzo(), id);
        return result > 0;
    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
