package com.generation.alijava;

import com.generation.alijava.model.dao.ProdottoDao;
import com.generation.alijava.model.entities.Bevanda;
import com.generation.alijava.model.entities.Cibo;
import com.generation.alijava.model.entities.enums.Conservazione;
import com.generation.alijava.model.entities.enums.TipologiaBevanda;
import com.generation.alijava.model.entities.enums.TipologiaCibo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AlijavaApplicationTests
{
	@Autowired
	ProdottoDao prodottoDao;

	@Test
	public void inserisciCibiEBevande() {

		// ==========================
		//       10 CIBI
		// ==========================
		Cibo cibo1 = new Cibo();
		cibo1.setNome("Bistecca");
		cibo1.setDescrizione("Bistecca di manzo surgelata");
		cibo1.setImgUrl("bistecca.jpg");
		cibo1.setPrezzoUnitario(12.50);
		cibo1.setQnt(50);
		cibo1.setPeso(0.3);  // kg
		cibo1.setTipologiaCibo(TipologiaCibo.CARNE);
		cibo1.setConservazione(Conservazione.SURGELATO);

		Cibo cibo2 = new Cibo();
		cibo2.setNome("Merluzzo");
		cibo2.setDescrizione("Filetti di merluzzo surgelati");
		cibo2.setImgUrl("merluzzo.jpg");
		cibo2.setPrezzoUnitario(8.99);
		cibo2.setQnt(30);
		cibo2.setPeso(0.4);
		cibo2.setTipologiaCibo(TipologiaCibo.PESCE);
		cibo2.setConservazione(Conservazione.SURGELATO);

		Cibo cibo3 = new Cibo();
		cibo3.setNome("Carote");
		cibo3.setDescrizione("Carote fresche a km zero");
		cibo3.setImgUrl("carote.jpg");
		cibo3.setPrezzoUnitario(1.99);
		cibo3.setQnt(100);
		cibo3.setPeso(1.0);
		cibo3.setTipologiaCibo(TipologiaCibo.VERDURA);
		cibo3.setConservazione(Conservazione.FRESCO);

		Cibo cibo4 = new Cibo();
		cibo4.setNome("Bresaola");
		cibo4.setDescrizione("Bresaola della Valtellina");
		cibo4.setImgUrl("bresaola.jpg");
		cibo4.setPrezzoUnitario(6.50);
		cibo4.setQnt(20);
		cibo4.setPeso(0.2);
		cibo4.setTipologiaCibo(TipologiaCibo.AFFETTATI);
		cibo4.setConservazione(Conservazione.FRIGO);

		Cibo cibo5 = new Cibo();
		cibo5.setNome("Pizza surgelata");
		cibo5.setDescrizione("Pizza margherita surgelata");
		cibo5.setImgUrl("pizza.jpg");
		cibo5.setPrezzoUnitario(3.50);
		cibo5.setQnt(40);
		cibo5.setPeso(0.4);
		cibo5.setTipologiaCibo(TipologiaCibo.PIATTI_PRONTI);
		cibo5.setConservazione(Conservazione.SURGELATO);

		Cibo cibo6 = new Cibo();
		cibo6.setNome("Mela");
		cibo6.setDescrizione("Mela Fuji fresca");
		cibo6.setImgUrl("mela.jpg");
		cibo6.setPrezzoUnitario(0.60);
		cibo6.setQnt(100);
		cibo6.setPeso(0.15);
		cibo6.setTipologiaCibo(TipologiaCibo.FRUTTA);
		cibo6.setConservazione(Conservazione.FRESCO);

		Cibo cibo7 = new Cibo();
		cibo7.setNome("Banana");
		cibo7.setDescrizione("Banana fresca equosolidale");
		cibo7.setImgUrl("banana.jpg");
		cibo7.setPrezzoUnitario(0.50);
		cibo7.setQnt(120);
		cibo7.setPeso(0.13);
		cibo7.setTipologiaCibo(TipologiaCibo.FRUTTA);
		cibo7.setConservazione(Conservazione.FRESCO);

		Cibo cibo8 = new Cibo();
		cibo8.setNome("Patatine");
		cibo8.setDescrizione("Snack patatine in busta");
		cibo8.setImgUrl("patatine.jpg");
		cibo8.setPrezzoUnitario(1.20);
		cibo8.setQnt(80);
		cibo8.setPeso(0.1);
		cibo8.setTipologiaCibo(TipologiaCibo.SNACK);
		cibo8.setConservazione(Conservazione.LUNGA_CONSERVAZIONE);

		Cibo cibo9 = new Cibo();
		cibo9.setNome("Tiramisù");
		cibo9.setDescrizione("Dessert al mascarpone e caffè");
		cibo9.setImgUrl("tiramisu.jpg");
		cibo9.setPrezzoUnitario(4.50);
		cibo9.setQnt(25);
		cibo9.setPeso(0.15);
		cibo9.setTipologiaCibo(TipologiaCibo.DESSERT);
		cibo9.setConservazione(Conservazione.FRIGO);

		Cibo cibo10 = new Cibo();
		cibo10.setNome("Croissant confezionato");
		cibo10.setDescrizione("Croissant a lunga conservazione");
		cibo10.setImgUrl("croissant.jpg");
		cibo10.setPrezzoUnitario(2.20);
		cibo10.setQnt(50);
		cibo10.setPeso(0.08);
		cibo10.setTipologiaCibo(TipologiaCibo.SNACK);
		cibo10.setConservazione(Conservazione.LUNGA_CONSERVAZIONE);

		// Salva tutti i cibi
		prodottoDao.save(cibo1);
		prodottoDao.save(cibo2);
		prodottoDao.save(cibo3);
		prodottoDao.save(cibo4);
		prodottoDao.save(cibo5);
		prodottoDao.save(cibo6);
		prodottoDao.save(cibo7);
		prodottoDao.save(cibo8);
		prodottoDao.save(cibo9);
		prodottoDao.save(cibo10);

		// ==========================
		//       10 BEVANDE
		// ==========================
		Bevanda b1 = new Bevanda();
		b1.setNome("Acqua naturale");
		b1.setDescrizione("Acqua in bottiglia");
		b1.setImgUrl("acqua_nat.jpg");
		b1.setPrezzoUnitario(0.40);
		b1.setQnt(200);
		b1.setVolume(500);
		b1.setTipologiaBevanda(TipologiaBevanda.BIBITA);

		Bevanda b2 = new Bevanda();
		b2.setNome("Acqua frizzante");
		b2.setDescrizione("Acqua frizzante in bottiglia");
		b2.setImgUrl("acqua_friz.jpg");
		b2.setPrezzoUnitario(0.50);
		b2.setQnt(180);
		b2.setVolume(500);
		b2.setTipologiaBevanda(TipologiaBevanda.BIBITA);

		Bevanda b3 = new Bevanda();
		b3.setNome("Coca Cola");
		b3.setDescrizione("Bibita gassata");
		b3.setImgUrl("cocacola.jpg");
		b3.setPrezzoUnitario(1.00);
		b3.setQnt(100);
		b3.setVolume(330);
		b3.setTipologiaBevanda(TipologiaBevanda.BIBITA);

		Bevanda b4 = new Bevanda();
		b4.setNome("Vino rosso");
		b4.setDescrizione("Bottiglia di vino rosso");
		b4.setImgUrl("vino_rosso.jpg");
		b4.setPrezzoUnitario(8.99);
		b4.setQnt(50);
		b4.setVolume(750);
		b4.setTipologiaBevanda(TipologiaBevanda.ALCOLICO);

		Bevanda b5 = new Bevanda();
		b5.setNome("Birra bionda");
		b5.setDescrizione("Birra chiara in lattina");
		b5.setImgUrl("birra_bionda.jpg");
		b5.setPrezzoUnitario(1.50);
		b5.setQnt(70);
		b5.setVolume(330);
		b5.setTipologiaBevanda(TipologiaBevanda.ALCOLICO);

		Bevanda b6 = new Bevanda();
		b6.setNome("Red Bull");
		b6.setDescrizione("Energy drink");
		b6.setImgUrl("redbull.jpg");
		b6.setPrezzoUnitario(2.00);
		b6.setQnt(60);
		b6.setVolume(250);
		b6.setTipologiaBevanda(TipologiaBevanda.ENERGY_DRINK);

		Bevanda b7 = new Bevanda();
		b7.setNome("Succo di frutta");
		b7.setDescrizione("Succo di pesca 100%");
		b7.setImgUrl("succo_pesca.jpg");
		b7.setPrezzoUnitario(1.20);
		b7.setQnt(90);
		b7.setVolume(200);
		b7.setTipologiaBevanda(TipologiaBevanda.SUCCO);

		Bevanda b8 = new Bevanda();
		b8.setNome("Tè freddo");
		b8.setDescrizione("Bevanda refrigerata al limone");
		b8.setImgUrl("te_freddo.jpg");
		b8.setPrezzoUnitario(1.30);
		b8.setQnt(80);
		b8.setVolume(500);
		b8.setTipologiaBevanda(TipologiaBevanda.REFRIGERATO);

		Bevanda b9 = new Bevanda();
		b9.setNome("Aranciata");
		b9.setDescrizione("Bibita analcolica all'arancia");
		b9.setImgUrl("aranciata.jpg");
		b9.setPrezzoUnitario(1.00);
		b9.setQnt(120);
		b9.setVolume(330);
		b9.setTipologiaBevanda(TipologiaBevanda.BIBITA);

		Bevanda b10 = new Bevanda();
		b10.setNome("Latte");
		b10.setDescrizione("Latte fresco refrigerato");
		b10.setImgUrl("latte.jpg");
		b10.setPrezzoUnitario(1.50);
		b10.setQnt(100);
		b10.setVolume(1000);
		b10.setTipologiaBevanda(TipologiaBevanda.REFRIGERATO);

		// Salva tutte le bevande
		prodottoDao.save(b1);
		prodottoDao.save(b2);
		prodottoDao.save(b3);
		prodottoDao.save(b4);
		prodottoDao.save(b5);
		prodottoDao.save(b6);
		prodottoDao.save(b7);
		prodottoDao.save(b8);
		prodottoDao.save(b9);
		prodottoDao.save(b10);

		// Facoltativo: verifica su console
		System.out.println("Inseriti 10 Cibi e 10 Bevande nel DB.");
	}

}
