package gamerscreed.rocketstats.model.helpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import gamerscreed.rocketstats.model.beans.PlayerDetails;
import gamerscreed.rocketstats.model.entities.Player;
import gamerscreed.rocketstats.model.entities.Role;

public final class JwtUserFactory {

    private JwtUserFactory() { }

    public static PlayerDetails create(Player user) 
    {
    	return new PlayerDetails(
                (long) user.getId(),
                user.getUsername(),
                user.getName(),
                user.getName(),
                user.getName(),
                user.getToken(),
                mapToGrantedAuthorities(user.getRole()),
                true,
                Calendar.getInstance().getTime()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role role) {
    	List<GrantedAuthority> tGrantedAuthority = new ArrayList<GrantedAuthority>();
		tGrantedAuthority.add(new GrantedAuthority() {
			

			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return role.getRoleName();
			}
		});    	
    	return tGrantedAuthority;
    }
}