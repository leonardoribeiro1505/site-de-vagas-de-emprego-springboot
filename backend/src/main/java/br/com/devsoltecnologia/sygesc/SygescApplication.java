package br.com.devsoltecnologia.sygesc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SygescApplication implements CommandLineRunner {
	
//	@Autowired
//	private PessoaRepository pessoaRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SygescApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		Responsavel re1 = new Responsavel(null, "José", "321654987987", "321987654", "CE", sdf.parse("28/02/1965"), Genero.MASCULINO, "jose@email.com", 2000.00, sdf.parse("01/05/2018"));
//		Responsavel re2 = new Responsavel(null, "Glaucia", "585557777", "987654321", "CE", sdf.parse("18/05/1975"), Genero.FEMININO, "glaucia@email.com", 2500.00, sdf.parse("29/04/2018"));
//		
//		Aluno a1 = new Aluno(null, "Leonardo", "33333333333", "321654", "CE", sdf.parse("15/05/1986"), Genero.MASCULINO, "leo@email.com", sdf.parse("01/05/2018"), "654987", "livro 01", "fola 22", "Cartório Teste");
//		Aluno a2 = new Aluno(null, "Emanuela", "88888888888", "987654", "CE", sdf.parse("12/08/1997"), Genero.FEMININO, "manu@email.com", sdf.parse("29/04/2018"), "321654", "livro 10", "fola 10", "Cartório Itapiúna");
//		
//		re1.getDependentes().addAll(Arrays.asList(a1));
//		a1.getResponsaveis().addAll(Arrays.asList(re1));
//		
//		re2.getDependentes().addAll(Arrays.asList(a2));
//		a2.getResponsaveis().addAll(Arrays.asList(re2));
//		
//		pessoaRepository.saveAll(Arrays.asList(re1, re2, a1, a2));
		
		
	}
	
	
}
