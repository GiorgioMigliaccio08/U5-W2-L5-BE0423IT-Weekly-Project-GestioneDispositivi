package giorgiomigliaccio.U5W1L5.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Disabilitiamo alcuni comportamenti di default
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // Aggiungiamo filtri custom
        // Aggiungere/Rimuovere regole di protezione su singoli endpoint
        // in maniera che venga/non venga richiesta l'autenticazione per accedervi
        httpSecurity.authorizeHttpRequests(request -> request.requestMatchers("/auth/**").permitAll());

        @Bean
        PasswordEncoder getPWEncoder() {
            return new BCryptPasswordEncoder(11);
            // 11 è il numero di ROUNDS, ovvero quante volte viene eseguito l'algoritmo. Ci serve per impostare la velocità di esecuzione
            // di BCrypt. Più è alto il numero, più lento sarà l'algoritmo, più sicure saranno le password. Di contro più è lento l'algoritmo
            // e peggiore sarà la User Experience. Bisogna trovare il giusto bilanciamento tra le 2.
            // 11 significa che l'algoritmo verrà eseguito 2^11 volte 2048 volte
        }

        return httpSecurity.build();
    }
}