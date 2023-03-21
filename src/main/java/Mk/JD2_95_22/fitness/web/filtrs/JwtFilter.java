package Mk.JD2_95_22.fitness.web.filtrs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Mk.JD2_95_22.fitness.core.dto.model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserDetailsDTO;
import Mk.JD2_95_22.fitness.servise.api.user.IAuthenticationUserService;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import Mk.JD2_95_22.fitness.web.util.JwtTokenHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import static io.micrometer.common.util.StringUtils.isEmpty;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final IUserService service;
    private final JwtTokenHandler jwtTokenUtil;

    public JwtFilter(IUserService service, JwtTokenHandler jwtTokenUtil) {
      this.service = service;
      this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

      final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
      if (isEmpty(header) || !header.startsWith("Bearer ")) {
        chain.doFilter(request, response);
        return;
      }

      // Get jwt token and validate
      final String token = header.split(" ")[1].trim();
      if (!jwtTokenUtil.validate(token)) {
        chain.doFilter(request, response);
        return;
      }

      UserDTO user = service.getUsers(jwtTokenUtil.getUserName(token));
      List<SimpleGrantedAuthority> list = new ArrayList<>();
      list.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

      UsernamePasswordAuthenticationToken
              authentication = new UsernamePasswordAuthenticationToken(
              user, null,
              list);

      authentication.setDetails(
              new WebAuthenticationDetailsSource().buildDetails(request)
      );

      SecurityContextHolder.getContext().setAuthentication(authentication);
      chain.doFilter(request, response);
  }
}
