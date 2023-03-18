package Mk.JD2_95_22.fitness.web.filtrs;

import java.io.IOException;
import java.util.List;



import Mk.JD2_95_22.fitness.web.util.JwtTokenUtil;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import static io.micrometer.common.util.StringUtils.isEmpty;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final IUserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    public JwtFilter(IUserService userService, JwtTokenUtil jwtTokenUtil) {
      this.userService = userService;
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

      // Get user identity and set it on the spring security context
      UserDetails userDetails = userService
              .loadUserByUsername(jwtTokenUtil.getUserName(token));

      UsernamePasswordAuthenticationToken
              authentication = new UsernamePasswordAuthenticationToken(
              userDetails, null,
              userDetails == null ?
                      List.of() : userDetails.getAuthorities()
      );

      authentication.setDetails(
              new WebAuthenticationDetailsSource().buildDetails(request)
      );

      SecurityContextHolder.getContext().setAuthentication(authentication);
      chain.doFilter(request, response);
  }
}
