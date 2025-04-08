package com.generation.alijava;

import com.generation.alijava.model.dao.ProdottoDao;
import com.generation.alijava.model.entities.Cibo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AlijavaApplicationTests
{
	@Autowired
	ProdottoDao daoao;

	@Test
	void contextLoads()
	{

		List<Cibo> tutti = daoao.leggiCibi();

		for(Cibo p : tutti)
			System.out.println(p);
	}

}
