package guru.springframework.netfluxexample.domain;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Component
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {

	private String id;
	
	@NonNull
	private String title;
	
}
