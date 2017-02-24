package gamerscreed.rocketstats.model.dao.implementation;

import javax.persistence.TypedQuery;

import gamerscreed.rocketstats.model.dao.AbstractDAOLayer;
import gamerscreed.rocketstats.model.entities.Role;
import gamerscreed.rocketstats.utilities.enums.RoleDefinition;

public class RoleDAO extends AbstractDAOLayer<Role> {

	public Role getRoleByRoleName(RoleDefinition aRoleDefinition){
		TypedQuery<Role> query = this.entityManager.createNamedQuery("Role.findByName", Role.class);
		query.setParameter("roleName", aRoleDefinition.toString());
		
		return query.getSingleResult();
	}

	@Override
	public Role getById(int anId) {
		return this.entityManager.find(Role.class, anId);
	}
	
}
