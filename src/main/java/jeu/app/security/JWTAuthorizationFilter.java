package jeu.app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class to filter who is able to attempt a resource
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    static final Logger LOGGER = Logger.getLogger(JWTAuthorizationFilter.class);

    /**
     * before attempting the resource, check the token sending by the user
     * to verify whether he is authenticate or not
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jwtToken = request.getHeader(SecurityParams.JWT_HEADER_NAME);
        LOGGER.warn("JWT: "+jwtToken);
        System.out.println("Token = " + jwtToken);
        if (jwtToken == null || !jwtToken.startsWith(SecurityParams.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        //Algorithm to hash the secret part of JWT
        Algorithm algorithm = Algorithm.HMAC256(SecurityParams.PRIVATE_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        String jwt = jwtToken.substring(SecurityParams.TOKEN_PREFIX.length(), jwtToken.length());
        DecodedJWT decodedJWT = verifier.verify(jwt);
        String username = decodedJWT.getSubject();
        LOGGER.debug("username: " + username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
