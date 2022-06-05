/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.PresentationLayer.Config;

import Main.PresentationLayer.Auth.CustomAuthEntryPoint;
import Main.PresentationLayer.Auth.CustomRequestFilter;
import Main.PresentationLayer.Auth.UserAuthDetailsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static Main.Util.ApplicationConst.APP_NAME;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // region Private Properties

    @Value("${api.prefix}")
    private String API_PREFIX;

    @Autowired
    private CustomAuthEntryPoint authEntryPoint;

    @Autowired
    private UserAuthDetailsProvider userAuthDetailsProvider;

    @Autowired
    private CustomRequestFilter requestFilter;

    // endregion Private Properties

    // region Public Methods

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    // endregion Public Methods

    // region Protected Methods


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/error").permitAll()
                .antMatchers(HttpMethod.PUT, API_PREFIX + "/user/login").permitAll()
                .antMatchers(HttpMethod.POST, API_PREFIX + "/user").permitAll()
                .antMatchers(HttpMethod.GET, API_PREFIX + "/user").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, API_PREFIX + "/user").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers(HttpMethod.GET, API_PREFIX + "/player").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers(HttpMethod.GET, API_PREFIX + "/player/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers(HttpMethod.GET, API_PREFIX + "/player/bestScorer").permitAll()
                .antMatchers(HttpMethod.POST, API_PREFIX + "/player").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, API_PREFIX + "/player/{id}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, API_PREFIX + "/player/{id}/player/{playerId}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, API_PREFIX + "/player").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, API_PREFIX + "/player/import").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers(HttpMethod.GET, API_PREFIX + "/team/detailed").permitAll()
                .antMatchers(HttpMethod.GET, API_PREFIX + "/team").anonymous()
                .antMatchers(HttpMethod.GET, API_PREFIX + "/team/{id}").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers( HttpMethod.PUT, APP_NAME + "/team/{id}/player/{playerId}").permitAll()
                .antMatchers(HttpMethod.POST, API_PREFIX + "/team").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, API_PREFIX + "/team/{id}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, API_PREFIX + "/team").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, API_PREFIX + "/team/import").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers(HttpMethod.GET, API_PREFIX + "/game").permitAll()
                .antMatchers(HttpMethod.GET, API_PREFIX + "/game/{id}/events").permitAll()
                .antMatchers(HttpMethod.GET, API_PREFIX + "/game/{id}").permitAll()
                .antMatchers(HttpMethod.POST, API_PREFIX + "/game").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, API_PREFIX + "/game/{id}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, API_PREFIX + "/game").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers(HttpMethod.POST, API_PREFIX + "/event").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")

                .antMatchers(HttpMethod.GET, API_PREFIX + "/exception").hasAnyAuthority("ROLE_ADMIN")

                .antMatchers( APP_NAME + "/").permitAll()
                .antMatchers( APP_NAME + "/home").permitAll()
                .antMatchers( APP_NAME + "/user/login").permitAll()
                .antMatchers( APP_NAME + "/user/processLogin").permitAll()
                .antMatchers( APP_NAME + "/user/logout").permitAll()
                .antMatchers( APP_NAME + "/user/create").permitAll()
                .antMatchers( HttpMethod.GET, APP_NAME + "/game").permitAll()
                .antMatchers( HttpMethod.POST, APP_NAME + "/game").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/team").permitAll()
                .antMatchers( HttpMethod.POST, APP_NAME + "/team").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/team/{id}").permitAll()
                .antMatchers( APP_NAME + "/team/delete/{id}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/team/{id}/player/{playerId}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/team/{id}/player").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/team/import").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( HttpMethod.GET, APP_NAME + "/player").permitAll()
                .antMatchers( HttpMethod.POST, APP_NAME + "/player").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/player/import").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/player/{id}").permitAll()
                .antMatchers( APP_NAME + "/player/delete/{id}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/game/{id}").permitAll()
                .antMatchers( APP_NAME + "/game/delete/{id}").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( HttpMethod.GET, APP_NAME + "/game").permitAll()
                .antMatchers( HttpMethod.POST, APP_NAME + "/game").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers( APP_NAME + "/game").permitAll()
                .antMatchers( APP_NAME + "/game/{id}/createEvent").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers( APP_NAME + "/statistics").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(l -> l.loginPage(APP_NAME + "/user/login").permitAll()
                        .loginProcessingUrl(APP_NAME + "/user/processLogin").permitAll()
                        .successForwardUrl(APP_NAME + "/home").permitAll()
                        .failureForwardUrl(APP_NAME + "/home").permitAll())
                .logout()
                .logoutUrl(APP_NAME + "/user/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl(APP_NAME + "/user/login")
                .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER);
        httpSecurity.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    // endregion Protected Methods

    // region Public Methods

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthDetailsProvider).passwordEncoder(passwordEncoder());
    }

    // endregion Public Methods

}
