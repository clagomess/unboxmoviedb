package com.github.clagomess.unboxmoviedb.service;

import com.github.clagomess.unboxmoviedb.UserRepositoryUserDetails;
import com.github.clagomess.unboxmoviedb.entity.Usuario;
import com.github.clagomess.unboxmoviedb.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UnboxMovieDbUserDetailsService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByDesEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuário <%s> não existe!", username));
        }

        return new UserRepositoryUserDetails(usuario);
    }
}
