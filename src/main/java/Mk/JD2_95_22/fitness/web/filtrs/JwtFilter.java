package Mk.JD2_95_22.fitness.web.filtrs;

import java.io.IOException;
import java.util.List;



import Mk.JD2_95_22.fitness.security.util.JwtUtils;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserNotFoundExeption;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import static io.micrometer.common.util.StringUtils.isEmpty;


public class JwtFilter extends OncePerRequestFilter {
  private final IUserService userService;

  public JwtFilter(IUserService userService) {
    this.userService = userService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain chain)
          throws ServletException, IOException {

    final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (isEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
      chain.doFilter(request, response);
      return;
    }

    final String token = authorizationHeader.split(" ")[1].trim();
    if (!JwtUtils.validate(token)) {
      chain.doFilter(request, response);
      return;
    }

    String jwt = null;
    UserDetails userModel = null;

    try {
      userModel = userService.loadUserByUsername(JwtUtils.extractUsername(token));
    } catch (UserNotFoundExeption e) {
      chain.doFilter(request, response);
      return;
    }


    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      jwt = authorizationHeader.substring(7);
    }
    if (userModel != null && SecurityContextHolder.getContext().getAuthentication() == null) {

      String commaSeparatedListOfAuthorities = JwtUtils.extractAuthorities(jwt);
      List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + commaSeparatedListOfAuthorities);
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
              new UsernamePasswordAuthenticationToken(
                      userModel, null, authorities);

      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

    }
    chain.doFilter(request, response);
  }
}
