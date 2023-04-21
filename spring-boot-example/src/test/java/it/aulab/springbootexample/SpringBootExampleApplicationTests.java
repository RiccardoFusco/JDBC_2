package it.aulab.springbootexample;

import java.util.List;

// import javax.management.Query;

import org.assertj.core.api.Assertions;
// import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;

import it.aulab.springbootexample.model.Prodotto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


// @SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootExampleApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	void persistObjectProdotto() {
		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		Prodotto p = new Prodotto();

		p.setNome("Maglia Nike");
		p.setDescrizione("Maglia in cotone");
		p.setPrezzo(30F);

		List<Prodotto> allBeforePersist = q.getResultList();

		Assertions.assertThat(allBeforePersist).hasSize(4);

		entityManager.persist(p);

		List<Prodotto> allAfterPersist = q.getResultList();

		Assertions.assertThat(allAfterPersist).hasSize(5);
}

@Test
void updateObjectProdotto() {
	TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

	List<Prodotto> all = q.getResultList();

	Prodotto p = all.get(0);


	String n = "nuovo nome";
	String d = "nuova descrizione";  
	p.setNome(n);
	p.setDescrizione(d);

	entityManager.persist(p);

	List<Prodotto> allAfterPersist = q.getResultList();

	p = allAfterPersist.get(0);

	Assertions.assertThat(p).extracting("nome").isEqualTo(n);
	Assertions.assertThat(p).extracting("descrizione").isEqualTo(d);



}
}
