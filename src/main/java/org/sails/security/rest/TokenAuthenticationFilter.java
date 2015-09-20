package org.sails.security.rest;

import org.sails.security.service.TokenService;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nodirbek on 14.09.2015.
 */
public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public final String HEADER_SECURITY_TOKEN = "X-AuthenticationToken";
    private TokenService tokenService;

    protected TokenAuthenticationFilter(String defaultFilterProcessesUrl, TokenService tokenService) {
        super(defaultFilterProcessesUrl);
        super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(new NoOpAuthenticationManager());
        setAuthenticationSuccessHandler(new TokenSimpleUrlAuthenticationSuccessHandler());
        setTokenService(tokenService);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String userToken = httpServletRequest.getHeader(HEADER_SECURITY_TOKEN);
        Authentication authentication = this.tokenService.getAuthentication(userToken);
//        authentication.
        if (authentication == null) {
            throw new UsernameNotFoundException("Cannot fount user");
        }
        return authentication;
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }

    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }
}
