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

package Main.PresentationLayer.Auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTProvider implements Serializable {

    // region Private Properties

    @Serial
    private static final long serialVersionUID = -2550185165626007488L;

    @Value("${jwt.validity_time}")
    private long jwtTokenValidity;

    @Value("${jwt.secret}")
    private String secret;

    // endregion Private Properties

    // region Public Methods

    /**
     * Method to get user name from a token.
     * @param token the given token.
     * @return user name.
     */
    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * Get the expiration date of the token.
     * @param token the given token.
     * @return the expiration date of the token.
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * Get the user properties.
     * @param token the given token.
     * @param claimsResolver provide context information about an auth request.
     * @param <T> is a generic type for the claim.
     * @return the claim resolver.
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Generate the token.
     * @param user the user details.
     * @return the token.
     */
    public String generateToken(@NonNull UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, user.getUsername());
    }

    /**
     * Verifies if the token is valid.
     * @param token the token to be verified.
     * @param user the user details.
     * @return if the token is valid or not.
     */
    public boolean isValidToken(String token, @NonNull UserDetails user) {
        String username = getUserNameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    // endregion Public Methods

    // region Private Methods

    /**
     * Function to get all the claims from the token.
     * @param token is the token.
     * @return the claims from the token.
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * Function to verify if the token has expired.
     * @param token is the token.
     * @return if the token is expired or not.
     */
    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * Function to generate a token.
     * @param claims is the context information about the request.
     * @param subject is the user.
     * @return the token.
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    // endregion Private Methods

}
