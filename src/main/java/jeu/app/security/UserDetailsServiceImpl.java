/**
 * Class to get credentials of the user attempting to be authenticated
 */
package jeu.app.security;

import jeu.app.models.Joueur;
import jeu.app.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IAccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Joueur joueur = accountService.loadJoueurByUsername(username);
        if(joueur==null) throw new UsernameNotFoundException("invalid user");
        return new User(joueur.getUsername(),joueur.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
