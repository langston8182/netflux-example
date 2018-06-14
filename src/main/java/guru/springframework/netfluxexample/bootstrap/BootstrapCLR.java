package guru.springframework.netfluxexample.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.netfluxexample.domain.Movie;
import guru.springframework.netfluxexample.repositories.MovieRepository;
import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner {

	private final MovieRepository movieRepository;
	
	@Autowired
	public BootstrapCLR(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		movieRepository.deleteAll()
			.thenMany(
			Flux.just("Silence of the Lambdas", "AEon flux", "Enter the Mono<Void>", "The Fluxxinator", 
					"Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
				.map(title -> new Movie(title))
				.flatMap(movieRepository::save))
				.subscribe(null, null, () -> {
					movieRepository.findAll().subscribe(System.out::println);
				});

	}
}
